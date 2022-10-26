/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package services

import com.google.inject.ImplementedBy
import models.User

import scala.concurrent.Future
import scala.util.Try

trait AsyncUserService {

  def create(user: User): Future[Option[String]]

}
