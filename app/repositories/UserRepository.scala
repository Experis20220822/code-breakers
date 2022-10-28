/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package repositories

import models.User
import org.mongodb.scala.bson.conversions.Bson
import org.mongodb.scala.model.Filters
import org.mongodb.scala.{Document, MongoCollection, MongoDatabase}

import javax.inject.Inject
import scala.concurrent.Future

class UserRepository @Inject()(mongoDatabase: MongoDatabase) {
  val collection: MongoCollection[Document] = mongoDatabase.getCollection("users")

  private def byId(id: String): Bson = Filters.equal("_id", id)

  private def byStringField(query: String, fieldName: String): Bson = Filters.equal(fieldName, query)
  def get(id: String): Future[Option[User]] = {
    collection.find(byId(id))
      .map(d => documentToUser(d)).toSingle().headOption()
  }

  def getUsername(username: String): Future[Option[User]] = {
    collection.find(byStringField(username, "username"))
      .map(d => documentToUser(d)).toSingle().headOption()
  }


  def create(user: User): Future[Option[String]] = {
//    println("invoking create in repository")
    collection.insertOne(
      Document(
        "email" -> user.email,
        "username" -> user.username,
        "password" -> user.password
      )
    ).map(r => r.getInsertedId.asObjectId().getValue.toString).headOption()
  }



  def documentToUser(d: Document): User = {
    User(d("_id").asObjectId().getValue.toString, d("email").asString().getValue, d("username").asString().getValue, d("password").asString().getValue)
  }
}