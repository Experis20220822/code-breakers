/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package controllers

import com.typesafe.config.ConfigFactory
import models.{NormalMode, User}
import org.mockito.MockitoSugar.when
import org.mongodb.scala.MongoClient
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.{Application, Configuration}
import play.api.http.Status.OK
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.mvc.Cookie
import play.api.test.Helpers.{GET, POST, contentAsString, contentType, defaultAwaitTimeout, status, stubMessagesControllerComponents}
import play.api.test.{CSRFTokenHelper, FakeRequest, Injecting}
import org.scalatestplus.mockito.MockitoSugar.mock
import repositories.UserRepository
//import services.ExpenseRepository
import views.html.{RegisterPage, expenseForm}



class RegisterControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {
  override def fakeApplication(): Application = { GuiceApplicationBuilder().configure(Configuration(ConfigFactory.load("application.conf"))).build() }

  "RegisterController GET" should {

    "render the form for adding a new user in the /create-an-account page" in {
      val controller = app.injector.instanceOf[RegisterController]
      val request = CSRFTokenHelper.addCSRFToken(FakeRequest(GET, "/create-an-account").withCookies(Cookie("HMRCUser", "aUserName")))
      val RegisterFormPage = controller.init(NormalMode).apply(request)

      status(RegisterFormPage) mustBe OK
      contentType(RegisterFormPage) mustBe Some("text/html")
    }

  }
}
