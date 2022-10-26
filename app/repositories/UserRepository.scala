/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package repositories

import models.User
import org.mongodb.scala.bson.conversions.Bson
import org.mongodb.scala.model.Filters
import org.mongodb.scala.{Document, MongoDatabase}
import javax.inject.Inject

class UserRepository @Inject()(mongoDatabase: MongoDatabase) {
  val collection = mongoDatabase.getCollection("users")

  private def byId(id: String): Bson = Filters.equal("_id", id)

  def get(id: String) = {
    collection.find(byId(id))
      .map(d => documentToUser(d)).toSingle().headOption()
  }

  def create(user: User) = {
    collection.insertOne(
      Document(
        "email" -> user.email,
        "username" -> user.username,
        "password" -> user.password
      )
    ).map(r => r.getInsertedId.asObjectId().getValue.toString).headOption()
  }

  def documentToUser(document: Document): User = {
    User(document("_id").toString, document("email").toString, document("username").toString, document("password").toString)
  }
}