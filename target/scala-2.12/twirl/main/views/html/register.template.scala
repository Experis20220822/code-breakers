
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


Seq[Any](format.raw/*13.105*/("""

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
                  HASH: 9740addaa898b1056b292feea1e682466067915f
                  MATRIX: 768->56|832->115|906->184|964->237|1047->276|1441->320|1618->428|1675->423|1706->455|1735->458|1809->523|1849->525|1879->529|1909->538
                  LINES: 26->6|27->7|28->8|29->9|32->11|37->13|40->15|43->13|45->16|46->17|46->17|46->17|47->18|47->18
                  -- GENERATED --
              */
          