package com.dgdevx.sbt.cucumber.example.stepdefs

import com.dgdevx.sbt.cucumber.example.JustForTesting
import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.{FunSuite, Matchers}


/**
 * @author  davidgimelle on 08/01/2016.
 */
class MyFirstSteps extends FunSuite with ScalaDsl with EN with Matchers {

  test("Just for test") {
    assert(5 == 5)
  }

  Given( """^I have navigated to google$""") { ()=>
    assert(5 == 5)
    assert((new JustForTesting()).constant == 5)

  }

  When( """^I search for "(.*?)"$""") { (arg0:String) =>
    assert((new JustForTesting()).constant == 5)
  }


  Then("""^the page title should be selenium - Google Search$"""){ () =>
    assert(5 == 5)
  }

}
