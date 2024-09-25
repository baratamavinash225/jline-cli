package com.avinash.cli.app.utils

object CliMessageUtils {

  lazy val welcomeArt: String =
    """
      |_________ .____    .___
      |\_   ___ \|    |   |   |
      |/    \  \/|    |   |   |
      |\     \___|    |___|   |
      | \______  /_______ \___|
      |        \/        \/
      | """.stripMargin

  lazy val welcomeMessage: String = "Hi there, welcome to Jline CLI!"

  lazy val hiPrompt = "hi> "
  lazy val apiPrompt = "api> "

  lazy val unknownReplMessage = "Unknown command: \"%s\", run \"help/?\" for a list of commands"

  lazy val replHelp: String =
    """CEF CLI REPL has several commands available:
      |
      |? help      print this help message
      |hi          One module in the CLI for the demo App.
      |api         One module in the CLI to call Api
      |version     Print product version
      |exit        Exit the interpreter
      |""".stripMargin

  lazy val hiReplHelp: String =
    """Stream REPL has several commands available:
      |
      |? help                                                     print this help message
      |print <>                                                   prints the passed string
      |exit                                                       Exit the interpreter
      |..                                                         Return to previous interpreter
      |""".stripMargin

  lazy val apiReplHelp: String =
    """Batch REPL has several commands available:
      |
      |? help                                                      print this help message
      |call <>                                                     Calls the Api based on the input string passed.
      |exit                                                        Exit the interpreter
      |..                                                          Return to previous interpreter
      |""".stripMargin

}
