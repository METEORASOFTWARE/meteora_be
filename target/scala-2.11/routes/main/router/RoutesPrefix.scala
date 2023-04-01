
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/amerc/meteora_be/conf/routes
// @DATE:Thu Mar 16 07:48:43 COT 2023


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
