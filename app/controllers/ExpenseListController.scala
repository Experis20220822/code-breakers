/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package controllers

import play.api.i18n.I18nSupport
import play.api.mvc.MessagesControllerComponents
import services.ExpenseService
import uk.gov.hmrc.play.bootstrap.frontend.controller.FrontendController
import views.html.expenseTable

import javax.inject.Inject
import scala.concurrent.ExecutionContext

class ExpenseListController @Inject() (val mcc: MessagesControllerComponents,
                                       view: expenseTable,
                                       val expenseService: ExpenseService,
                                      )
                                      (implicit val executionContext: ExecutionContext) extends FrontendController(mcc) with I18nSupport {

  def list() = Action.async { implicit request =>
    expenseService.findAll().map(xs => Ok(view(xs))
    )
  }

}
