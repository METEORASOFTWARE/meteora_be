package com.meteora


import java.util.Date

import anorm._
//import org.joda.time.DateTime
import play.api.Play.current
import play.api.db._
import play.api.libs.json.Json

import scala.language.postfixOps

/**
  * Modelo de datos tabla T_PROVEEDORES
  */
case class Producto (
	cod_producto: Option[String],
	nom_producto: Option[String],
	sw_inactivo: Option[String],
	precio_1: Option[BigDecimal],
	agrupacion_grupo: Option[Long],
	agrupacion_ppv: Option[Long]
)

object Producto {

	implicit val format = Json.format[Producto]

	// Constructor automático 
	val parser = {
		for {
			cod_producto <- SqlParser.get[Option[String]]("COD_PRODUCTO")
			nom_producto <- SqlParser.get[Option[String]]("NOM_PRODUCTO")
			sw_inactivo <- SqlParser.get[Option[String]]("SW_INACTIVO")
			precio_1 <-  SqlParser.get[Option[BigDecimal]]("PRECIO_1")
			agrupacion_grupo <- SqlParser.get[Option[Long]]("AGRUPACION_GRUPO")
			agrupacion_ppv <- SqlParser.get[Option[Long]]("AGRUPACION_PPV")

		} yield {
			Producto(
				Some(cod_producto.getOrElse("").trim),
				Some(nom_producto.getOrElse("").trim),
				Some(sw_inactivo.getOrElse("").trim),
				precio_1,
				agrupacion_grupo,
				agrupacion_ppv
			)
		}
	}

	def getProductos() = {
		DB.withConnection { implicit connection =>
			SQL(
				"""
					SELECT 	COD_PRODUCTO,
							NOM_PRODUCTO,
							SW_INACTIVO ,
							PRECIO_1,
							AGRUPACION_GRUPO,
							AGRUPACION_PPV
					from 	T_PRODUCTOS 
					where 	SW_INACTIVO=1 And 
							AGRUPACION_GRUPO IN (SELECT T_NIVEL_a.COD_NIVEL FROM T_NIVEL T_NIVEL_a, T_NIVEL T_NIVEL_b
   												 WHERE (T_NIVEL_a.COD_BASE = 'G' ) AND 
   												       (T_NIVEL_B.COD_NIVEL = T_NIVEL_A.COD_ANTERIOR) and 
         												(T_NIVEL_a.COD_ANTERIOR in (SELECT T_NIVEL.COD_NIVEL FROM T_NIVEL 
  																					WHERE (T_NIVEL.COD_BASE = 'G') AND  
         																				  (T_NIVEL.VALOR_STRING20_7 = '1')))
												)
					order by NOM_PRODUCTO
				""")
				.as(parser.*)
		}
	}
}