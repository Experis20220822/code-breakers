/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package models

import org.scalatestplus.play.PlaySpec

class UserSpec extends PlaySpec {

  val user: User = User("2L", "test@test.co.uk", "testUser", "testPassword")
  "An user" must {
    "return the user id that I provide it" in {
      user.id mustBe "2L"
    }
    "return the email that I provide it" in {
      user.email mustBe "test@test.co.uk"
    }
    "return the username that I provide it" in {
      user.username mustBe "testUser"
    }
    "return the password that I provide it" in {
      user.password mustBe "testPassword"
    }
  }
}
