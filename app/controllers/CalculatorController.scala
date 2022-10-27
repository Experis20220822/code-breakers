/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package controllers

import models.Calculator
import org.mongodb.scala.MongoDatabase
import play.api.Mode
import play.api.data.Form
import play.api.data.Forms.{char, longNumber, mapping, number, text}
import play.api.http.Writeable.wByteArray
import play.api.i18n.I18nSupport
import play.api.libs.Jsonp.contentTypeOf_Jsonp
import play.api.mvc.{Action, AnyContent, ControllerComponents, Cookie, MessagesControllerComponents}
import services.{AsyncCalculatorService, StandardCalculatorService}
import uk.gov.hmrc.play.bootstrap.frontend.controller.FrontendController
import views.html.helper.form
import views.html.{calTestForm, text_input}

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}



case class CalculatorFormData(salary: Long, taxCode: String, pensionCount: Long = 0, stdLoan: Long = 0)

class CalculatorController @Inject()
(val mcc: MessagesControllerComponents,
 view: calTestForm,
 textInputView: text_input,
 val controller: ControllerComponents,
 val calculatorService: AsyncCalculatorService,
 // mongoDatabase: MongoDatabase
)
(implicit val executionContext: ExecutionContext) extends FrontendController(mcc) with I18nSupport {



  val calculatorForm: Form[CalculatorFormData] = Form[CalculatorFormData](
    mapping(
      "salary" -> longNumber,
      "taxCode" -> text,
      "pensionCount" -> longNumber,
      "stdLoan" -> longNumber,


    )(CalculatorFormData.apply)(CalculatorFormData.unapply)
  )

  def index(): Action[AnyContent] = Action { implicit request =>
    request.cookies.get("HMRCUser")
      .map(c => Ok(view("Start up Calculator", "Heading", "SomeText", calculatorForm, c.value)))
      .getOrElse(NotFound("Please log in!"))

  }


  def calculate(): Action[AnyContent] = Action { implicit request =>
    calculatorForm.bindFromRequest.fold(
      formWithErrors => {
        println("Something gone wrong" + formWithErrors)
        BadRequest(view("Lest ", "Test ", "This ", formWithErrors, "-1"))
      },
      calculatorData => {

        val calculatorResult = new StandardCalculatorService
        val calculator = Calculator(calculatorData.salary, calculatorData.taxCode, calculatorData.pensionCount, calculatorData.stdLoan)
        println(calculator)
        val calcResult = calculatorResult.calculateSalary(calculator)
        val salaryResult = BigDecimal(calcResult)
        val roundedResult = salaryResult.setScale(2, BigDecimal.RoundingMode.HALF_UP)
        Redirect(routes.ExpenseController.index()).withCookies(Cookie.apply("HMRCUser", roundedResult.toString))
      }
    )

  }

  def show(result: Double): Action[AnyContent] = Action { implicit request =>
    val salaryResult = BigDecimal(result)
    val roundedResult = salaryResult.setScale(2, BigDecimal.RoundingMode.HALF_UP)
    println(result+ " Im here")
    Ok("Your take home is " + roundedResult)

  }

}
