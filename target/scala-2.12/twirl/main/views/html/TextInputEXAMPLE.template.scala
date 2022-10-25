
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._
import play.twirl.api.HtmlFormat
import play.twirl.api.HtmlFormat._
import uk.gov.hmrc.govukfrontend.views.html.components._
import uk.gov.hmrc.hmrcfrontend.views.html.components._
import uk.gov.hmrc.hmrcfrontend.views.html.helpers._
import views.ViewUtils._
import models.Mode
import controllers.routes._
import viewmodels.govuk.all._

/*
 * Copyright 2022 HM Revenue & Customs
 *
 */
class TextInputEXAMPLE @javax.inject.Inject() /*6.6*/(govukButton: GovukButton, govukInput: GovukInput, govukBackLink: GovukBackLink) extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*8.2*/govukBackLink(BackLink(href = routes.HomeController.index().url))),format.raw/*8.67*/("""

"""),_display_(/*10.2*/govukInput(
    Input(id = "fieldId", name = "fieldName", value = Some("Text"))
            .withHint(Hint(id = Some("hintId"), content = HtmlContent(Html("This is a hint."))))
)),format.raw/*13.2*/("""

"""),_display_(/*15.2*/govukButton(
    ButtonViewModel(content = HtmlContent("Continue")).asLink("")
)))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/TextInputEXAMPLE.scala.html
                  HASH: 28f558d3166bde211fce9233ec8478cf70c05df4
                  MATRIX: 864->55|1317->138|1402->203|1431->206|1629->384|1658->387
                  LINES: 31->6|39->8|39->8|41->10|44->13|46->15
                  -- GENERATED --
              */
          