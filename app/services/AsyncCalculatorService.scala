/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package services
import com.google.inject.ImplementedBy
import models.Calculator

import scala.concurrent.Future

@ImplementedBy(classOf[StandardCalculatorService])
trait AsyncCalculatorService {
   def calculateSalary(salary: Calculator): Double

   def create(salary: Calculator): Future[Option[String]]
}
