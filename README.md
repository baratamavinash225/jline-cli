# jline-cli

This is the simple repo to build CLI application using the `org.jline` package with scala.

## Features
* As for the starters it is only printing strings in response, but this can be extended to perform anything in specific to client Applications.
* This can be directly launched from the local and run the CLI.


## Stack
* Scala 2.13.12
* sbt 1.6.2
* java 17

## Build
```shell
sbt clean compile
```

## Package
```shell
sbt clean compile assembly
```

## Run
```shell
java -cp <path-to-executable-jar> com.avinash.cli.app.CliApp
```