import sbt._
import sbt.Keys.{versionScheme, _}
import sbtassembly.AssemblyPlugin.autoImport.{
  MergeStrategy,
  PathList,
  assembly,
  assemblyJarName,
  assemblyMergeStrategy,
  assemblyOption
}
import Dependencies._
import sbtassembly.AssemblyKeys.assemblyPrependShellScript
import sbtassembly.AssemblyPlugin.defaultUniversalScript

object Settings {
  type Setting = Seq[Def.SettingsDefinition]

  lazy val commonSettings = Seq(
    organization := "com.avinash.cli",
    resolvers ++= Seq(Resolver.mavenLocal),
    allowZombieClassLoaders := false,
    version := CliVersion.version,
    scalaVersion := "2.13.13",
    versionScheme := Some("early-semver")
  )

  lazy val CliSettings: Seq[sbt.Def.Setting[_]] = commonSettings ++
    Seq(
      libraryDependencies ++= CliDependencies
    )

  lazy val assemblySettings: Seq[sbt.Def.Setting[_]] = Seq(
    assembly / assemblyJarName := s"${name.value}.jar",
    assembly / assemblyPrependShellScript := Some(defaultUniversalScript()),
    assembly / assemblyOption := (assembly / assemblyOption).value
      .withIncludeScala(true)
      .withIncludeDependency(true),

      assembly / assemblyMergeStrategy := {
        case PathList("META-INF", xs @ _*) => MergeStrategy.discard
        case _                             => MergeStrategy.first
      }
  )

  lazy val publishArtifactSettings: Setting = Seq(
    Compile / packageBin / publishArtifact := false,
    Compile / packageDoc / publishArtifact := false,
    Compile / packageSrc / publishArtifact := false,
    addArtifact(Compile / assembly / artifact, assembly)
  )
}
