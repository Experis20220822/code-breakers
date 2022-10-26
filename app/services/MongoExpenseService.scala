/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package services

import models._
import org.mongodb.scala.model.Filters.equal
import org.mongodb.scala.{Document, MongoCollection}
import uk.gov.hmrc.mongo.MongoComponent

import javax.inject.Inject
import scala.concurrent.Future

class MongoExpenseService @Inject()(mongoDatabase: MongoComponent) extends AsyncExpenseService {
  val expenseCollection: MongoCollection[Document] = mongoDatabase.database.getCollection("expenses")

  override def create(expense: Expense): Unit = {
    val document: Document = expenseToDocument(expense)
    expenseCollection.insertOne(document).subscribe(
      r => println(s"Successful Insert $r"),
      t => t.printStackTrace(),
      () => "Insert Complete"
    )
  }

  override def findById(id: Long): Future[Option[Expense]] = {
    expenseCollection.find(equal("_id", id)).map {
      d => documentToExpense(d)
    }.toSingle().headOption()
  }

  private def expenseToDocument(expense: Expense): Document = {
    Document(
      "_id" -> expense.id,
      "date" -> expense.date,
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
    Expense(
      d.getLong("_id"),
      d.getDate("date"),
      d.getLong("amount"),
      stringToCategory(d.getString("category"))
    )
  }

}