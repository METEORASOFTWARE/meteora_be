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
case class Cliente (
	cod_clie: Option[String],
	nom_clie: Option[String],
	sw_inactivo: Option[Long],
	cod_macroclie: Option[String],
	cod_ven: Option[String]
)

object Cliente {

	implicit val format = Json.format[Cliente]

	// Constructor automático de Carriers
	val parser = {
		for {
			cod_clie <- SqlParser.get[Option[String]]("COD_CLIE")
			nom_clie <- SqlParser.get[Option[String]]("NOM_CLIE")
			sw_inactivo <- SqlParser.get[Long]("SW_INACTIVO")
			cod_macroclie <- SqlParser.get[Option[String]]("COD_MACROCLIE")
			cod_ven <- SqlParser.get[Option[String]]("COD_VEN")

		} yield {
			Cliente(
				Some(cod_clie.getOrElse("").trim),
				Some(nom_clie.getOrElse("").trim),
				Some(sw_inactivo),
				Some(cod_macroclie.getOrElse("").trim),
				Some(cod_ven.getOrElse("").trim)
			)
		}
	}

	def getClientes(vendedor: String) = {
		DB.withConnection { implicit connection =>
			SQL(
				"""
					SELECT 	COD_CLIE 		as COD_CLIE,
							NOM_CLIE 		as NOM_CLIE,
							SW_INACTIVO 	as SW_INACTIVO,
							COD_MACROCLIE 	as COD_MACROCLIE,
							COD_VEN
					from 	T_CLIENTES 
					where 	COD_VEN = {vendedor} and 
							SW_INACTIVO=1 And 
							TIPO_CLIENTE='C' AND
							COD_MACROCLIE IN (SELECT COD_MACROCLIE FROM T_MACROCLIENTES WHERE T_MACROCLIENTES.A24_SW = '1')
					order by NOM_CLIE
				""")
				.on('vendedor -> vendedor)
				.as(parser.*)
		}
	}
}