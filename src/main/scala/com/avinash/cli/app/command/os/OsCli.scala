package com.avinash.cli.app.command.os

import com.avinash.cli.app.CliApp
import com.avinash.cli.app.utils.CliMessageUtils.{osPrompt, osReplHelp, unknownReplMessage}
import org.jline.reader.LineReader

import scala.annotation.tailrec

object OsCli {

  @tailrec def executeCli(r: LineReader, PROMPT: String): Unit = {
    r.readLine(PROMPT).trim match {
      case ""           =>
      case ".."         => CliApp.process(r, PROMPT.replace(osPrompt, ""))
      case "name"       => r.printAbove(OsClient.name())
      case "version"    => r.printAbove(OsClient.version())
      case "arch"       => r.printAbove(OsClient.arch())
      case "exit"       => System.exit(0)
      case "help" | "?" => r.printAbove(osReplHelp)
      case x            => r.printAbove(s"$unknownReplMessage".format(x))
    }
    executeCli(r, PROMPT)
  }

}
