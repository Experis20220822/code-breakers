
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
class RegisterPage @javax.inject.Inject() /*8.6*/(govukSelect: GovukSelect, govukButton: GovukButton, govukFieldset: GovukFieldset, govukInput: GovukInput) extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*10.1*/("""<div class="govuk-width-container">
  <a href="/" class="govuk-back-link">Back</a>

  <main class="govuk-main-wrapper">

    <div class="govuk-grid-row">
      <div class="govuk-grid-column-two-thirds">
        <h1 class="govuk-heading-xl">Create an account</h1>
        <div class="govuk-inset-text">
          Create your account details here
        </div>
      </div>
    </div>

    <div class="govuk-form-group">
      <h1 class="govuk-label-wrapper"><label class="govuk-label govuk-label--l" for="email">
        Email
      </label>
      </h1>
      <input class="govuk-input" id="email" name="email" type="text">
    </div>

    <div class="govuk-form-group">
      <h1 class="govuk-label-wrapper"><label class="govuk-label govuk-label--l" for="username">
        Create a username
      </label>
      </h1>
      <input class="govuk-input" id="username" name="username" type="text">
    </div>

    <div class="govuk-form-group">
      <h1 class="govuk-label-wrapper"><label class="govuk-label govuk-label--l" for="password">
        Create a password
      </label>
      </h1>
      <input class="govuk-input" id="password" name="password" type="text">
    </div>

    <a href=""""),_display_(/*48.15*/routes/*48.21*/.RegisterController.create()),format.raw/*48.49*/("""" role="button" draggable="false" class="govuk-button govuk-button--start" data-module="govuk-button">
      Create an account
      <svg class="govuk-button__start-icon" xmlns="http://www.w3.org/2000/svg" width="17.5" height="19" viewBox="0 0 33 40" aria-hidden="true" focusable="false">
        <path fill="currentColor" d="M0 0h13l20 20-20 20H0l20-20z" />
      </svg></a>



  </main>
</div>

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
                  SOURCE: app/views/RegisterPage.scala.html
                  HASH: 1fd492fdf4390f9fd61cc7373eb8da16a09e6ffd
                  MATRIX: 768->56|877->118|1357->228|2616->1460|2631->1466|2680->1494
                  LINES: 26->6|29->8|37->10|75->48|75->48|75->48
                  -- GENERATED --
              */
          