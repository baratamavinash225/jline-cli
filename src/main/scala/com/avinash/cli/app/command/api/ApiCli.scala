package com.avinash.cli.app.command.api

import com.avinash.cli.app.CliApp
import com.avinash.cli.app.utils.CliMessageUtils.{apiPrompt, apiReplHelp, unknownReplMessage}
import org.jline.reader.LineReader

import scala.annotation.tailrec

object ApiCli {
  @tailrec def executeCli(r: LineReader, PROMPT: String): Unit = {
    r.readLine(PROMPT).trim match {
      case ""               =>
      case ".."             => CliApp.process(r, PROMPT.replace(apiPrompt, ""))
      case s"call ${sName}" => r.printAbove(ApiClient.call(sName))
      case "exit"           => System.exit(0)
      case "help" | "?"     => r.printAbove(apiReplHelp)
      case x                => r.printAbove(s"$unknownReplMessage".format(x))
    }
    executeCli(r, PROMPT)
  }

}
