package com.avinash.cli.app.command.hi

import com.avinash.cli.app.CliApp
import com.avinash.cli.app.utils.CliMessageUtils.{hiPrompt, hiReplHelp, unknownReplMessage}
import org.jline.reader.LineReader

import scala.annotation.tailrec

object HiCli {

  @tailrec def executeCli(r: LineReader, PROMPT: String): Unit = {
    r.readLine(PROMPT).trim match {
      case "" =>
      case ".."              => CliApp.process(r, PROMPT.replace(hiPrompt, ""))
      case s"print ${sName}" => r.printAbove(HiClient.print(sName))
      case "exit"            => System.exit(0)
      case "help" | "?"      => r.printAbove(hiReplHelp)
      case x                 => r.printAbove(s"$unknownReplMessage".format(x))
    }
    executeCli(r, PROMPT)
  }

}
