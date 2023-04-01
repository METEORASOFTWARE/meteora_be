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
  * Modelo de datos tabla T_USUARIOS
  */
case class Usuario (
	codigo_usuario: Option[String],
	nombre_usuario: Option[String],
	remdir: Option[String],
	remst: Option[String],
	remstDesc: Option[String],
	ll_a24: Option[Long],
	remfh: Option[Date],
	cod_ven: Option[String]
)

object Usuario {

	val remstDescription = new mutable.HashMap[String,String]()
	remstDescription += (
		""  -> "Desconectado",
		"0" -> "Desconectado",
		"1" -> "Conectado",
		"2" -> "Solicitando conexión",
		"X" -> "Clave errada",
		"Y" -> "Usuario sin Licencia de Acceso",
		"A" -> "Usuario sin Vendedor asociado"	)


	implicit val format = Json.format[Usuario]

	// Constructor automático 
	val parser = {
		for {
			codigo_usuario <- SqlParser.get[Option[String]]("CODIGO_USUARIO")
			nombre_usuario <- SqlParser.get[Option[String]]("NOMBRE_USUARIO")
			remdir <- SqlParser.get[Option[String]]("REMDIR")
			remst <- SqlParser.get[Option[String]]("REMST")
			ll_a24 <- SqlParser.get[Option[Long]]("LL_A24")
			remfh <- SqlParser.get[Option[Date]]("REMFH")
			vendedor <- SqlParser.get[Option[String]]("VENDEDOR")
		} yield {
			Usuario(
				Some(codigo_usuario.getOrElse("").trim),
				Some(nombre_usuario.getOrElse("").trim),
				Some(remdir.getOrElse("").trim),
				Some(remst.getOrElse("").trim),
				Some(remstDescription(remst.getOrElse("").trim)),
				ll_a24,
				remfh,
				Some(vendedor.getOrElse("").trim)
			)
		}
	}

	def getUsuario(codigo_usuario: String) = {
		DB.withConnection { implicit connection =>
			SQL(
				"""
					SELECT 	T_USUARIOS.CODIGO_USUARIO,
							NOMBRE_USUARIO,
							REMDIR,
							REMST,
							LL_A24,
							REMFH,
							T_PREFERENCIAS.VENDEDOR 
					from 	T_USUARIOS, T_PREFERENCIAS
					where 	(T_USUARIOS.CODIGO_USUARIO = T_PREFERENCIAS.CODIGO_USUARIO) AND
							T_USUARIOS.CODIGO_USUARIO = {codigo_usuario} 
				""")
				.on('codigo_usuario -> codigo_usuario)
				.as(parser.*)
		}
	}	

	def updateUsuario(usuario: Usuario): Option[Usuario] = {
		DB.withConnection { implicit connection =>
			SQL(
				"""
					UPDATE T_USUARIOS
					SET
						REMDIR = {remdir},
						REMST  = {remst},
						LL_A24 = {ll_a24},
						REMFH = {remfh}
					WHERE
						CODIGO_USUARIO = {codigo_usuario};
				""")
				.on(
					'codigo_usuario -> usuario.codigo_usuario,
					'remdir 		-> usuario.remdir,
					'remst   		-> usuario.remst,
					'll_a24			-> usuario.ll_a24,
					'remfh 			-> new Date())
				.executeUpdate() match {
					case 1 => Some(usuario)
					case _ => None
				}
			
		}
	}
}

//
// ENSAYO INNECESARIO 1.21.092
//
/*case class Usuario2 (
	codigo_usuario: Option[String],
	nombre_usuario: Option[String],
	cod_ven: Option[String]
)

object Usuario2 {

	implicit val format = Json.format[Usuario2]

	val parser2 = {
		for {
			codigo_usuario <- SqlParser.get[Option[String]]("CODIGO_USUARIO")
			nombre_usuario <- SqlParser.get[Option[String]]("NOMBRE_USUARIO")
			vendedor <- SqlParser.get[Option[String]]("VENDEDOR")
		} yield {
			Usuario2(
				Some(codigo_usuario.getOrElse("").trim),
				Some(nombre_usuario.getOrElse("").trim),
				Some(vendedor.getOrElse("").trim)
			)
		}
	}

/*							REMDIR,
							REMST,*/
	def getUsuario2(codigo_usuario: String) = {
		DB.withConnection { implicit connection =>
			SQL(
				"""
					SELECT 	T_USUARIOS.CODIGO_USUARIO,
							NOMBRE_USUARIO,
							T_PREFERENCIAS.VENDEDOR 
					from 	T_USUARIOS, T_PREFERENCIAS
					where 	(T_USUARIOS.CODIGO_USUARIO = T_PREFERENCIAS.CODIGO_USUARIO) AND
							T_USUARIOS.CODIGO_USUARIO = {codigo_usuario} 
				""")
				.on('codigo_usuario -> codigo_usuario)
				.as(parser2.*)
		}
	}		
}*/