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
case class DetCC (
	tipo: Option[String],
	num_trans: Option[Long],
	cod_producto: Option[String],
	nom_producto: Option[String],
	pre_cantidad_sale: Option[BigDecimal],
	valor_unit_pesos_t: Option[BigDecimal],
	cod_ven: Option[String],
	status: Option[String]
)

object DetCC {

	implicit val format = Json.format[DetCC]

	// Constructor automático 
	val parser = {
		for {
			tipo <- SqlParser.get[Option[String]]("TIPO")
			num_trans <- SqlParser.get[Long]("NUM_TRANS")
			cod_producto <- SqlParser.get[Option[String]]("COD_PRODUCTO")
			nom_producto <- SqlParser.get[Option[String]]("NOM_PRODUCTO")
			pre_cantidad_sale <- SqlParser.get[Option[BigDecimal]]("PRE_CANTIDAD_SALE")
			valor_unit_pesos_t <- SqlParser.get[Option[BigDecimal]]("VALOR_UNIT_PESOS_T")
			cod_ven <- SqlParser.get[Option[String]]("COD_VEN")
			status <- SqlParser.get[Option[String]]("STATUS")
			
		} yield {
			DetCC(
				Some(tipo.getOrElse("").trim),
				Some(num_trans),
				Some(cod_producto.getOrElse("").trim),
				Some(nom_producto.getOrElse("").trim),
				pre_cantidad_sale,
				valor_unit_pesos_t,
				Some(cod_ven.getOrElse("").trim),
				Some(status.getOrElse("").trim)
			)
		}
	}

	def getByNumtrans (numtrans: Long) = {
		DB.withConnection { implicit connection =>
			SQL(
				"""
				SELECT 	T_DET_TRANSINV.TIPO,
						T_DET_TRANSINV.NUM_TRANS,
						T_DET_TRANSINV.COD_PRODUCTO,
						T_PRODUCTOS.NOM_PRODUCTO,
						T_DET_TRANSINV.PRE_CANTIDAD_SALE,
						T_DET_TRANSINV.VALOR_UNIT_PESOS_T,
						T_CAB_TRANSINV.COD_VEN,
						'1'  as STATUS
				from 	T_DET_TRANSINV, T_PRODUCTOS, T_CAB_TRANSINV
				where 	T_DET_TRANSINV.TIPO='CC' And 
						T_DET_TRANSINV.COD_PRODUCTO=T_PRODUCTOS.COD_PRODUCTO AND 
						T_DET_TRANSINV.TIPO=T_CAB_TRANSINV.TIPO AND 
						T_DET_TRANSINV.NUM_TRANS=T_CAB_TRANSINV.NUM_TRANS AND 
						T_CAB_TRANSINV.NUM_TRANS = {numtrans}
				""")
				.on('numtrans -> numtrans)
				.as(parser.*)
		}
	}

	def getDetCC(vendedor: String) = {
		DB.withConnection { implicit connection =>
			SQL(
				"""
					SELECT 	T_DET_TRANSINV.TIPO,
							T_DET_TRANSINV.NUM_TRANS,
							T_DET_TRANSINV.COD_PRODUCTO,
							T_PRODUCTOS.NOM_PRODUCTO,
							T_DET_TRANSINV.PRE_CANTIDAD_SALE,
							T_DET_TRANSINV.VALOR_UNIT_PESOS_T,
							T_CAB_TRANSINV.COD_VEN,
							'1'  as STATUS
					from 	T_DET_TRANSINV, T_PRODUCTOS, T_CAB_TRANSINV
					where 	T_DET_TRANSINV.TIPO='CC' And 
							T_DET_TRANSINV.COD_PRODUCTO=T_PRODUCTOS.COD_PRODUCTO AND 
							T_DET_TRANSINV.TIPO=T_CAB_TRANSINV.TIPO AND 
							T_DET_TRANSINV.NUM_TRANS=T_CAB_TRANSINV.NUM_TRANS AND 
							T_CAB_TRANSINV.COD_VEN = {vendedor}
					order by T_DET_TRANSINV.NUM_TRANS DESC
				""")
				.on('vendedor -> vendedor)
				.as(parser.*)
		}
	}

	def salvarDetCC (detcc: DetCC) = {
		DB.withConnection { implicit connection =>
			SQL(
				"""
					INSERT INTO T_DET_TRGEN (
						TIPO,
						NUM_TRANS,
						COD_PRODUCTO,
						PRE_CANTIDAD_SALE,
						VALOR_UNIT_PESOS_T,
						COD_VEN,
						STATUS
					) OUTPUT INSERTED.CONSECUTIVO
					VALUES (
						{tipo},
						{num_trans},
						{cod_producto},
						{pre_cantidad_sale},
						{valor_unit_pesos_t},
						{cod_ven},
						{status}
					);
				""")
				.on('tipo     	        -> detcc.tipo,
					'num_trans          -> detcc.num_trans,
					'cod_producto       -> detcc.cod_producto,
					'pre_cantidad_sale  -> detcc.pre_cantidad_sale,
					'valor_unit_pesos_t -> detcc.valor_unit_pesos_t,
					'cod_ven            -> detcc.cod_ven,
					'status 		    -> "0"
				)
				.executeQuery()
				.as(SqlParser.scalar[Long].single)
		}
	}




}