/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package controllers

import models._
import play.api.mvc.{BaseController, ControllerComponents}

import javax.inject.Inject

case class ExpensesController @Inject() (
   controllerComponents: ControllerComponents
                                        )
