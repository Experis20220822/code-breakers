/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package services

import models.Calculator

import scala.concurrent.Future

trait AsyncCalculatorService {
   def calculateSalary(salary: Calculator): Double
}
