/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package services
import models.Calculator
import org.mongodb.scala.MongoDatabase

import javax.inject.Inject


class StandardCalculatorService @Inject()  extends AsyncCalculatorService {
  override def calculateSalary(salary: Calculator): Double = {
     val currentTax = 12570


    if (salary.pension != 0 && salary.stdLoad != 0)
      salary.taxCode match {
        case "L"  => if (salary.salary - currentTax > 0) (salary.salary - currentTax) / 1.20 - (salary.pension) - salary.stdLoad else salary.salary
        case "M" => if (salary.salary - currentTax > 0) ((salary.salary- currentTax) * 1.10) / 1.20 - (salary.pension) - salary.stdLoad else salary.salary
        case "N" => if (salary.salary - currentTax > 0) ((salary.salary - currentTax) / 1.10) / 1.20 - (salary.pension) - salary.stdLoad else salary.salary
      } else if (salary.pension == 0 && salary.stdLoad != 0)
      salary.taxCode match {
        case "L" => if (salary.salary - currentTax > 0) (salary.salary - currentTax) / 1.20 - salary.stdLoad else salary.salary
        case "M" => if (salary.salary - currentTax > 0) ((salary.salary- currentTax) * 1.10) / 1.20 - salary.stdLoad else salary.salary
        case "N" => if (salary.salary - currentTax > 0) ((salary.salary - currentTax) / 1.10) / 1.20 - salary.stdLoad else salary.salary
      } else
      salary.taxCode match {
        case "L" =>if (salary.salary - currentTax > 0)  (salary.salary - currentTax) / 1.20  - (salary.pension) else salary.salary
        case "M" =>if (salary.salary - currentTax > 0) ((salary.salary- currentTax) * 1.10) / 1.20 - (salary.pension) else salary.salary
        case "N" =>if (salary.salary - currentTax > 0) ((salary.salary - currentTax) / 1.10) / 1.20 - (salary.pension) else salary.salary
      }

  }
}
