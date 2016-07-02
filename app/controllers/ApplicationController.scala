package controllers

import javax.inject._
import akka.stream.Materializer
import play.api._
import play.api.cache.Cached
import play.api.i18n.MessagesApi
import play.api.mvc._
import scala.concurrent.ExecutionContext

/** The [[https://scalacourses.com/student/showLecture/14 Play 2 Controllers]] lecture discusses this class.
  * The [[https://scalacourses.com/student/showLecture/249 Using Google Guice for Dependency Injection]] lecture
  * discusses each of the injected parameters. */
@Singleton
class ApplicationController @Inject() ( // order of these explicit parameters does not matter
//  cached: Cached,
//  config: Configuration,
//  val messagesApi: MessagesApi // this parameter must be a property
)( // order of these implicit parameters does not matter
  implicit webJarAssets: WebJarAssets
//  ex: ExecutionContext,
//  mat: Materializer,
//  env: Environment
) extends Controller {
  // @see https://scalacourses.com/student/showLecture/129
  val Logger = org.slf4j.LoggerFactory.getLogger("application")

  def help = Action { implicit request =>
    Ok(views.html.play20.welcome("Play Help"))
  }

  def hello(name: String) = Action { implicit request =>
    Ok(views.html.hello(if (name.isEmpty) "Everybody" else name))
  }
}
