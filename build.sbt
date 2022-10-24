name := """code-breakers"""
organization := "com.code-breakers"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.10"

libraryDependencies += guice
libraryDependencies ++= Seq(
  guice,
  "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
  "org.mongodb.scala" %% "mongo-scala-driver" % "4.6.0",
  "org.webjars.npm" % "bootstrap" % "5.2.2",
  "uk.gov.hmrc" %% "play-frontend-hmrc" % "x.y.z-play-28"
)


// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.code-breakers.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.code-breakers.binders._"
