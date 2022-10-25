
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
/*6.2*/import views.html.helper.CSPNonce
/*7.2*/import uk.gov.hmrc.hmrcfrontend.views.html.helpers.HmrcLayout
/*8.2*/import views.html.helper.CSPNonce
/*9.2*/import config.AppConfig

/**/
class Layout @javax.inject.Inject() /*11.6*/(hmrcLayout: HmrcLayout, govukBackLink: GovukBackLink) extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[String,Boolean,Html,Request[_$1] forSome { 
   type _$1
},Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*13.2*/(pageTitle: String,
        isWelshTranslationAvailable: Boolean)(contentBlock: Html)(implicit request: Request[_], messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*14.116*/("""

    """),_display_(/*16.6*/hmrcLayout(
        pageTitle = Some(pageTitle),
        displayHmrcBanner = true,
        nonce = CSPNonce.get,
        isWelshTranslationAvailable = isWelshTranslationAvailable
    )/*21.6*/(contentBlock)),format.raw/*21.20*/("""
"""))
      }
    }
  }

  def render(pageTitle:String,isWelshTranslationAvailable:Boolean,contentBlock:Html,request:Request[_$1] forSome { 
   type _$1
},messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(pageTitle,isWelshTranslationAvailable)(contentBlock)(request,messages)

  def f:((String,Boolean) => (Html) => (Request[_$1] forSome { 
   type _$1
},Messages) => play.twirl.api.HtmlFormat.Appendable) = (pageTitle,isWelshTranslationAvailable) => (contentBlock) => (request,messages) => apply(pageTitle,isWelshTranslationAvailable)(contentBlock)(request,messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/Layout.scala.html
                  HASH: 4392be0f0079d6b81b2d8926f898d4723149afdc
                  MATRIX: 768->56|809->92|878->156|919->192|993->224|1401->283|1634->419|1669->428|1866->617|1901->631
                  LINES: 26->6|27->7|28->8|29->9|32->11|37->13|43->14|45->16|50->21|50->21
                  -- GENERATED --
              */
          