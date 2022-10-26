/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package services

import models._
import org.mongodb.scala.{Document, MongoCollection}
import uk.gov.hmrc.mongo.MongoComponent

import javax.inject.{Inject, Singleton}
import scala.concurrent.Future
import scala.util.Try

@Singleton
class MongoUserServices @Inject()(mongoDatabase: MongoComponent) extends AsyncUserService {

  val userCollection: MongoCollection[Document] = mongoDatabase.database.getCollection("users")

  override def create(user: User): Unit = {
    val document: Document = userToDocument(user)
    userCollection
      .insertOne(document)
      .subscribe(
        r => println(s"Successful Insert $r"),
        t => t.printStackTrace(),
        () => "Insert Complete"
      )
  }

  private def userToDocument(user: User): Document = {
    Document(
      "_id" -> user.id,
      "email" -> user.email,
      "username" -> user.username,
      "password" -> user.password,
    )
  }

  override def update(user: User): Try[User] = ???

  def findByUsername(username: String): Future[List[User]] = ???
}
