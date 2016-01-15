package com.dgdevx.sbt.cucumber.tube.train

import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers

/**
 * @author  davidgimelle on 15/01/2016.
 */
class MicrophoneSteps  extends ScalaDsl with EN with Matchers{


  When("""^I say to the microphone "(.*?)"$"""){ (arg0:String) =>
  }

  Then("""^the passengers hear "(.*?)"$"""){ (arg0:String) =>
  }




}
