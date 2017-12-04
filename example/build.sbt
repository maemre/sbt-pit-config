import org.pitest.sbt.PitKeys._

name := "example"

organization := "com.example"

version := "1.0"

scalaVersion := "2.11.11"
crossScalaVersions := Seq("2.11.11")

resolvers += Resolver.url("scoverage-bintray", url("https://dl.bintray.com/sksamuel/sbt-plugins/"))(Resolver.ivyStylePatterns)

// ScalaTest
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"

// Pitest
// see sbt-pit/src/main/scala/org/pitest/sbt/PitKeys.scala for all options
verbose := true
timestampedReports := false
targetClasses := Seq("typechecker.Typechecker*")
targetTests := Seq("typechecker.*")
excludedMethods := Seq("hashCode", "equals")
