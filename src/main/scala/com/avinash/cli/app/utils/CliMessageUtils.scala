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

  lazy val rootHelp: String =
    """Usage: cef <options>
      |       (to step into specific flow)
      |   or  cef
      |       (to step into REPL)
      |where options include:
      |     ? help      print this help message and exit
      |     stream      Select this for the Stream Egress Flow
      |     batch       Select this for the Batch Egress Flow
      |     schema      Search the schema in the ApiCurio Schema Registry
      |     version     Print product version and exit
      |     util        Utility Tool to check the connectivity and access
      |See https://confluence.global.tesco.org/display/TAPDD/Common+Egression+Framework for more details.""".stripMargin

  lazy val cliPrompt = "cli> "
  lazy val hiPrompt = "hi> "
  lazy val apiPrompt = "api> "

  lazy val unknownReplMessage = "Unknown command: \"%s\", run \"help/?\" for a list of commands"

  lazy val replHelp: String =
    """CEF CLI REPL has several commands available:
      |
      |? help      print this help message
      |stream      Select this for the Stream Egress Flow
      |batch       Select this for the Batch Egress Flow
      |schema      Search the schema in the ApiCurio Schema Registry
      |secret      Add/update the secrets into the CEF Stream Environment
      |version     Print product version
      |util        Utility Tool to check the connectivity and access
      |exit        Exit the interpreter
      |""".stripMargin

  lazy val hiReplHelp: String =
    """Stream REPL has several commands available:
      |
      |? help                                                     print this help message
      |list_connectors                                            Get list of connector for the domain
      |generate <connector type> <name>                           Generate connector template (valid are kafka)
      |                                                           name will be prefixed with suitable pattern
      |deploy <connector file>                                    Deploy the connector in the cluster.
      |get|pause|resume|delete|restart <connector name>           Pass the right action with connector name.
      |get_status <connector name>                                Get the connector Status
      |get_schema <schemaName>                                    Get the Schema for the topic
      |read_messages <topicName>                                  Get sample Messages(Deserialized) from kafka topic
      |exit                                                       Exit the interpreter
      |..                                                         Return to previous interpreter
      |""".stripMargin

  lazy val apiReplHelp: String =
    """Batch REPL has several commands available:
      |
      |? help                                                      print this help message
      |list_workflows                                              Get list of workflows for the domain
      |get_config|pause|resume|delete <batch name>                 Pass the right action with batch name.
      |generate <sink type> <name>                                 Generate batch template (valid are s3, sfg)
      |                                                            name will be prefixed with suitable pattern
      |deploy <batch file>                                         Deploy the batch job in the cluster.
      |run <batch name>                                            Run the workflow irrespective of the schedule.
      |                                                            This should be used in case of manual executions
      |stop                                                        Stops the running workflow instances.
      |                                                            Hint: 1. Use stop -w [workflow name] to stop all running instances in workflow.
      |                                                            Hint: 2. Use stop -i [instance name] to stop only a specific running instance in workflow.
      |get_status <batch name>                                     Get the Batch Status of last few executions.
      |exit                                                        Exit the interpreter
      |..                                                          Return to previous interpreter
      |""".stripMargin

}
