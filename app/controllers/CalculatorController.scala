/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package controllers

import org.mongodb.scala.MongoDatabase
import play.api.data.Form
import play.api.data.Forms.{longNumber, mapping, number, text}
import play.api.i18n.I18nSupport
import play.api.mvc.{Action, AnyContent, ControllerComponents, MessagesControllerComponents}
import services.AsyncCalculatorService
import uk.gov.hmrc.play.bootstrap.frontend.controller.FrontendController
import views.html.calculator.calculatorForm
import views.html.{register, text_input}

import javax.inject.Inject
import scala.concurrent.ExecutionContext

class CalculatorController @Inject()
(val mcc: MessagesControllerComponents,
 view: calculatorForm,
 textInputView: text_input,
 val controller: ControllerComponents,
 val calculatorService: AsyncCalculatorService,
  // mongoDatabase: MongoDatabase
)
(implicit val executionContext: ExecutionContext) extends FrontendController(mcc) with I18nSupport{

  case class Calculator(salary: Long, taxCode: Long, pensionCont: Long = 0, stdLoan: Long = 0) {}

  val form: Form[Calculator] = Form[Calculator](
    mapping(
      "salary" -> longNumber,
      "taxCode" -> longNumber,
      "pensionCount" -> longNumber,
      "stdLoan" -> longNumber,


    )(Calculator.apply)(Calculator.unapply)
  )

  def index(): Action[AnyContent] = Action { implicit request =>
    Ok(view("Start up Calculator", "Heading", "SomeText"))
  }

 def show(): Action[AnyContent] = Action { implicit request =>
   Ok("Your take home is ")

 }

}
