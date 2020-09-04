lazy val root = (project in file("."))
  .aggregate(core, functors)

lazy val core = (project in file("core"))
  .settings(libraryDependencies ++= Seq(
    "org.typelevel" %% "cats-effect" % "2.1.3"
  ))
  .settings(CommonSettings.settings)

lazy val monoids = (project in file("monoids"))
  .settings(CommonSettings.settings)
  .dependsOn(core)

lazy val functors = (project in file("functors"))
  .settings(CommonSettings.settings)
  .dependsOn(core)

lazy val monads = (project in file("monads"))
  .settings(CommonSettings.settings)
  .dependsOn(core)
