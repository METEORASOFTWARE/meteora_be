package controllers

import com.meteora._
import play.api.libs.json.Json
import play.api.mvc._


import scala.language.postfixOps

class CtrlProveedores extends Controller {

	def getVendedor(codigo: String) = Action { request =>
			val vendedor = Proveedor.getVendedor(codigo)
			Ok(Json.toJson(vendedor))
	}
}