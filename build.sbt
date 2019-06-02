ThisBuild / scalaVersion     := "2.12.6"
ThisBuild / version          := "0.1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .settings(
    name := "CodeJam"
  )

unmanagedSourceDirectories in Compile := (scalaSource in Compile).value :: Nil
