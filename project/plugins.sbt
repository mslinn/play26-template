import sbt._
import sbt.Keys._

resolvers ++= Seq(
  "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/",
  "SBT Community repository" at "http://dl.bintray.com/sbt/sbt-plugin-releases/"
)

// Comment to get more information during initialization
//logLevel := Level.Warn

addSbtPlugin("com.typesafe.play" % "sbt-plugin"       % "2.6.6")

// optional plugins
//addSbtPlugin("com.typesafe.sbt"  % "sbt-coffeescript" % "1.0.1")
//addSbtPlugin("com.typesafe.sbt"  % "sbt-less"         % "1.1.2")
//addSbtPlugin("com.typesafe.sbt"  % "sbt-jshint"       % "1.0.5")
//addSbtPlugin("com.typesafe.sbt"  % "sbt-rjs"          % "1.0.9")
//addSbtPlugin("com.typesafe.sbt" % "sbt-digest" % "1.1.3")
//addSbtPlugin("com.typesafe.sbt" % "sbt-mocha" % "1.1.2")

// See https://github.com/jrudolph/sbt-dependency-graph
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.8.2")

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.2.2")

addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.3.2")

addSbtPlugin("de.johoop" % "findbugs4sbt" % "1.4.0")

addSbtPlugin("com.thoughtworks.sbt-api-mappings" % "sbt-api-mappings" % "1.0.0")

libraryDependencies ++= Seq(
  "com.puppycrawl.tools" % "checkstyle" % "8.3"
)
