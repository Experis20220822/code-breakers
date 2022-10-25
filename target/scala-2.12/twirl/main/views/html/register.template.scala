
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
/*6.2*/import uk.gov.hmrc.govukfrontend.views.html.components._
/*7.2*/import uk.gov.hmrc.govukfrontend.views.html.components.implicits._
/*8.2*/import uk.gov.hmrc.govukfrontend.views.Implicits._
/*9.2*/import views.html.RegisterPage

/**/
class register @javax.inject.Inject() /*11.6*/(layout: Layout, content: RegisterPage) extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[String,String,String,Request[_$1] forSome { 
   type _$1
},Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*13.2*/(pageTitle: String, heading: String, message: String)(implicit request: Request[_], messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*15.2*/import uk.gov.hmrc.play._


Seq[Any](format.raw/*14.1*/("""
"""),format.raw/*16.1*/("""
"""),_display_(/*17.2*/layout(pageTitle = pageTitle, isWelshTranslationAvailable = true)/*17.67*/ {_display_(Seq[Any](format.raw/*17.69*/("""
 """),_display_(/*18.3*/content()),format.raw/*18.12*/("""
""")))}))
      }
    }
  }

  def render(pageTitle:String,heading:String,message:String,request:Request[_$1] forSome { 
   type _$1
},messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(pageTitle,heading,message)(request,messages)

  def f:((String,String,String) => (Request[_$1] forSome { 
   type _$1
},Messages) => play.twirl.api.HtmlFormat.Appendable) = (pageTitle,heading,message) => (request,messages) => apply(pageTitle,heading,message)(request,messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/register.scala.html
                  HASH: 968765d7a959ad517dad35bcc08b549dd4fd5813
                  MATRIX: 768->51|832->109|906->177|964->229|1047->266|1439->308|1616->414|1671->412|1699->440|1727->442|1801->507|1841->509|1870->512|1900->521
                  LINES: 26->6|27->7|28->8|29->9|32->11|37->13|40->15|43->14|44->16|45->17|45->17|45->17|46->18|46->18
                  -- GENERATED --
              */
          