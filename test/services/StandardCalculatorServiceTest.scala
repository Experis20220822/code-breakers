/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package services

import models.Calculator
import org.scalatestplus.play.PlaySpec
import services.StandardCalculatorService

class StandardCalculatorServiceTest extends PlaySpec{
    "Calculator Service" must {
      "return correct salary amount" in {
        val calculatorServiceTest = new StandardCalculatorService
        val salaryResult = calculatorServiceTest.calculateSalary(Calculator(12570, "L", 0, 0))
        val compareToResult = 12570
        salaryResult mustBe(compareToResult)
      }
    }
}
