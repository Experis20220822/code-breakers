package controllers

import models.NormalMode
import org.mongodb.scala.MongoClient
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.http.Status.OK
import play.api.test.Helpers.{GET, POST, contentAsString, contentType, status, stubMessagesControllerComponents}
import play.api.test.{CSRFTokenHelper, FakeRequest, Injecting}
import repositories.UserRepository
import services.ExpenseRepository
import views.html.{RegisterPage, expenseForm}

class RegisterControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  "RegisterController GET" should {

    "render the form to add a new user in the /create-an-account page" in {
      val controller = new RegisterController(stubMessagesControllerComponents(), app.injector.instanceOf[RegisterPage], new UserRepository(getDb))
      val request = CSRFTokenHelper.addCSRFToken(FakeRequest(GET, "/create-an-account"))
      val RegisterFormPage = controller.init(NormalMode).apply(request)

      status(RegisterFormPage) mustBe OK
      contentType(RegisterFormPage) mustBe Some("text/html")
      //contentAsString(RegisterFormPage) must include("Add an expense")
    }

    "render the form to add a new user in the /create-an-account page" in {
      val controller = new RegisterController(stubMessagesControllerComponents(), app.injector.instanceOf[RegisterPage], new UserRepository(getDb))
      val request = CSRFTokenHelper.addCSRFToken(FakeRequest(POST, "/create-an-account"))
      val RegisterFormPage = controller.create(NormalMode).apply(request)

      status(RegisterFormPage) mustBe OK
      contentType(RegisterFormPage) mustBe Some("text/html")
      //contentAsString(RegisterFormPage) must include("Add an expense")
    }



  }



  private def getDb = {
    val mongoClient: MongoClient =
      MongoClient(container.container.getConnectionString)
    val db = mongoClient.getDatabase("tests")
    db
  }


}
