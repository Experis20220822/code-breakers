/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package services

import models._
import org.mongodb.scala.model.Filters.equal
import org.mongodb.scala.{Document, MongoCollection, MongoDatabase}

import javax.inject.Inject
import scala.concurrent.Future

class ExpenseRepository @Inject()(mongoDatabase: MongoDatabase) extends AsyncExpenseService {
  val expenseCollection: MongoCollection[Document] = mongoDatabase.getCollection("expenses")


  override def create(expense: Expense): Unit = {
    val document: Document = expenseToDocument(expense)
    expenseCollection.insertOne(document).subscribe(
      r => println(s"Successful Insert $r"),
      t => t.printStackTrace(),
      () => "Insert Complete"
    )
  }

  override def findById(id: String): Future[Option[Expense]] = {
    expenseCollection.find(equal("_id", id)).map {
      d => documentToExpense(d)
    }.toSingle().headOption()
  }

  private def expenseToDocument(expense: Expense): Document = {
    val day = expense.date.day
    val month = expense.date.month
    val year = expense.date.year
    Document(
      "_id" -> expense.id,
      "date" -> s"$day $month $year",
      "amount" -> expense.amount,
      "category" -> expense.category.toString,
    )
  }

  override def findAll(): Future[List[Expense]] = {
    expenseCollection.find()
      .map(documentToExpense)
      .foldLeft(List.empty[Expense])((list, expense) => expense :: list)
      .head()
  }

  private def stringToCategory(string: String): Category = {
    string match {
      case "Groceries" => Groceries
      case "Transport" => Transport
      case "Energy" => Energy
      case "Water" => Water
      case "Socialising" => Socialising
      case _ => Other
    }
  }

  private def documentToExpense(d: Document) = {
    val dateArr = d.getString("date").split(" ")
    Expense(
      d("_id").toString,
      Date(dateArr(0), dateArr(1), dateArr(2)),
      d.getLong("amount"),
      stringToCategory(d.getString("category"))
    )
  }

}
