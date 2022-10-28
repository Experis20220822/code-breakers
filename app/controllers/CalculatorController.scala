/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package controllers

import org.mongodb.scala.MongoDatabase
import play.api.data.Form
import play.api.data.Forms.{longNumber, mapping, text}
import play.api.i18n.I18nSupport
import play.api.mvc._
import services.{AsyncCalculatorService, StandardCalculatorService}
import uk.gov.hmrc.play.bootstrap.frontend.controller.FrontendController
import views.html.{calTestForm, text_input}

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}
import scala.util.hashing.MurmurHash3



case class CalculatorFormData(salary: Long, taxCode: String, pensionCount: Long = 0, stdLoan: Long = 0)

class CalculatorController @Inject()
(val mcc: MessagesControllerComponents,
 view: calTestForm,
 textInputView: text_input,
 val controller: ControllerComponents,
 val calculatorService: AsyncCalculatorService,
 val salaryService: StandardCalculatorService,
   mongoDatabase: MongoDatabase
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


  def calculate(): Action[AnyContent] = Action.async { implicit request =>
    calculatorForm.bindFromRequest.fold(
      formWithErrors => {
        println("Something gone wrong" + formWithErrors)
        Future(BadRequest(view("Lest ", "Test ", "This ", formWithErrors, "-1")))
      },
      calculatorData => {
        val id = MurmurHash3.stringHash(calculatorData.salary.toString).toString
        val calculator = models.Calculator(id, calculatorData.salary, calculatorData.taxCode, calculatorData.pensionCount, calculatorData.stdLoan)
        val calcResult = calculatorService.calculateSalary(calculator)
        val salaryResult = BigDecimal(calcResult)
        val roundedResult = salaryResult.setScale(2, BigDecimal.RoundingMode.HALF_UP)
        salaryService.create(calculator).map {
          case Some(value) =>  Redirect(routes.ExpenseController.index()).withCookies(Cookie.apply("HMRCUser", roundedResult.toString))
          case None => NotFound("Sorry, cannot add this ")
        }


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
