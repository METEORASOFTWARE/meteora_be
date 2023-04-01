package com.meteora


import java.util.Date

import anorm._
//import org.joda.time.DateTime
import play.api.Play.current
import play.api.db._
import play.api.libs.json.Json
import scala.collection.mutable
import scala.language.postfixOps

/**
  * Modelo de datos tabla T_PROVEEDORES xxx
  */
case class CabCC (
	tipo: Option[String],
	num_trans: Option[Long],
	cod_clie: Option[String],
	nom_clie: Option[String],
	tipo_interno: Option[String],
	tipo_internoDesc: Option[String],
	fec_trans: Option[Date],
	sfec_trans: Option[String],
	cod_ven: Option[String],
	doc_externo1: Option[String],
	identificacion: Option[String],
	valor_total: Option[BigDecimal],
	Svalor_total: Option[String],
	status: Option[String],
	tipo_trans_otra2: Option[String],
	num_trans_otra2: Option[Long]
)

object CabCC {

	val tipo_internoDescription = new mutable.HashMap[String,String]()
	tipo_internoDescription += (
		"0" -> "Sin Enviar",
		"1" -> "Enviado sin confirmar",
		"Z" -> "Precotización",
		"C" -> "Cotizado",
		"O" -> "Orden de Pedido",
		"E" -> "Compras Programadas",
		"L" -> "Lista para Facturar",
		"S" -> "FS Anticipada",
		"N" -> "Cambia Número",
		"P" -> "Perdida",
		"R" -> "Perdida parcialmente",
		"F" -> "Facturada",
		"T" -> "Facturada parcialmente",
		"A" -> "Anulada"	)

	implicit val format = Json.format[CabCC]

	// Constructor automático 
	val parser = {
		for {
			tipo <- SqlParser.get[Option[String]]("TIPO")
			num_trans <- SqlParser.get[Long]("NUM_TRANS")
			cod_clie <- SqlParser.get[Option[String]]("COD_CLIE")
			nom_clie <- SqlParser.get[Option[String]]("NOM_CLIE")
			tipo_interno <- SqlParser.get[Option[String]]("TIPO_INTERNO")
			fec_trans <- SqlParser.get[Option[Date]]("FEC_TRANS")
			sfec_trans  <- SqlParser.get[Option[String]]("SFEC_TRANS")
			cod_ven <- SqlParser.get[Option[String]]("COD_VEN")
			doc_externo1 <- SqlParser.get[Option[String]]("NUMERO_TERCERO")
			identificacion <- SqlParser.get[Option[String]]("DIRECCION")
			valor_total <- SqlParser.get[Option[BigDecimal]]("VALOR_TOTAL")
			svalor_total <- SqlParser.get[Option[String]]("SVALOR_TOTAL")
			status <- SqlParser.get[Option[String]]("STATUS")
			tipo_trans_otra2 <- SqlParser.get[Option[String]]("TIPO_TRANS_OTRA2")
			num_trans_otra2 <- SqlParser.get[Option[Long]]("NUM_TRANS_OTRA2")

		} yield {
			CabCC(
				Some(tipo.getOrElse("").trim),
				Some(num_trans),
				Some(cod_clie.getOrElse("").trim),
				Some(nom_clie.getOrElse("").trim),
				Some(tipo_interno.getOrElse("").trim),
				Some(tipo_internoDescription(tipo_interno.getOrElse("").trim)),
				fec_trans,
				Some(sfec_trans.getOrElse("").trim),
				Some(cod_ven.getOrElse("").trim),
				Some(doc_externo1.getOrElse("").trim),
				Some(identificacion.getOrElse("").trim),
				valor_total,
				Some(svalor_total.getOrElse("").trim),
				Some(status.getOrElse("").trim),
				Some(tipo_trans_otra2.getOrElse("").trim),
				num_trans_otra2
			)
		}
	}

	def getCabCC(vendedor: String) = {
		DB.withConnection { implicit connection =>
			SQL(
				"""
					SELECT 	T_CAB_TRANSINV.TIPO,
							T_CAB_TRANSINV.NUM_TRANS,
							T_CAB_TRANSINV.COD_CLIE,
							T_CLIENTES.NOM_CLIE,
							T_CAB_TRANSINV.TIPO_INTERNO,
							T_CAB_TRANSINV.FEC_TRANS,
							convert(char(10),T_CAB_TRANSINV.FEC_TRANS , 112) 	as SFEC_TRANS,		
							T_CAB_TRANSINV.COD_VEN,
							T_CAB_TRANSINV.NUMERO_TERCERO,
							T_CAB_TRANSINV.DIRECCION,
							T_TOT_TRANSINV.TOTAL_ITEMS_PESOS_T as VALOR_TOTAL,
							'1' as STATUS,
							T_CAB_TRANSINV.TIPO_TRANS_OTRA2,
							T_CAB_TRANSINV.NUM_TRANS_OTRA2,
							convert(char(20),T_TOT_TRANSINV.TOTAL_ITEMS_PESOS_T) 	as SVALOR_TOTAL
					from 	T_CAB_TRANSINV, T_CLIENTES, T_TOT_TRANSINV
					where 	T_CAB_TRANSINV.TIPO='CC' And 
							T_CAB_TRANSINV.COD_CLIE=T_CLIENTES.COD_CLIE AND 
							T_TOT_TRANSINV.TIPO=T_CAB_TRANSINV.TIPO AND 
							T_TOT_TRANSINV.NUM_TRANS=T_CAB_TRANSINV.NUM_TRANS AND 
							T_CAB_TRANSINV.COD_VEN = {vendedor}
					order by T_CAB_TRANSINV.NUM_TRANS DESC
				""")
				.on('vendedor -> vendedor)
				.as(parser.*)
		}
	}

	def salvarCabCC (cabcc: CabCC) = {
		DB.withConnection { implicit connection =>
			SQL(
				"""
					INSERT INTO T_CAB_TRGEN (
						TIPO,
						NUM_TRANS,
						COD_CLIE,
						TEXTO_1,
						TEXTO_2,
						COD_VEN,
						STATUS
					) OUTPUT INSERTED.CONSECUTIVO
					VALUES (
						{tipo},
						{num_trans},
						{cod_clie},
						{doc_externo1},
						{identificacion},
						{cod_ven},
						{status}
					);
				""")
				.on('tipo     	    -> cabcc.tipo,
					'num_trans      -> cabcc.num_trans,
					'cod_clie       -> cabcc.cod_clie,
					'doc_externo1   -> cabcc.doc_externo1,
					'identificacion -> cabcc.identificacion,
					'cod_ven        -> cabcc.cod_ven,
					'status 		-> "0"
				)
				.executeQuery()
				.as(SqlParser.scalar[Long].single)
		}
	}

}