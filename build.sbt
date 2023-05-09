ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

val scalaTestVersion = "3.2.15"

lazy val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion % Test
lazy val dependencies = Seq(scalaTest)

lazy val root = (project in file("."))
  .settings(
    name := "scala-algorithms",
    ThisBuild / libraryDependencies := dependencies
  )
