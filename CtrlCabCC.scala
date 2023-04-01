package controllers

import com.meteora._
import play.api.libs.json.Json
import play.api.mvc._


import scala.language.postfixOps

class CtrlCabCC extends Controller {

	def getCabCC(vendedor: String) = Action { request =>
			val cabcc = CabCC.getCabCC(vendedor)
			Ok(Json.toJson(cabcc))
	}

	def salvarCabCC = Action { request =>
		val cabcc = request.body.asJson.get.as[CabCC]
		val response = CabCC.salvarCabCC(cabcc)
		Ok(Json.toJson(response))
	}

}