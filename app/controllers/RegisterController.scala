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
import scala.concurrent._
import ExecutionContext.Implicits.global

import scala.util.hashing.MurmurHash3

  case class RegisterData( email: String, username: String, password: String)

@Singleton class RegisterController @Inject()(
  val mcc: MessagesControllerComponents, view: register, textInputView: text_input,
  val userService: UserService,
  val controller: ControllerComponents
  )
  (implicit val executionContext: ExecutionContext) extends FrontendController(mcc) with I18nSupport {

  val userForm: Form[RegisterData] = Form(
    mapping(
      "email" -> text.verifying(nonEmpty),
      "Username" -> text.verifying(nonEmpty),
      "Password" -> text.verifying(nonEmpty),
    )(RegisterData.apply)
    (RegisterData.unapply)
  )

  def init(mode: Mode): Action[AnyContent] = Action { implicit request =>
    Ok(view("User", userForm))
  }

  def create(mode: Mode): Action[AnyContent] = Action {
    println("method init")
    implicit request: MessagesRequest[AnyContent] =>
      userForm.bindFromRequest.fold(
        formWithErrors => {
          BadRequest(view("Try again", formWithErrors ))
        },
        userData => {
          val id = MurmurHash3.stringHash(userData.username).toString
          val newUser = models.User(
            id,
            userData.email,
            userData.username,
            userData.password
          )
          println("Yay!" + newUser)
          userService.create(newUser)
          Redirect(routes.RegisterController.show(id))
        }
      )
  }

  def show(id: String): Action[AnyContent] = Action { implicit request =>
    Ok(view("Test it", userForm))
  }

}