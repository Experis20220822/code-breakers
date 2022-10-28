/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package repositories

import models.Calculator

import scala.concurrent.Future

trait SalaryRepository {

  def get(id: String): Future[Option[Calculator]]

  def create(salary: Calculator): Future[Option[String]]
}
