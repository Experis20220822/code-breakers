/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package repositories
import models.{Calculator, User}
import org.mongodb.scala.bson.conversions.Bson
import org.mongodb.scala.model.Aggregates.{addFields, set}
import org.mongodb.scala.model.Filters
import org.mongodb.scala.model.Filters.equal
import org.mongodb.scala.{Document, MongoCollection, MongoDatabase, model}

import javax.inject.Inject
import scala.concurrent.Future
class MongoSalaryRepository @Inject()(mongoDatabase: MongoDatabase) extends SalaryRepository {

  val collection: MongoCollection[Document] = mongoDatabase.getCollection("salary")

  private def byId(id: String): Bson = Filters.equal("_id", id)



  override def get(id: String): Future[Option[Calculator]] = {
    collection.find(byId(id))
      .map(d => documentToSalary(d)).toSingle().headOption()
  }




  override def create(salary: Calculator): Future[Option[String]] = {
    println("invoking create in repository")
    collection.insertOne(
      Document(
        "salary" -> salary.salary,
        "taxCode" -> salary.taxCode,
        "pension" -> salary.pension,
        "stdLoad" -> salary.stdLoad
      )
    ).map(r => r.getInsertedId.asObjectId().getValue.toString).headOption()
  }


  def documentToSalary(d: Document): Calculator = {
    Calculator(d("_id")
      .asObjectId().getValue.toString,
      d.getLong("salary"),
      d("taxCode").asString().getValue,
      d.getLong("pension"), d.getLong("stdLoad"))
  }
}
