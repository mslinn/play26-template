package controllers

import javax.inject.{Inject, Provider}
import play.api.i18n.I18nSupport
import play.api.mvc.{MessagesAbstractController, MessagesControllerComponents}
import play.api.routing.Router
import play.twirl.api.Html

class PathController @Inject()(
  mcc: MessagesControllerComponents,
  routesProvider: Provider[Router]
) extends MessagesAbstractController(mcc) with I18nSupport {
  lazy val routeDocs: Seq[(String, String, String)] = routesProvider.get.documentation

  def index = Action { implicit request =>
    val info: String = routeDocs.map { case (method, path, controllerMethod) =>
      s"""method: $method
         |path: $path
         |controllerMethod: $controllerMethod
         |""".stripMargin
    }.mkString("<pre>", "\n", "</pre>")
    Ok(Html(info))
  }
}
