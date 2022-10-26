/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package models

sealed trait Category

case object Groceries extends Category {
  override def toString: String = "Groceries"
}

case object Transport extends Category {
  override def toString: String = "Transport"
}

case object Energy extends Category {
  override def toString: String = "Energy"
}

case object Water extends Category {
  override def toString: String = "Water"
}

case object Socialising extends Category {
  override def toString: String = "Socialising"
}

case object Other extends Category {
  override def toString: String = "Other"
}
