
name := "UT-IT"

version := "0.1"

scalaVersion := "2.13.4"


lazy val eMailValidation_and_Traits = project.in(file("eMailValidation_and_Traits"))
  .settings(
    libraryDependencies ++= Seq("org.mockito" %% "mockito-scala-scalatest" % "1.15.0" % Test,"org.mockito" %% "mockito-scala" % "1.14.8"
      , "org.scalatest" %% "scalatest" % "3.2.2" % Test  ,"org.mockito" % "mockito-core" % "1.9.5" % "test")

  )

lazy val question3 = project.in(file("question3"))
  .settings(
    libraryDependencies ++= Seq("org.mockito" %% "mockito-scala-scalatest" % "1.15.0" % Test,"org.mockito" %% "mockito-scala" % "1.14.8"
      , "org.scalatest" %% "scalatest" % "3.2.2" % Test  ,"org.mockito" % "mockito-core" % "1.9.5" % "test")

  )