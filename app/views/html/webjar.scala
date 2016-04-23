package views.html

object webjar {
  @inline
  def apply(file: String) = controllers.routes.WebJarAssets.at(controllers.WebJarAssets.locate(file))
}
