package controllers

import com.meteora._
import play.api.libs.json.Json
import play.api.mvc._


import scala.language.postfixOps

class CtrlDetCC extends Controller {

	def getByNumtrans (numtrans: Long) = Action { request =>
			val detcc = DetCC.getByNumtrans(numtrans)
			Ok(Json.toJson(detcc))
	}

	def getDetCC(vendedor: String) = Action { request =>
			val detcc = DetCC.getDetCC(vendedor)
			Ok(Json.toJson(detcc))
	}

	def salvarDetCC = Action { request =>
		val detcc = request.body.asJson.get.as[DetCC]
		val response = DetCC.salvarDetCC(detcc)
		Ok(Json.toJson(response))
	}


}