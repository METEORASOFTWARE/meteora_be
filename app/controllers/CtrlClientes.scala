package controllers

import com.meteora._
import play.api.libs.json.Json
import play.api.mvc._


import scala.language.postfixOps

class CtrlClientes extends Controller {

	def getClientes(vendedor: String) = Action { request =>
			val clientes = Cliente.getClientes(vendedor)
			Ok(Json.toJson(clientes))
	}
}