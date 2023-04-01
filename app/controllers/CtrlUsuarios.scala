package controllers

import com.meteora._
import play.api.libs.json.Json
import play.api.mvc._


import scala.language.postfixOps

class CtrlUsuarios extends Controller {

	def getUsuario(codigo: String) = Action { request =>
			val usuario = Usuario.getUsuario(codigo)
			Ok(Json.toJson(usuario))
	}

	def updateUsuario = Action { request =>
		val usuario = request.body.asJson.get.as[Usuario]
		Usuario.updateUsuario(usuario) match {
			case Some(usuario) => Ok(Json.toJson(usuario))
			case None => NotFound
		}
	}	
}