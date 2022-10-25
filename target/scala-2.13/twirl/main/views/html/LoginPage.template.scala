
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
/*6.2*/import uk.gov.hmrc.govukfrontend.views.Aliases.Button

/**/
class LoginPage @javax.inject.Inject() /*8.6*/(govukButton: GovukButton, govukInput: GovukInput, govukBackLink: GovukBackLink) extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*9.2*/govukBackLink(BackLink(href = routes.HomeController.index().url))),format.raw/*9.67*/("""

        """),format.raw/*11.9*/("""<h1 class="govuk-heading-xl">Log In</h1>
        <div class="govuk-inset-text">
          Use the same details you used to register for the service.
        </div>

    <div class="govuk-form-group">
      <h1 class="govuk-label-wrapper"><label class="govuk-label govuk-label--l" for="event-name">
        Username
      </label>
      </h1>
      <input class="govuk-input" id="event-name" name="event-name" type="text">
    </div>

    <div class="govuk-form-group">
      <h1 class="govuk-label-wrapper"><label class="govuk-label govuk-label--l" for="event-name">
        Password
      </label>
      </h1>
      <input class="govuk-input" id="event-name" name="event-name" type="text">
    </div>
    """),_display_(/*31.6*/govukButton(Button(href = Some("#"), content = HtmlContent("Sign In")))),format.raw/*31.77*/("""



"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/LoginPage.scala.html
                  HASH: 2ffcb7006bfd42e9f4f564ca69f948de0e89946d
                  MATRIX: 768->51|874->111|1327->193|1412->258|1449->268|2182->975|2274->1046
                  LINES: 26->6|29->8|37->9|37->9|39->11|59->31|59->31
                  -- GENERATED --
              */
          