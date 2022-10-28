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
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.mvc.Cookie
import play.api.{Application, Configuration}
import play.api.test._
import play.api.test.Helpers._
import repositories.ExpenseRepository
import services.ExpenseService
import views.html.{expenseForm, expenseTable}

import scala.concurrent.ExecutionContext.Implicits.global

class ExpenseControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting with ForAllTestContainer {
  val container: MongoDBContainer = new MongoDBContainer()
  override def fakeApplication(): Application = { GuiceApplicationBuilder().configure(Configuration(ConfigFactory.load("application.conf"))).build() }

  "ExpenseController GET" should {
    "render the form to add a new expense in the /expense page" in {
      val controller = app.injector.instanceOf[ExpenseController]
      val request = CSRFTokenHelper.addCSRFToken(FakeRequest(GET, "/expense").withCookies(Cookie("HMRCUser", "aUserName")))
      val expenseFormPage = controller.index(NormalMode).apply(request)

      status(expenseFormPage) mustBe OK
      contentType(expenseFormPage) mustBe Some("text/html")
      contentAsString(expenseFormPage) must include("Add an expense")
    }
    "render the list of expenses in the /expenses page" in {
      val controller = app.injector.instanceOf[ExpenseListController]
      val request = CSRFTokenHelper.addCSRFToken(FakeRequest(GET, "/expenses"))
      val expenseTablePage = controller.list().apply(request)

      status(expenseTablePage) mustBe OK
      contentType(expenseTablePage) mustBe Some("text/html")
      contentAsString(expenseTablePage) must include("Expense Table")
    }
  }


}
