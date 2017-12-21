import sbt.Resolver

name := "tg-util"

version := "0.1"

scalaVersion := "2.12.4"

resolvers ++= Seq(
  Resolver.sonatypeRepo("snapshots"),
  Resolver.sonatypeRepo("releases")
)

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.1.2",
  "org.typelevel" %% "cats-core" % "1.0.0-MF",
  "org.apache.commons" % "commons-math3" % "3.6.1",
  "info.mukel" %% "telegrambot4s" % "3.0.14"
)
