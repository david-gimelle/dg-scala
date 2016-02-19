package com.dgdevx.sbt.cucumber.tube.train

import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers

/**
 * @author  davidgimelle on 15/01/2016.
 */
class MoveSteps  extends ScalaDsl with EN with Matchers{


  When("""^"(.*?)" push the dead man's handle at level (\d+)$"""){ (driverName:String, deadLevel:Int) =>
    Train.pushDeadManTo(driverName, deadLevel)
  }

  Then("""^the train is moving at speed (\d+)$"""){ (speed:Int) =>
    //TODO use better assert features
    assert(Train.currentSpeed == speed)
  }

}
