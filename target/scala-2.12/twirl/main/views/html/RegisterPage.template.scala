
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
/*7.2*/import uk.gov.hmrc.govukfrontend.views.html.components._
/*8.2*/import uk.gov.hmrc.govukfrontend.views.html.components.implicits._
/*9.2*/import uk.gov.hmrc.govukfrontend.views.Implicits._
/*10.2*/import uk.gov.hmrc.hmrcfrontend.views.html.components.implicits._
/*11.2*/import uk.gov.hmrc.govukfrontend.views.viewmodels.input.PrefixOrSuffix
/*13.2*/import viewmodels.InputWidth._

/**/
class RegisterPage @javax.inject.Inject() /*15.6*/(
    formHelper: FormWithCSRF,
    layout: views.html.Layout,
    govukErrorSummary: GovukErrorSummary,
    govukInput: GovukInput,
    govukButton: GovukButton,
    govukBackLink: GovukBackLink,
    govukHint: GovukHint
) extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Form[_$1] forSome { 
   type _$1
},Mode,Request[_$2] forSome { 
   type _$2
},Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*25.2*/(form: Form[_], mode: Mode)(implicit request: Request[_], messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*27.2*/import uk.gov.hmrc.play._


Seq[Any](format.raw/*25.79*/("""

"""),format.raw/*28.1*/("""
"""),_display_(/*29.2*/layout(pageTitle = title(form, messages("User")), isWelshTranslationAvailable = true)/*29.87*/ {_display_(Seq[Any](format.raw/*29.89*/("""
    """),_display_(/*30.6*/govukBackLink(BackLink(href = routes.HomeController.index().url))),format.raw/*30.71*/("""

    """),format.raw/*32.5*/("""<h1 class="govuk-heading-l">"""),_display_(/*32.34*/messages("Create an Account")),format.raw/*32.63*/("""</h1>

    """),_display_(/*34.6*/formHelper(action = routes.RegisterController.create(), 'autoComplete -> "off")/*34.85*/ {_display_(Seq[Any](format.raw/*34.87*/("""

        """),_display_(/*36.10*/govukInput(Input(
            id = "email",
            name = "email",
            label = Label(content = Text("Email")),
            value = form("email").value,
            errorMessage = form("email").error.map(err => ErrorMessage(content = Text(messages("This field must not be blank")))),
            classes = "govuk-!-width-one-half",
        ))),format.raw/*43.11*/("""

        """),_display_(/*45.10*/govukInput(Input(
            id = "username",
            name = "username",
            label = Label(content = Text(messages("Username"))),
            value = form("username").value,
            errorMessage = form("username").error.map(err => ErrorMessage(content = Text(messages("This field must not be blank")))),
            classes = "govuk-!-width-one-half"
        ))),format.raw/*52.11*/("""

        """),_display_(/*54.10*/govukInput(Input(
            id = "password",
            name = "password",
            label = Label(content = Text(messages("Password"))),
            value = form("password").value,
            errorMessage = form("password").error.map(err => ErrorMessage(content = Text(messages("This field must not be blank")))),
            classes = "govuk-!-width-one-half",
            inputType = "password"
        ))),format.raw/*62.11*/("""

        """),_display_(/*64.10*/govukButton(
            Button(href = Some(routes.CalculatorController.index().url), content = HtmlContent("Create Account"))
        )),format.raw/*66.10*/("""
    """)))}),format.raw/*67.6*/("""
""")))}))
      }
    }
  }

  def render(form:Form[_$1] forSome { 
   type _$1
},mode:Mode,request:Request[_$2] forSome { 
   type _$2
},messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(form,mode)(request,messages)

  def f:((Form[_$1] forSome { 
   type _$1
},Mode) => (Request[_$2] forSome { 
   type _$2
},Messages) => play.twirl.api.HtmlFormat.Appendable) = (form,mode) => (request,messages) => apply(form,mode)(request,messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/RegisterPage.scala.html
                  HASH: 4e5860be0c29018a1493bd23164531199e9c17ed
                  MATRIX: 768->56|829->112|893->171|967->240|1026->293|1100->361|1179->436|1266->475|1873->711|2024->793|2080->788|2111->820|2140->823|2234->908|2274->910|2307->917|2393->982|2428->990|2484->1019|2534->1048|2574->1062|2662->1141|2702->1143|2742->1156|3124->1517|3164->1530|3570->1915|3610->1928|4053->2350|4093->2363|4252->2501|4289->2508
                  LINES: 26->6|27->7|28->8|29->9|30->10|31->11|32->13|35->15|50->25|53->27|56->25|58->28|59->29|59->29|59->29|60->30|60->30|62->32|62->32|62->32|64->34|64->34|64->34|66->36|73->43|75->45|82->52|84->54|92->62|94->64|96->66|97->67
                  -- GENERATED --
              */
          