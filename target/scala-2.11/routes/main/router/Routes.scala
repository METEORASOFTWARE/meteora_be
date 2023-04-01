
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/amerc/meteora_be/conf/routes
// @DATE:Thu Mar 16 07:48:43 COT 2023

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:5
  CtrlProveedores_4: controllers.CtrlProveedores,
  // @LINE:7
  CtrlUsuarios_3: controllers.CtrlUsuarios,
  // @LINE:10
  CtrlClientes_0: controllers.CtrlClientes,
  // @LINE:12
  CtrlProductos_5: controllers.CtrlProductos,
  // @LINE:14
  CtrlCabCC_1: controllers.CtrlCabCC,
  // @LINE:17
  CtrlDetCC_2: controllers.CtrlDetCC,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:5
    CtrlProveedores_4: controllers.CtrlProveedores,
    // @LINE:7
    CtrlUsuarios_3: controllers.CtrlUsuarios,
    // @LINE:10
    CtrlClientes_0: controllers.CtrlClientes,
    // @LINE:12
    CtrlProductos_5: controllers.CtrlProductos,
    // @LINE:14
    CtrlCabCC_1: controllers.CtrlCabCC,
    // @LINE:17
    CtrlDetCC_2: controllers.CtrlDetCC
  ) = this(errorHandler, CtrlProveedores_4, CtrlUsuarios_3, CtrlClientes_0, CtrlProductos_5, CtrlCabCC_1, CtrlDetCC_2, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, CtrlProveedores_4, CtrlUsuarios_3, CtrlClientes_0, CtrlProductos_5, CtrlCabCC_1, CtrlDetCC_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """vendedor/$codigo<[^/]+>""", """controllers.CtrlProveedores.getVendedor(codigo:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """usuario/$codigo<[^/]+>""", """controllers.CtrlUsuarios.getUsuario(codigo:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """usuario/update/""", """controllers.CtrlUsuarios.updateUsuario"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """clientes/$vendedor<[^/]+>""", """controllers.CtrlClientes.getClientes(vendedor:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """productos/""", """controllers.CtrlProductos.getProductos()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """cabcc/$vendedor<[^/]+>""", """controllers.CtrlCabCC.getCabCC(vendedor:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """cabcc/""", """controllers.CtrlCabCC.salvarCabCC"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """detcc/$vendedor<[^/]+>""", """controllers.CtrlDetCC.getDetCC(vendedor:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """detcc/numtrans/$numtrans<[^/]+>""", """controllers.CtrlDetCC.getByNumtrans(numtrans:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """detcc/""", """controllers.CtrlDetCC.salvarDetCC"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:5
  private[this] lazy val controllers_CtrlProveedores_getVendedor0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("vendedor/"), DynamicPart("codigo", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CtrlProveedores_getVendedor0_invoker = createInvoker(
    CtrlProveedores_4.getVendedor(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CtrlProveedores",
      "getVendedor",
      Seq(classOf[String]),
      "GET",
      """ Mapeo de servicios web
# HTTP		URL                     función del controlador""",
      this.prefix + """vendedor/$codigo<[^/]+>"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_CtrlUsuarios_getUsuario1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("usuario/"), DynamicPart("codigo", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CtrlUsuarios_getUsuario1_invoker = createInvoker(
    CtrlUsuarios_3.getUsuario(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CtrlUsuarios",
      "getUsuario",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """usuario/$codigo<[^/]+>"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_CtrlUsuarios_updateUsuario2_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("usuario/update/")))
  )
  private[this] lazy val controllers_CtrlUsuarios_updateUsuario2_invoker = createInvoker(
    CtrlUsuarios_3.updateUsuario,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CtrlUsuarios",
      "updateUsuario",
      Nil,
      "PUT",
      """""",
      this.prefix + """usuario/update/"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_CtrlClientes_getClientes3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("clientes/"), DynamicPart("vendedor", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CtrlClientes_getClientes3_invoker = createInvoker(
    CtrlClientes_0.getClientes(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CtrlClientes",
      "getClientes",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """clientes/$vendedor<[^/]+>"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_CtrlProductos_getProductos4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("productos/")))
  )
  private[this] lazy val controllers_CtrlProductos_getProductos4_invoker = createInvoker(
    CtrlProductos_5.getProductos(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CtrlProductos",
      "getProductos",
      Nil,
      "GET",
      """""",
      this.prefix + """productos/"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_CtrlCabCC_getCabCC5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cabcc/"), DynamicPart("vendedor", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CtrlCabCC_getCabCC5_invoker = createInvoker(
    CtrlCabCC_1.getCabCC(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CtrlCabCC",
      "getCabCC",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """cabcc/$vendedor<[^/]+>"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_CtrlCabCC_salvarCabCC6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cabcc/")))
  )
  private[this] lazy val controllers_CtrlCabCC_salvarCabCC6_invoker = createInvoker(
    CtrlCabCC_1.salvarCabCC,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CtrlCabCC",
      "salvarCabCC",
      Nil,
      "POST",
      """""",
      this.prefix + """cabcc/"""
    )
  )

  // @LINE:17
  private[this] lazy val controllers_CtrlDetCC_getDetCC7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("detcc/"), DynamicPart("vendedor", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CtrlDetCC_getDetCC7_invoker = createInvoker(
    CtrlDetCC_2.getDetCC(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CtrlDetCC",
      "getDetCC",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """detcc/$vendedor<[^/]+>"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_CtrlDetCC_getByNumtrans8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("detcc/numtrans/"), DynamicPart("numtrans", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CtrlDetCC_getByNumtrans8_invoker = createInvoker(
    CtrlDetCC_2.getByNumtrans(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CtrlDetCC",
      "getByNumtrans",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """detcc/numtrans/$numtrans<[^/]+>"""
    )
  )

  // @LINE:19
  private[this] lazy val controllers_CtrlDetCC_salvarDetCC9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("detcc/")))
  )
  private[this] lazy val controllers_CtrlDetCC_salvarDetCC9_invoker = createInvoker(
    CtrlDetCC_2.salvarDetCC,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CtrlDetCC",
      "salvarDetCC",
      Nil,
      "POST",
      """""",
      this.prefix + """detcc/"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:5
    case controllers_CtrlProveedores_getVendedor0_route(params) =>
      call(params.fromPath[String]("codigo", None)) { (codigo) =>
        controllers_CtrlProveedores_getVendedor0_invoker.call(CtrlProveedores_4.getVendedor(codigo))
      }
  
    // @LINE:7
    case controllers_CtrlUsuarios_getUsuario1_route(params) =>
      call(params.fromPath[String]("codigo", None)) { (codigo) =>
        controllers_CtrlUsuarios_getUsuario1_invoker.call(CtrlUsuarios_3.getUsuario(codigo))
      }
  
    // @LINE:8
    case controllers_CtrlUsuarios_updateUsuario2_route(params) =>
      call { 
        controllers_CtrlUsuarios_updateUsuario2_invoker.call(CtrlUsuarios_3.updateUsuario)
      }
  
    // @LINE:10
    case controllers_CtrlClientes_getClientes3_route(params) =>
      call(params.fromPath[String]("vendedor", None)) { (vendedor) =>
        controllers_CtrlClientes_getClientes3_invoker.call(CtrlClientes_0.getClientes(vendedor))
      }
  
    // @LINE:12
    case controllers_CtrlProductos_getProductos4_route(params) =>
      call { 
        controllers_CtrlProductos_getProductos4_invoker.call(CtrlProductos_5.getProductos())
      }
  
    // @LINE:14
    case controllers_CtrlCabCC_getCabCC5_route(params) =>
      call(params.fromPath[String]("vendedor", None)) { (vendedor) =>
        controllers_CtrlCabCC_getCabCC5_invoker.call(CtrlCabCC_1.getCabCC(vendedor))
      }
  
    // @LINE:15
    case controllers_CtrlCabCC_salvarCabCC6_route(params) =>
      call { 
        controllers_CtrlCabCC_salvarCabCC6_invoker.call(CtrlCabCC_1.salvarCabCC)
      }
  
    // @LINE:17
    case controllers_CtrlDetCC_getDetCC7_route(params) =>
      call(params.fromPath[String]("vendedor", None)) { (vendedor) =>
        controllers_CtrlDetCC_getDetCC7_invoker.call(CtrlDetCC_2.getDetCC(vendedor))
      }
  
    // @LINE:18
    case controllers_CtrlDetCC_getByNumtrans8_route(params) =>
      call(params.fromPath[Long]("numtrans", None)) { (numtrans) =>
        controllers_CtrlDetCC_getByNumtrans8_invoker.call(CtrlDetCC_2.getByNumtrans(numtrans))
      }
  
    // @LINE:19
    case controllers_CtrlDetCC_salvarDetCC9_route(params) =>
      call { 
        controllers_CtrlDetCC_salvarDetCC9_invoker.call(CtrlDetCC_2.salvarDetCC)
      }
  }
}