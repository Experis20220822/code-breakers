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
import scala.concurrent.{ExecutionContext, Future}
import scala.util.hashing.MurmurHash3

case class ExpenseData(date: Date, amount: Long, category: String)

@Singleton class ExpenseController @Inject() (val mcc: MessagesControllerComponents,
                                               view: expenseForm,
                                               val expenseService: ExpenseService,
                                              )
                                              (implicit val executionContext: ExecutionContext) extends FrontendController(mcc) with I18nSupport {


  def list() = Action { implicit request =>
    Ok("will show list of expenses")
  }

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


  def create(mode: Mode) = Action.async {
    implicit request =>
      form.bindFromRequest().fold(
        formWithErrors => {
          println("Nay!" + formWithErrors)
          Future(BadRequest(view(formWithErrors, mode)))
        },
        expensesData => {
          val id = MurmurHash3.stringHash(expensesData.date + expensesData.amount.toString + expensesData.category)
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
          Future(Redirect(routes.ExpenseController.show(id)))
        }
      )
  }

  def show(id: Long, mode: Mode): Action[AnyContent] = Action.async { implicit request =>
    val maybeExpense = expenseService.findById(id)
    maybeExpense
      .map {
        case Some(expense) => Ok(view(form, mode))
        case None => NotFound("Sorry, that expense cannot be found")
      }
  }

  def index(mode: Mode): Action[AnyContent] = Action { implicit request =>
    Ok(view(form, mode))
  }

}
