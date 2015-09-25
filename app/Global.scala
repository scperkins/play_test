import play.api._
import play.api.mvc._
import play.api.mvc.Results._
import scala.concurrent.Future

object Global extends GlobalSettings {
	override def onStart(app: Application) {
		Logger.info("[+] Loading XML file...")
		val xmlData = scala.xml.XML.loadFile("conf/data.xml")
	}

	// // 404 - page not found error
 // 	override def onHandlerNotFound(request: RequestHeader) = {
 //   		Future.successful(NotFound(
 //      		views.html.notFoundPage(request.path)
 //    	))
 // 	}
}