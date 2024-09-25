package com.avinash.cli.app

import com.avinash.cli.app.command.api.ApiCli
import com.avinash.cli.app.command.hi.HiCli
import com.avinash.cli.app.utils.CliMessageUtils.{
  apiPrompt,
  hiPrompt,
  replHelp,
  unknownReplMessage,
  welcomeArt,
  welcomeMessage
}
import org.jline.builtins.Completers.FilesCompleter
import org.jline.reader.impl.completer.{AggregateCompleter, StringsCompleter}
import org.jline.reader.impl.{DefaultHighlighter, DefaultParser}
import org.jline.reader.{LineReader, LineReaderBuilder}
import org.jline.terminal.TerminalBuilder
import org.jline.widget.AutosuggestionWidgets

import java.io._
import java.nio.file.Paths
import scala.annotation.tailrec
import scala.jdk.CollectionConverters._
import scala.util.Try

object CliApp extends App {

  if (args.length == 1 && args(0).toLowerCase == "version") {
    println(BuildInfo.version)
  } else {
    welcome match {
      case None => System.exit(0)
      case Some(r) =>
        r.printAbove("Welcome User !!")
        Try(process(r, "cli> "))
    }
  }

  @tailrec def process(r: LineReader, PROMPT: String): Unit = {
    r.readLine(PROMPT).toLowerCase.trim match {
      case ""           => r.readLine(PROMPT)
      case "exit"       => r.printAbove("Bye!!"); System.exit(0)
      case "hi"         => HiCli.executeCli(r, PROMPT + hiPrompt)
      case "api"        => ApiCli.executeCli(r, PROMPT + apiPrompt)
      case "version"    => r.printAbove(s"${BuildInfo.version}")
      case "help" | "?" => r.printAbove(replHelp)
      case x            => r.printAbove(s"$unknownReplMessage".format(x))
    }
    process(r, PROMPT)
  }

  private def enqueueProvidedCommands(reader: LineReader): Unit = {
    reader.addCommandsInBuffer(args.toList.asJava)
  }

  @throws[IOException]
  private def welcome: Option[LineReader] = {
    val reader = LineReaderBuilder.builder
      .terminal(TerminalBuilder.terminal)
      .completer(
        new AggregateCompleter(
          new StringsCompleter(autoCompleteWords.asJava),
          new FilesCompleter(Paths.get(".").toAbsolutePath)
        )
      )
      .highlighter(new DefaultHighlighter)
      .appName("Jline-Cli")
      .parser(new DefaultParser)
      .build

    new AutosuggestionWidgets(reader).enable()

    reader.printAbove(welcomeArt)
    reader.printAbove(s"CLI Version : ${BuildInfo.version}")

    reader.printAbove(welcomeMessage)
    enqueueProvidedCommands(reader)
    Some(reader)

  }

}
