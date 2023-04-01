
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/amerc/meteora_be/conf/routes
// @DATE:Thu Mar 16 07:48:43 COT 2023

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:5
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:12
  class ReverseCtrlProductos(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def getProductos: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CtrlProductos.getProductos",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "productos/"})
        }
      """
    )
  
  }

  // @LINE:10
  class ReverseCtrlClientes(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def getClientes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CtrlClientes.getClientes",
      """
        function(vendedor) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "clientes/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("vendedor", encodeURIComponent(vendedor))})
        }
      """
    )
  
  }

  // @LINE:14
  class ReverseCtrlCabCC(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def salvarCabCC: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CtrlCabCC.salvarCabCC",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "cabcc/"})
        }
      """
    )
  
    // @LINE:14
    def getCabCC: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CtrlCabCC.getCabCC",
      """
        function(vendedor) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cabcc/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("vendedor", encodeURIComponent(vendedor))})
        }
      """
    )
  
  }

  // @LINE:7
  class ReverseCtrlUsuarios(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def getUsuario: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CtrlUsuarios.getUsuario",
      """
        function(codigo) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "usuario/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("codigo", encodeURIComponent(codigo))})
        }
      """
    )
  
    // @LINE:8
    def updateUsuario: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CtrlUsuarios.updateUsuario",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "usuario/update/"})
        }
      """
    )
  
  }

  // @LINE:5
  class ReverseCtrlProveedores(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def getVendedor: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CtrlProveedores.getVendedor",
      """
        function(codigo) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "vendedor/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("codigo", encodeURIComponent(codigo))})
        }
      """
    )
  
  }

  // @LINE:17
  class ReverseCtrlDetCC(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def getByNumtrans: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CtrlDetCC.getByNumtrans",
      """
        function(numtrans) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "detcc/numtrans/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("numtrans", numtrans)})
        }
      """
    )
  
    // @LINE:19
    def salvarDetCC: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CtrlDetCC.salvarDetCC",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "detcc/"})
        }
      """
    )
  
    // @LINE:17
    def getDetCC: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CtrlDetCC.getDetCC",
      """
        function(vendedor) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "detcc/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("vendedor", encodeURIComponent(vendedor))})
        }
      """
    )
  
  }


}