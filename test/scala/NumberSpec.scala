/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package scala

import org.scalacheck.Properties
import org.scalacheck.Prop.{forAll, propBoolean}

class NumberSpec extends Properties("Numbers") {
  property("addZero") = forAll { (a: Int) =>
    a + 0 == a
  }

  property("divideByTwo") = forAll { (a: Int) =>
    (a > 1) ==> (a / 2 > 0)
  }
}
