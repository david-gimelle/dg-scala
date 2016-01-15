package com.dgdevx.sbt.cucumber.tube.train

import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers

/**
 * @author  davidgimelle on 15/01/2016.
 */
class TrainSteps  extends ScalaDsl with EN with Matchers{

  Given("""^I have control of the train$"""){ () =>
  }

  Then("""^the train makes a beep$"""){ () =>
  }


}
