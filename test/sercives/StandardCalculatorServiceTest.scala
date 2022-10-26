package sercives

import models.Calculator
import org.scalatestplus.play.PlaySpec
import services.StandardCalculatorService

class StandardCalculatorServiceTest extends PlaySpec{
    "Calculator Service" must {
      "return correct salary amount" in {
        val calculatorServiceTest = new StandardCalculatorService
        val salaryResult = calculatorServiceTest.calculateSalary(Calculator(100000, "L", 0, 0))
        val compareToResult = (100000 - 12570) / 1.20
        salaryResult mustBe(compareToResult)
      }
    }
}
