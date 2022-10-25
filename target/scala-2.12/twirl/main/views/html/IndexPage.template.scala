
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
class IndexPage @javax.inject.Inject() /*8.6*/(govukButton: GovukButton, govukInsetText: GovukInsetText) extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*10.1*/("""<h1 class="govuk-heading-xl">Code Breakers</h1>

"""),_display_(/*12.2*/govukInsetText(
    InsetText(content = HtmlContent("Log in if you already have account with us, otherwise create an account"))
)),format.raw/*14.2*/("""

"""),_display_(/*16.2*/govukButton(
    Button(isStartButton = true, content = HtmlContent("Sign In"), href = Some(routes.LoginController.index().url))
)),format.raw/*18.2*/("""
"""),_display_(/*19.2*/govukButton(
    Button(isStartButton = true, content = HtmlContent("Create an account"), href = Some(routes.RegisterController.index().url))
)),format.raw/*21.2*/("""


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
                  SOURCE: app/views/IndexPage.scala.html
                  HASH: 6c494b1016e5ec62ced8be76aa794dd1344e1089
                  MATRIX: 768->51|874->111|1306->171|1382->221|1531->350|1560->353|1710->483|1738->485|1901->628
                  LINES: 26->6|29->8|37->10|39->12|41->14|43->16|45->18|46->19|48->21
                  -- GENERATED --
              */
          