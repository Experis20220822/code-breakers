/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package services
import models.Calculator
import org.mongodb.scala.MongoDatabase

import javax.inject.Inject

class StandardCalculatorService  extends AsyncCalculatorService {
  override def calculateSalary(salary: Calculator): Double = {
    if (salary.pension != 0 && salary.stdLoad != 0)
      salary.taxCode match {
        case "L" => (salary.salary / 1.20) - (salary.pension) - salary.stdLoad
        case "M" => (salary.salary * 1.10) / 1.20 - (salary.pension) - salary.stdLoad
        case "N" => (salary.salary / 1.10) / 1.20 - (salary.pension) - salary.stdLoad
      } else if (salary.pension == 0 && salary.stdLoad != 0)
      salary.taxCode match {
        case "L" => (salary.salary / 1.20) - salary.stdLoad
        case "M" => (salary.salary * 1.10) / 1.20 - salary.stdLoad
        case "N" => (salary.salary / 1.10) / 1.20 - salary.stdLoad
      } else
      salary.taxCode match {
        case "L" => (salary.salary / 1.20) - (salary.pension)
        case "M" => (salary.salary * 1.10) / 1.20 - (salary.pension)
        case "N" => (salary.salary / 1.10) / 1.20 - (salary.pension)
      }

  }
}
