package com.dgdevx.sbt.cucumber.tube.train

import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers

/**
 * @author  davidgimelle on 15/01/2016.
 */
class MicrophoneSteps  extends ScalaDsl with EN with Matchers{


  When("""^I say to the microphone "(.*?)"$"""){ (message:String) =>
    Train.informPassengers(message)
  }

  Then("""^the passengers hear "(.*?)"$"""){ (message:String) =>
    assert(Train.messageToPassenger===message)
  }




}
