import sbt._

object Version {

  val circeVersion = "0.14.6"
  val sttp3Version = "3.9.5"
  val avroVersion = "1.9.2"
  val munitCatsEffectVersion = "0.7.0"
  val catsRetryVersion = "2.0.0"
  val avro4sVersion = "4.0.0"
  val lihaoyiVersion = "0.6.9"
  val json4sVersion = "4.0.6"

  val jLineVersion = "3.25.0"

  val picocliVersion = "4.7.1"
  val scalatestVersion = "3.2.15"
  val okioJvmVersion = "3.9.0"
  val wiremockVersion = "3.0.1"

}

object Library {

  import Version._

  val circeParser = "io.circe" %% "circe-parser" % circeVersion
  val circeCore = "io.circe" %% "circe-core" % circeVersion
  val circeGeneric = "io.circe" %% "circe-generic" % circeVersion
  val circeGenericExtras = "io.circe" %% "circe-generic-extras" % circeVersion
  val circeYaml = "io.circe" %% "circe-yaml" % circeVersion

  val avro4s = "com.sksamuel.avro4s" %% "avro4s-core" % avro4sVersion
  val avro4sJson = "com.sksamuel.avro4s" %% "avro4s-json" % avro4sVersion

  val sttp3 = "com.softwaremill.sttp.client3" %% "core" % sttp3Version
  val sttp3OkHttp =
    "com.softwaremill.sttp.client3" %% "okhttp-backend" % sttp3Version excludeAll
      (ExclusionRule(organization = "com.squareup.okio"),
      ExclusionRule(organization = "org.jetbrains.kotlin"))

  val okioJvm = "com.squareup.okio" % "okio-jvm" % okioJvmVersion

  val sttp3Logging = "com.softwaremill.sttp.client3" %% "slf4j-backend" % sttp3Version

  val sttp3Circe = "com.softwaremill.sttp.client3" %% "circe" % sttp3Version

  val circeOptics = "io.circe" %% "circe-optics" % circeVersion

  val cirisCatsEffect3 = "is.cir" %% "ciris" % "2.0.0-RC2"
  val scalacheck = "org.scalacheck" %% "scalacheck" % "1.15.4"
  val lihaoyi = "com.lihaoyi" %% "requests" % lihaoyiVersion

  val jLine = "org.jline" % "jline" % jLineVersion
  val jLineReader = "org.jline" % "jline-reader" % jLineVersion
  val jLineTerminal = "org.jline" % "jline-terminal" % jLineVersion
  val jLineTerminaJansi = "org.jline" % "jline-terminal-jansi" % jLineVersion
  val jLineTerminalJna = "org.jline" % "jline-terminal-jna" % jLineVersion
  val jLineConsole = "org.jline" % "jline-console" % jLineVersion
  val jLineBuiltIn = "org.jline" % "jline-builtins" % jLineVersion

  val picocli = "info.picocli" % "picocli" % picocliVersion
  val picocliJline = "info.picocli" % "picocli-shell-jline3" % picocliVersion

  val scalactic = "org.scalactic" %% "scalactic" % scalatestVersion % "test"

  val scalaTest = "org.scalatest" %% "scalatest" % scalatestVersion % "test"
  val wiremockTest = "com.github.tomakehurst" % "wiremock" % wiremockVersion
}

object Dependencies {

  lazy val CliDependencies: Seq[ModuleID] = Seq(
    Library.lihaoyi,
    Library.jLine,
    Library.jLineReader,
    Library.jLineTerminal,
    Library.jLineTerminaJansi,
    Library.jLineTerminalJna,
    Library.jLineConsole,
    // Library.jLineBuiltIn,
    Library.circeParser,
    Library.sttp3,
    Library.sttp3OkHttp,
    Library.circeGeneric,
    Library.scalactic,
    Library.scalaTest,
    Library.okioJvm,
    Library.wiremockTest
  )
}
