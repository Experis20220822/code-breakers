// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.models._
import _root_.uk.gov.hmrc.play.bootstrap.binders.RedirectUrl

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:5
  hmrcfrontend_Routes_0: hmrcfrontend.Routes,
  // @LINE:7
  HomeController_0: controllers.HomeController,
  // @LINE:8
  LoginController_1: controllers.LoginController,
  // @LINE:9
  RegisterController_2: controllers.RegisterController,
  // @LINE:12
  Assets_3: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:5
    hmrcfrontend_Routes_0: hmrcfrontend.Routes,
    // @LINE:7
    HomeController_0: controllers.HomeController,
    // @LINE:8
    LoginController_1: controllers.LoginController,
    // @LINE:9
    RegisterController_2: controllers.RegisterController,
    // @LINE:12
    Assets_3: controllers.Assets
  ) = this(errorHandler, hmrcfrontend_Routes_0, HomeController_0, LoginController_1, RegisterController_2, Assets_3, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, hmrcfrontend_Routes_0, HomeController_0, LoginController_1, RegisterController_2, Assets_3, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    prefixed_hmrcfrontend_Routes_0_0.router.documentation,
    ("""GET""", this.prefix, """controllers.HomeController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.LoginController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """create-an-account""", """controllers.RegisterController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:5
  private[this] val prefixed_hmrcfrontend_Routes_0_0 = Include(hmrcfrontend_Routes_0.withPrefix(this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + "hmrc-frontend"))

  // @LINE:7
  private[this] lazy val controllers_HomeController_index1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index1_invoker = createInvoker(
    HomeController_0.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_LoginController_index2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_LoginController_index2_invoker = createInvoker(
    LoginController_1.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "index",
      Nil,
      "GET",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_RegisterController_index3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("create-an-account")))
  )
  private[this] lazy val controllers_RegisterController_index3_invoker = createInvoker(
    RegisterController_2.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RegisterController",
      "index",
      Nil,
      "GET",
      this.prefix + """create-an-account""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Assets_versioned4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned4_invoker = createInvoker(
    Assets_3.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:5
    case prefixed_hmrcfrontend_Routes_0_0(handler) => handler
  
    // @LINE:7
    case controllers_HomeController_index1_route(params@_) =>
      call { 
        controllers_HomeController_index1_invoker.call(HomeController_0.index())
      }
  
    // @LINE:8
    case controllers_LoginController_index2_route(params@_) =>
      call { 
        controllers_LoginController_index2_invoker.call(LoginController_1.index())
      }
  
    // @LINE:9
    case controllers_RegisterController_index3_route(params@_) =>
      call { 
        controllers_RegisterController_index3_invoker.call(RegisterController_2.index())
      }
  
    // @LINE:12
    case controllers_Assets_versioned4_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned4_invoker.call(Assets_3.versioned(path, file))
      }
  }
}
