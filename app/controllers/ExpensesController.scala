package controllers

import models._
import play.api.mvc.{BaseController, ControllerComponents}

case class ExpensesController @Inject() (
  val controllerComponents: ControllerComponents
                                        )
