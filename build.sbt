import Settings._

val root = Project(id = "jline-cli", base = file("."))
  .settings(CliSettings: _*)
  .settings(assemblySettings: _*)
  .settings(publishArtifactSettings: _*)
  .enablePlugins(BuildInfoPlugin)
  .settings(
    buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    buildInfoPackage := "com.avinash.cli.app"
  )

lazy val publishJlineCli = taskKey[Unit]("Publish jline-cli")

publishJlineCli := {
  Def
    .sequential(
      clean,
      compile,
      assembly
    )
    .value
}
