/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package controllers

import play.api.i18n.I18nSupport
import play.api.mvc.MessagesControllerComponents
import services.ExpenseService
import uk.gov.hmrc.play.bootstrap.frontend.controller.FrontendController
import views.html.expenseResult

import javax.inject.{Inject, Singleton}
import scala.concurrent.ExecutionContext

@Singleton class ExpenseResultController @Inject() (val mcc: MessagesControllerComponents,
                                                    view: expenseResult,
                                                    val expenseService: ExpenseService,
                                                   )
                                                   (implicit val executionContext: ExecutionContext) extends FrontendController(mcc) with I18nSupport {

  def show(id: String) = Action.async { implicit request =>
    val maybeExpense = expenseService.findById(id)

    maybeExpense
      .map {
        case Some(expense) => {
          println(expense)
          Ok(view(expense))
        }
        case None => NotFound("Sorry, that expense cannot be found")
      }
  }
}
