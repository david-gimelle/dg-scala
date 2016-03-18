name := """dg-sbt-play-crud"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "com.typesafe.slick" %% "slick" % "3.0.0",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "com.h2database" % "h2" % "1.3.175",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.0-RC1" % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"


