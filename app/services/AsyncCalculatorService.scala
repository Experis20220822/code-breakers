/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package services
import com.google.inject.ImplementedBy
import models.Calculator

@ImplementedBy(classOf[StandardCalculatorService])
trait AsyncCalculatorService {
   def calculateSalary(salary: Calculator): Double
}
