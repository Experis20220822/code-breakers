/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package services

import models.{Date, Expense, Groceries}
import repositories.ExpenseRepository

import javax.inject.Inject
import scala.concurrent.Future

class ExpenseService @Inject() (expenseRepository: ExpenseRepository) extends AsyncExpenseService {
  import scala.concurrent.ExecutionContext.Implicits.global
  override def create(expense: Expense): Unit = expenseRepository.create(expense)

  override def findById(id: String): Future[Option[Expense]] = expenseRepository.findById(id)

  override def findAll(): Future[List[Expense]] = expenseRepository.findAll()
}