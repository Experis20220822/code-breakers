/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package services
import models.Calculator
import org.mongodb.scala.MongoDatabase

import javax.inject.Inject


class StandardCalculatorService @Inject()  extends AsyncCalculatorService {
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
    val additionalRateSalary = calculateBandSalary(salary, 150000)// 150_000 - 150_000 = 0
    val higherRateSalary = calculateBandSalary(salary - additionalRateSalary, 50270)  // 150_000 - 0 - 50270 = 99730
    val basicRateSalary = calculateBandSalary(salary - allowance - higherRateSalary - additionalRateSalary, 0) // 150_000 - 12570 - 99730 =

    basicRateSalary * 0.2 + higherRateSalary * 0.4 + additionalRateSalary * 0.45
  }
  def calculateAfterTaxAmount(taxCode: String, salary: Double): Double = {
    val allowance = calculateTaxAllowance(taxCode)
    val totalTax = calculateOverallTax(allowance, salary)

    salary - totalTax
  }
  override def calculateSalary(salary: Calculator): Double = {
    calculateAfterTaxAmount(salary.taxCode, salary.salary - salary.pension)
  }



}