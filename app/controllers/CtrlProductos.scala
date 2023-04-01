package controllers

import com.meteora._
import play.api.libs.json.Json
import play.api.mvc._


import scala.language.postfixOps

class CtrlProductos extends Controller {

	def getProductos() = Action { request =>
			val productos = Producto.getProductos()
			Ok(Json.toJson(productos))
	}
}