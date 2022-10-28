/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package services

import models.Expense
import repositories.ExpenseRepository

import javax.inject.Inject
import scala.concurrent.Future

class ExpenseService @Inject() (expenseRepository: ExpenseRepository) extends AsyncExpenseService {
  override def create(expense: Expense): Unit = expenseRepository.create(expense)

  override def findById(id: String): Future[Option[Expense]] = expenseRepository.findById(id)

  override def findAll(): Future[List[Expense]] = expenseRepository.findAll()
}