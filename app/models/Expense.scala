/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package models

import java.util.Date

case class Expense(id: Long, date: Date, amount: Long, category: Category)
