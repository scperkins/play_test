package global

import play.api._
import play.api.mvc._
import play.api.mvc.Results._
import scala.concurrent.Future
import com.typesafe.config.ConfigFactory

object Global extends GlobalSettings {
	val conf = ConfigFactory.load()
	val data = conf.getString("data"		)
	lazy val xmlData = scala.xml.XML.loadFile(data)

	override def onStart(app: Application) {
		Logger.info("[+] Loading XML file...")
		xmlData
	}

	// 404 - page not found error
 	override def onHandlerNotFound(request: RequestHeader) = {
   		Future.successful(NotFound(
      		views.html.notFound()
    	))
 	}
}