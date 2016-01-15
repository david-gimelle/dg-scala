This is a Working template of a project Cucumber with Scala and Sbt. It has been directly inspired by http://rubygemtsl.com/2014/08/01/scala-sbt-cucumber-and-selenium-webdriver/

You can test the project with this command: sbt test

About the main files in this project:

myFirstFeature.feature contents the Cucumber tests definition
CucumberRunner.scala contents the Cucumber Runner, It defines where are the feature files to run and which scenario to run
MyFirstSteps.scala contents the implementation of the steps definition

Calculator.scala is the "application" we are testing with cucumber and ScalaTest

FunTestSuits.scala is nothing to do with Cucumber it is just an example of testing with scalaTest


