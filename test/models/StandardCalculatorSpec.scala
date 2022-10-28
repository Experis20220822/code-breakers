/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package models

import org.scalatestplus.play.PlaySpec

class StandardCalculatorSpec extends PlaySpec{

  val salary = Calculator("123Id", 12345, "L", 10, 10)
  "A salary" must {
     "should return id that user porvided" in {
       salary.id mustBe "123Id"
     }
    "should return salary" in {
      salary.salary mustBe 12345
    }
    "should be taxCode" in {
      salary.taxCode mustBe "L"
    }
    "should be pension" in {
      salary.pension mustBe 10
    }
    "should be student loan" in {
      salary.stdLoad mustBe 10
    }
  }

}
