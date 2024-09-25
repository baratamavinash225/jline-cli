package com.avinash.cli.app.command.os

object OsClient {

  def version(): String = {
    System.getProperty("os.version")
  }

  def arch(): String = {
    System.getProperty("os.arch")
  }

  def name(): String = {
    System.getProperty("os.name")
  }

}
