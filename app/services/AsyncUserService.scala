/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package services

import models.User

import scala.concurrent.Future
import scala.util.Try

trait AsyncUserService {

  def create(user: User): Unit

  def update(user: User): Try[User]

  def findByUsername(username: String): Future[List[User]]
}
