package views.html

/** See the [[https://scalacourses.com/student/showLecture/116 WebJars]] lecture. */
object webjar {
  @inline
  def apply(file: String)(implicit webJarAssets: controllers.WebJarAssets) =
    controllers.routes.WebJarAssets.at(webJarAssets.locate(file))
}
