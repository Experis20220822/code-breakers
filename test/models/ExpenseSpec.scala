/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package models

import org.scalatestplus.play.PlaySpec

class ExpenseSpec extends PlaySpec {

  val expense = Expense("2L", Date("27", "10", "2022"), 10000, Groceries)
  "An expense" must {
    "return the expense id that I provide it" in {
      expense.id mustBe ("2L")
    }
    "return the date that I provide it" in {
      expense.date mustBe (Date("27", "10", "2022"))
    }
    "return the amount that I provide it" in {
      expense.amount mustBe (10000)
    }
    "return the category that I provide it" in {
      expense.category mustBe (Groceries)
    }
  }
}
