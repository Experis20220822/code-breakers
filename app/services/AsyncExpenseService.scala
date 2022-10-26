/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package services

import models.Expense

import scala.concurrent.Future

trait AsyncExpenseService {
  def findById(id: Long): Future[Option[Expense]]

  def create(expense: Expense): Unit

  def findAll(): Future[List[Expense]]
}
