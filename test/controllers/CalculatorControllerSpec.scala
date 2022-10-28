/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package controllers

import com.dimafeng.testcontainers.{ForAllTestContainer, MongoDBContainer}
import com.typesafe.config.ConfigFactory
import models.NormalMode
import org.mongodb.scala.{MongoClient, MongoDatabase}
import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.{Application, Configuration}
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.mvc.Cookie
import play.api.test._
import play.api.test.Helpers._
import repositories.ExpenseRepository
import services.ExpenseService
import views.html.{expenseForm, expenseTable}

import scala.concurrent.ExecutionContext.Implicits.global



class CalculatorControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  override def fakeApplication(): Application = {
    GuiceApplicationBuilder().configure(Configuration(ConfigFactory.load("application.conf"))).build()
  }

  "render the form to add a new salary in the salary/test" in {
    val controller = app.injector.instanceOf[CalculatorController]
    val request = CSRFTokenHelper.addCSRFToken(FakeRequest(GET, "/calculator").withCookies(Cookie("HMRCUser", "aUserName")))
    val calculatorFormPage = controller.index().apply(request)

    status(calculatorFormPage) mustBe OK
    contentType(calculatorFormPage) mustBe Some("text/html")
    contentAsString(calculatorFormPage) must include("Salary")


  }
}

