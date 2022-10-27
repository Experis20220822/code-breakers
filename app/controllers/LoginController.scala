/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package controllers
import play.api.data.Form
import play.api.data.Forms.{mapping, text}
import javax.inject.{Inject, Singleton}
import play.api.i18n.I18nSupport
import play.api.mvc.{Action, AnyContent, MessagesControllerComponents}
import services.UserService
import uk.gov.hmrc.play.bootstrap.frontend.controller.FrontendController
import views.html.login
import views.html.text_input
import play.api.data.validation.Constraints.nonEmpty
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ExecutionContext, Future}



@Singleton class LoginController @Inject()(
  val mcc: MessagesControllerComponents,
  view: login,
  userService: UserService,
  textInputView: text_input
  )
  (val executionContext: ExecutionContext) extends FrontendController(mcc) with I18nSupport {

  case class LoginData(username: String, password: String)

  val loginForm: Form[LoginData] = Form(
    mapping(
      "username" -> text.verifying(nonEmpty),
      "password" -> text.verifying(nonEmpty),
    )(LoginData.apply)
    (LoginData.unapply)
  )

  def index(): Action[AnyContent] = Action { implicit request =>
    Ok(view(loginForm))
  }

  def login(): Action[AnyContent] = Action.async {
    implicit request =>
      loginForm.bindFromRequest.fold(
        formWithErrors => {
          println(formWithErrors)
          Future(BadRequest(view(formWithErrors)))
        },
        loginData => {
          val maybeUser = userService.getUsername(loginData.username)
         println(loginData.password)
          maybeUser
            .map {
              case Some(user) =>
                println(user.password)
                if (user.password == loginData.password) Redirect(routes.CalculatorController.index())
                else NotFound("Password is Incorrect, try again")
              case None => NotFound("Sorry but Username was not found, try again")
            }
        }
      )
  }
}