/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package controllers

import models._
import play.api.data.Form
import play.api.data.Forms.{mapping, text}
import services.{AsyncUserService, UserService}

import javax.inject.{Inject, Singleton}
import play.api.i18n.{I18nSupport, Lang}
import play.api.mvc._
import play.filters.csrf.CSRF
import uk.gov.hmrc.play.bootstrap.frontend.controller.FrontendController
import views.html.register
import views.html.text_input
import play.api.data.validation.Constraints.nonEmpty
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ExecutionContext, Future}
import scala.util.hashing.MurmurHash3

case class RegisterData(id: String, email: String, username: String, password: String)

@Singleton class RegisterController @Inject()(
  val mcc: MessagesControllerComponents, view: register, textInputView: text_input,
  val userService: AsyncUserService,
  val controller: ControllerComponents
  )
  (implicit val executionContext: ExecutionContext) extends FrontendController(mcc) with I18nSupport {

//  case class a(val field: String) {}

//  val form: Form[Data] = Form[Data](
//    mapping("field" -> text)(Data.apply)(Data.unapply)
//  )

  val userForm: Form[RegisterData] = Form(
    mapping(
      "id"-> text.verifying(nonEmpty),
      "email" -> text.verifying(nonEmpty),
      "Username" -> text.verifying(nonEmpty),
      "Password" -> text.verifying(nonEmpty),
    )(RegisterData.apply)
    (RegisterData.unapply)
  )

  def init(): Action[AnyContent] = Action { implicit request =>
    Ok(view("User", userForm))
  }

  def create(mode: Mode): Action[AnyContent] = Action {
    implicit request: MessagesRequest[AnyContent] =>
      userForm.bindFromRequest().fold(
        formWithErrors => {
          println("Nay!" + formWithErrors)
          BadRequest(view("Try again", formWithErrors ))
        },
        userData => {
          val id = MurmurHash3.stringHash(userData.username)
          val newUser = models.User(
            id.toString,
            userData.email,
            userData.username,
            userData.password
          )
          println("Yay!" + newUser)
          userService.create(newUser)
          Redirect(routes.RegisterController.index())
        }
      )
  }

  def index(): Action[AnyContent] = Action { implicit request =>
    Ok(view("Test it", userForm))
  }

}