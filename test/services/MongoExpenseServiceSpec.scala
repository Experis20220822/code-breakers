/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package services

import com.dimafeng.testcontainers.{ForAllTestContainer, MongoDBContainer}
import models.{Date, Energy, Expense}
import org.mongodb.scala._
import org.scalatestplus.play.PlaySpec
import repositories.ExpenseRepository

import scala.concurrent.ExecutionContext.Implicits.global

class MongoExpenseServiceSpec extends PlaySpec with ForAllTestContainer {
  val container: MongoDBContainer = new MongoDBContainer()
  val host: String = container.host

  "Mongo Expense Service" must {
    "create an expense document" in {
      val expenseService = new ExpenseService(ExpenseRepository(getDb))
      val expense = Expense("4L", Date("28", "10", "2022"), 20000L, Energy)
      expenseService.create(expense)

      val result = expenseService.findById("4L").map {
        case Some(e) => e
        case _ => ()
      }
      result.map(e => e mustEqual expense)
    }

    "list all expenses" in {
      val expenseService = new ExpenseService(ExpenseRepository(getDb))
      val expense = Expense("8L", Date("28", "09", "2022"), 20000L, Energy)
      expenseService.create(expense)
      expenseService.findAll().map(e => e.size mustEqual 1)
    }
  }





  private def getDb = {
    val mongoClient: MongoClient =
      MongoClient(container.container.getConnectionString)
    val db = mongoClient.getDatabase("tests")
    db
  }
}
