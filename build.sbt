// See the [https://scalacourses.com/student/showLecture/84](SBT Global Setup),
// [https://scalacourses.com/student/showLecture/135](SBT Project Setup) and
// [https://scalacourses.com/student/showLecture/169](Standard Files and Directories and Improved Template) lectures

import sbt._
import sbt.Keys._

name         := "play25-template" // TODO change "play25-template" to a project name that you like
organization := "com.micronautics"
version      := "0.2.2"

herokuAppName in Compile := "play25-template" // TODO change "play25-template" to a project name that you like

scalaVersion := "2.11.11"

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-target:jvm-1.8",
  "-unchecked",
  "-Ywarn-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-unused",
  "-Ywarn-value-discard",
  "-Xfuture",
  "-Xlint"
)

javacOptions ++= Seq(
  "-Xlint:deprecation",
  "-Xlint:unchecked",
  "-source", "1.8",
  "-target", "1.8",
  "-g:vars"
)

libraryDependencies ++= Seq(
//  anorm,
//  cache,
//  evolutions,
//  filters,
//  jdbc,
//  json,
//  ws,
//  "com.typesafe.play"      %% "play-mailer"        % "5.0.0" withSources(),
  "com.typesafe.akka"      %% "akka-slf4j"         % "2.4.17",
  "net.codingwell"         %% "scala-guice"        % "4.1.0",
  "org.webjars"            %% "webjars-play"       % "2.5.0-4",
  "org.webjars"            %  "bootstrap"          % "3.3.7-1",
//  "com.github.tototoshi"   %% "slick-joda-mapper"  % "2.0.0" withSources(),
  "com.typesafe"           %  "config"             % "1.3.0" withSources(),
//  "com.typesafe.slick"     %% "slick"              % "3.1.1" withSources(),
//  "com.typesafe.play"      %% "play-slick"         % "2.0.2" withSources(),
//  "postgresql"             %  "postgresql"         % "9.1-901-1.jdbc4" withSources(),
//  "com.github.nscala-time" %% "nscala-time"        % "2.16.0" withSources(),
  "org.webjars"            %  "jquery-ui"          % "1.12.1",
  "org.webjars"            %  "jquery-ui-themes"   % "1.12.1",
  //
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
  "junit"                  %  "junit"              % "4.12"  % Test
)

lazy val root = (project in file(".")).enablePlugins(PlayScala)
enablePlugins(ApiMappings)

logLevel := Level.Warn
logLevel in compile := Level.Warn
logLevel in test := Level.Info // Level.Info is needed to see detailed output when running tests

javaOptions in Test += "-Dconfig.file=conf/dev.conf"
logBuffered in Test := false
fork in Test := true
parallelExecution in Test := false

resolvers ++= Seq(
  "webjars" at "http://webjars.github.com/m2",
  //Resolver.file("Local Repository", file(sys.env.get("PLAY_HOME").map(_ + "/repository/local").getOrElse("")))(Resolver.ivyStylePatterns),
  Resolver.url("play-plugin-releases", new URL("http://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns)
)

// define the statements initially evaluated when entering 'console', 'console-quick', or 'console-project'
initialCommands := """import scala.language.postfixOps
                     |import java.net.URL
                     |import java.text.DateFormat
                     |import java.util.Locale
                     |import play.api._
                     |import play.api.db.DB
                     |import play.api.i18n._
                     |import play.api.libs.json._
                     |import play.api.Play.current
                     |import play.Logger
                     |import scala.reflect.runtime.universe._
                     |import views.html.helper._
                     |""".stripMargin
