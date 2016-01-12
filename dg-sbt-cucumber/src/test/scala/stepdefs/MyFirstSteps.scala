package stepdefs

import com.sbtco.sandbox.JustForTesting
import cucumber.api.PendingException
import cucumber.api.scala.{ScalaDsl, EN}
import org.scalatest.{FunSuite, Matchers}
import org.scalatest.FunSuite


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
