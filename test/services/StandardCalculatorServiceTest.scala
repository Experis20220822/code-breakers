/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package services

import models.Calculator
import org.mockito.MockitoSugar.when
import org.scalatestplus.mockito.MockitoSugar.mock
import org.scalatestplus.play.PlaySpec
import repositories.SalaryRepository

class StandardCalculatorServiceTest extends PlaySpec{
    "Calculator Service" must {
      "return correct salary amount" in {
        val mockSalaryRepository = mock[SalaryRepository]
        val calculatorService = new StandardCalculatorService(mockSalaryRepository)
        val salaryResult = calculatorService.calculateSalary(Calculator("Id", 12570, "L", 0, 0))
        val compareToResult = 12570
        salaryResult mustBe compareToResult
      }
    }
}
