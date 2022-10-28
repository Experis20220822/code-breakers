/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package services
import models.Calculator
import org.mongodb.scala.MongoDatabase
import repositories.SalaryRepository

import javax.inject.Inject
import scala.concurrent.Future


class StandardCalculatorService @Inject()(salaryRepository: SalaryRepository)  extends AsyncCalculatorService {
  override def create(salary: Calculator): Future[Option[String]] = salaryRepository.create(salary)
  def calculateTaxAllowance(taxCode: String): Double = {
    val defaultAllowance = 12570

    taxCode match {
      case "L" => defaultAllowance
      case "M" => defaultAllowance * 1.10
      case "N" => defaultAllowance * 0.9
    }
  }
  def calculateBandSalary(salary: Double, threshold: Double): Double = {
    val bandSalary = salary - threshold

    bandSalary match {
      case x if x > 0 => bandSalary
      case _ => 0
    }
  }
  def calculateOverallTax(allowance: Double, salary: Double): Double = {
    val additionalRateSalary = calculateBandSalary(salary, 150000)
    val higherRateSalary = calculateBandSalary(salary - additionalRateSalary, 50270)
    val basicRateSalary = calculateBandSalary(salary - allowance - higherRateSalary - additionalRateSalary, 0)

    basicRateSalary * 0.2 + higherRateSalary * 0.4 + additionalRateSalary * 0.45
  }
  def calculateAfterTaxAmount(taxCode: String, salary: Double): Double = {
    val allowance = calculateTaxAllowance(taxCode)
    val totalTax = calculateOverallTax(allowance, salary)

    salary - totalTax
  }

  def studentLoan(salary: Double): Double = {
    val monthlySlary  = salary / 12
    val salaryThreshold = monthlySlary - 1682

    salaryThreshold match {
      case x if x > 0 => salaryThreshold
      case _ => 0
    }
  }
  def studentLoanCalculation(salary: Double): Double = {
    val studentLoanPayment =  studentLoan(salary)
    if (studentLoanPayment == 0) studentLoanPayment else studentLoanPayment * 0.09
  }

  override def calculateSalary(salary: Calculator): Double = {
    calculateAfterTaxAmount(salary.taxCode, salary.salary - salary.pension - studentLoanCalculation(salary.salary))
  }



}