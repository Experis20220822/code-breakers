/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

import com.google.inject.{AbstractModule}
import services._

class Module extends AbstractModule{
  override def configure(): Unit = {

    bind(classOf[AsyncExpenseService]).to(classOf[MongoExpenseService])
  }
}

