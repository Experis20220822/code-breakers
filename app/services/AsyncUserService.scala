/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package services

import models.User

import scala.concurrent.Future

trait AsyncUserService {
  def create(user: User): Future[Option[String]]

  def getUsername(username: String): Future[Option[User]]
  def findById(id: String): Future[Option[User]]



}
