package views.html

object webjar {
  @inline
  def apply(file: String)(implicit webJarAssets: controllers.WebJarAssets) =
    controllers.routes.WebJarAssets.at(webJarAssets.locate(file))
}
