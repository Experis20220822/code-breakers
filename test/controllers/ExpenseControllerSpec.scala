/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package controllers

import com.dimafeng.testcontainers.{ForAllTestContainer, MongoDBContainer}
import models.NormalMode
import org.mongodb.scala.{MongoClient, MongoDatabase}
import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._
import repositories.ExpenseRepository
import services.ExpenseService
import views.html.expenseForm

import scala.concurrent.ExecutionContext.Implicits.global

class ExpenseControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting with ForAllTestContainer {
  val container: MongoDBContainer = new MongoDBContainer()

  "ExpenseController GET" should {
    pending
    "render the form to add a new expense in the /expense page" in {
      val controller = new ExpenseController(stubMessagesControllerComponents(), app.injector.instanceOf[expenseForm], new ExpenseService(ExpenseRepository(getDb)))
      val request = CSRFTokenHelper.addCSRFToken(FakeRequest(GET, "/expense"))
      val expenseFormPage = controller.index(NormalMode).apply(request)

      status(expenseFormPage) mustBe OK
      contentType(expenseFormPage) mustBe Some("text/html")
      contentAsString(expenseFormPage) must include("Add an expense")
    }
  }

  private def getDb: MongoDatabase = {
    val mongoClient: MongoClient =
      MongoClient(container.container.getConnectionString)
    val db = mongoClient.getDatabase("tests")
    db
  }
}
