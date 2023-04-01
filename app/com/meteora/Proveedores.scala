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
case class Proveedor (
	cod_prov: Option[String],
	nom_prov: Option[String],
	tipo_proveedor: Option[String],
	e_mail: Option[String]
)

object Proveedor {

	implicit val format = Json.format[Proveedor]

	// Constructor automático de Carriers
	val parser = {
		for {
			cod_prov <- SqlParser.get[Option[String]]("COD_PROV")
			nom_prov <- SqlParser.get[Option[String]]("NOM_PROV")
			tipo_proveedor <- SqlParser.get[Option[String]]("TIPO_PROVEEDOR")
			e_mail <- SqlParser.get[Option[String]]("E_MAIL")
		} yield {
			Proveedor(
				Some(cod_prov.getOrElse("").trim),
				Some(nom_prov.getOrElse("").trim),
				Some(tipo_proveedor.getOrElse("").trim),
				Some(e_mail.getOrElse("").trim)
			)
		}
	}

	def getVendedor(cod_prov: String) = {
		DB.withConnection { implicit connection =>
			SQL(
				"""
					SELECT 	COD_PROV 		as COD_PROV,
							NOM_PROV 		as NOM_PROV,
							TIPO_PROVEEDOR 	as TIPO_PROVEEDOR,
							E_MAIL 			as E_MAIL
					from 	T_PROVEEDORES 
					where 	COD_PROV = {cod_prov} and 
							TIPO_PROVEEDOR='V'
				""")
				.on('cod_prov -> cod_prov)
				.as(parser.*)
		}
	}
}