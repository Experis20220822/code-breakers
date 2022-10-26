/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package services

import com.google.inject.ImplementedBy
import models.User

import scala.concurrent.Future
import scala.util.Try

@ImplementedBy(classOf[MongoUserServices])
trait AsyncUserService {

  def create(user: User): Unit

  def update(user: User): Try[User]

  def findByUsername(username: String): Future[List[User]]
}
