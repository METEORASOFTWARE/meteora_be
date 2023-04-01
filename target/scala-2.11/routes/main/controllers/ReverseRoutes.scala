
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/amerc/meteora_be/conf/routes
// @DATE:Thu Mar 16 07:48:43 COT 2023

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:5
package controllers {

  // @LINE:12
  class ReverseCtrlProductos(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def getProductos(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "productos/")
    }
  
  }

  // @LINE:10
  class ReverseCtrlClientes(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def getClientes(vendedor:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "clientes/" + implicitly[PathBindable[String]].unbind("vendedor", dynamicString(vendedor)))
    }
  
  }

  // @LINE:14
  class ReverseCtrlCabCC(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def salvarCabCC(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "cabcc/")
    }
  
    // @LINE:14
    def getCabCC(vendedor:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "cabcc/" + implicitly[PathBindable[String]].unbind("vendedor", dynamicString(vendedor)))
    }
  
  }

  // @LINE:7
  class ReverseCtrlUsuarios(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def getUsuario(codigo:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "usuario/" + implicitly[PathBindable[String]].unbind("codigo", dynamicString(codigo)))
    }
  
    // @LINE:8
    def updateUsuario(): Call = {
      import ReverseRouteContext.empty
      Call("PUT", _prefix + { _defaultPrefix } + "usuario/update/")
    }
  
  }

  // @LINE:5
  class ReverseCtrlProveedores(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def getVendedor(codigo:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "vendedor/" + implicitly[PathBindable[String]].unbind("codigo", dynamicString(codigo)))
    }
  
  }

  // @LINE:17
  class ReverseCtrlDetCC(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def getByNumtrans(numtrans:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "detcc/numtrans/" + implicitly[PathBindable[Long]].unbind("numtrans", numtrans))
    }
  
    // @LINE:19
    def salvarDetCC(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "detcc/")
    }
  
    // @LINE:17
    def getDetCC(vendedor:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "detcc/" + implicitly[PathBindable[String]].unbind("vendedor", dynamicString(vendedor)))
    }
  
  }


}