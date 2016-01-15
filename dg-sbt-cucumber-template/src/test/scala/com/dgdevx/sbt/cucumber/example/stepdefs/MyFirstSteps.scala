package com.dgdevx.sbt.cucumber.example.stepdefs

import com.dgdevx.sbt.cucumber.example.Calculator
import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.{Matchers}


/**
 * @author  davidgimelle on 08/01/2016.
 */
class MyFirstSteps extends ScalaDsl with EN with Matchers {

  var res = 0

  Given( """^I like to make some calculation$""") { () =>
    //// Write code here that turns the phrase above into concrete actions
  }

  When( """^I add (\d+) and (\d+)$""") { (arg0: Int, arg1: Int) =>
    res = new Calculator().addStuff(arg0, arg1)
  }

  Then( """^I expect the result will be (\d+)$""") { (arg0: Int) =>
    assert(res == arg0)
  }

}
