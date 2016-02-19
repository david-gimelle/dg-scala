package com.dgdevx.sbt.cucumber.tube.train

import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers

/**
 * @author  davidgimelle on 15/01/2016.
 */
class DoorSteps extends ScalaDsl with EN with Matchers {

  When("""^"(.*?)" closes the doors$"""){ (driverName:String) =>
    Train.orderToCloseDoors(driverName)
  }

  Then("""^the train's doors are closed$"""){ () =>
    assert(Train.doorClosed);
  }

  When("""^"(.*?)" opens the doors$"""){ (driverName:String) =>
    Train.orderToOpenDoors(driverName)
  }

  Then( """^the train's doors are opened$""") { () =>
    assert(!Train.doorClosed)
  }



}
