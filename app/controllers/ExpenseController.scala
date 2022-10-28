/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package controllers

import models._
import play.api.data.Form
import play.api.data.Forms.{longNumber, mapping, text}
import play.api.data.validation.Constraints.nonEmpty
import play.api.i18n.I18nSupport
import play.api.mvc._
import services._
import uk.gov.hmrc.play.bootstrap.frontend.controller.FrontendController
import views.html.expenseForm

import javax.inject.{Inject, Singleton}
import scala.concurrent.ExecutionContext
import scala.util.hashing.MurmurHash3

case class ExpenseData(date: Date, amount: Long, category: String)

@Singleton class ExpenseController @Inject() (val mcc: MessagesControllerComponents,
                                               view: expenseForm,
                                               val expenseService: ExpenseService,
                                              )
                                              (implicit val executionContext: ExecutionContext) extends FrontendController(mcc) with I18nSupport {


  val form: Form[ExpenseData] = Form(
    mapping(
      "date" -> mapping(
        "day" -> text.verifying(nonEmpty),
        "month" -> text.verifying(nonEmpty),
        "year" -> text.verifying(nonEmpty)
      )(Date.apply)(Date.unapply),
      "amount" -> longNumber,
      "category" -> text.verifying(nonEmpty),
    )(ExpenseData.apply)
    (ExpenseData.unapply)
  )


  def create(mode: Mode): Action[AnyContent] = Action {
    implicit request =>
      form.bindFromRequest().fold(
        formWithErrors => {
          println("Nay!" + formWithErrors)
          BadRequest(view(formWithErrors, mode, "-1"))
        },
        expensesData => {
          val id = MurmurHash3.stringHash(expensesData.date + expensesData.amount.toString + expensesData.category).toString
          val newExpense = Expense(
            id,
            expensesData.date,
            expensesData.amount,
            expensesData.category match {
              case "Groceries" => Groceries
              case "Transport" => Transport
              case "Energy" => Energy
              case "Water" => Water
              case "Socialising" => Socialising
              case _ => Other
            }
          )
          println("Yay!" + newExpense)
          expenseService.create(newExpense)
          Redirect(routes.ExpenseResultController.show(id))
        }
      )
  }

  def index(mode: Mode): Action[AnyContent] = Action { implicit request =>
    request.cookies.get("HMRCUser").map(c => Ok(view(form, mode, c.value))).getOrElse(NotFound("Need to be logged in"))
  }

}
