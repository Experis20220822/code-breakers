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
import views.html.RegisterPage
import views.html.text_input
import play.api.data.validation.Constraints.nonEmpty
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import ExecutionContext.Implicits.global

import scala.util.hashing.MurmurHash3

case class RegisterData( email: String, username: String, password: String)

@Singleton class RegisterController @Inject()(
  val mcc: MessagesControllerComponents,
  view: RegisterPage,
  textInputView: text_input,
  val userService: UserService,
  val controller: ControllerComponents
  )
  (val executionContext: ExecutionContext) extends FrontendController(mcc) with I18nSupport {

    val userForm: Form[RegisterData] = Form(
      mapping(
        "email" -> text.verifying(nonEmpty),
        "Username" -> text.verifying(nonEmpty),
        "Password" -> text.verifying(nonEmpty),
      )(RegisterData.apply)
      (RegisterData.unapply)
    )

  def create(mode: Mode): Action[AnyContent] = Action.async {
    implicit request =>
      userForm.bindFromRequest.fold(
        formWithErrors => {
          Future(BadRequest(view(formWithErrors, mode)))
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
          Future(Redirect(routes.RegisterController.show(id)))
        }
      )
  }

  def show(id: String, mode: Mode): Action[AnyContent] = Action.async { implicit request =>
    val maybeUser = userService.findById(id)
    maybeUser
      .map {
        case Some(user) => Ok(view(userForm,mode))
        case None => NotFound("Sorry, User cannot be found")
      }
  }

  def init(mode: Mode): Action[AnyContent] = Action { implicit request =>
    Ok(view(userForm, mode))
  }
}
