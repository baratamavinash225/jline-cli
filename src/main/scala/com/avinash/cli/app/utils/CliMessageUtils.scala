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
  lazy val osPrompt = "os> "

  lazy val unknownReplMessage = "Unknown command: \"%s\", run \"help/?\" for a list of commands"

  lazy val replHelp: String =
    """CLI REPL has several commands available:
      |
      |? help      print this help message
      |hi          One module in the CLI for the demo App.
      |api         One module in the CLI to call Api
      |os          Get the details about the Operation System
      |            from which CLI is running.
      |version     Print product version
      |exit        Exit the interpreter
      |""".stripMargin

  lazy val hiReplHelp: String =
    """hi REPL has several commands available:
      |
      |? help                                                     print this help message
      |print <>                                                   prints the passed string
      |exit                                                       Exit the interpreter
      |..                                                         Return to previous interpreter
      |""".stripMargin

  lazy val apiReplHelp: String =
    """api REPL has several commands available:
      |
      |? help                                                      print this help message
      |call <>                                                     Calls the Api based on the input string passed.
      |exit                                                        Exit the interpreter
      |..                                                          Return to previous interpreter
      |""".stripMargin

  lazy val osReplHelp: String =
    """os REPL has several commands available:
      |
      |? help                                                      print this help message
      |name                                                        Prints the OS Name
      |version                                                     Prints the OS Version
      |arch                                                        Prints the OS Arch
      |exit                                                        Exit the interpreter
      |..                                                          Return to previous interpreter
      |""".stripMargin

}
