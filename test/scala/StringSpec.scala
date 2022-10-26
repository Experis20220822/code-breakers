/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package scala

import org.scalacheck.Properties
import org.scalacheck.Prop.{forAll, propBoolean}

case class StringLength(str: String) {
  def length: Int = str.length
}

class StringSpec extends Properties("String") {

  property("startsWith") = forAll { (a: String, b: String) =>
    (a + b).startsWith(a)
  }

  property("endsWith") = forAll { (a: String, b: String) =>
    (a + b).endsWith(b)
  }

  property("concatenate") = forAll { (a: String, b: String) =>
    (a.length > 0 && b.length > 0) ==> ((a + b).length > a.length && (a + b).length > b.length)
  }

  property("substring") = forAll { (a: String, b: String, c: String) =>
    (a + b + c).substring(a.length, a.length + b.length) == b
  }

  property("length") = forAll { (str: String) =>
    StringLength(str).length >= 0
  }
}
