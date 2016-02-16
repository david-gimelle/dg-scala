package com.dgdevx.sbt.cucumber

import cucumber.api.junit.Cucumber
import cucumber.api.junit.Cucumber.Options
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@Options(
  features = Array("src/test/resources/features/"),
  glue = Array("com.dgdevx.sbt.cucumber.example.stepdefs", "com.dgdevx.sbt.cucumber.tube.train"),
  format = Array("pretty", "html:target/cucumber-report"),
  tags = Array("@wip")
)
class CucumberRunner {

}


