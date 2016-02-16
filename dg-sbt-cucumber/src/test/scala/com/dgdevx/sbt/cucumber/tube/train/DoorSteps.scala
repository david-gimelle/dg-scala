package com.dgdevx.sbt.cucumber.tube.train

import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers

/**
 * @author  davidgimelle on 15/01/2016.
 */
class DoorSteps extends ScalaDsl with EN with Matchers {

  When( """^I push the close door button$""") { () =>

    Train.closeDoor();
  }

  When("""^"(.*?)" closes the doors$"""){ (driverName:String) =>
    //TODO check it is marco in closeDoor function
    Train.closeDoor();
  }


  When("""^Marco closes the doors$"""){ () =>

  }

  When( """^I push the open door button$""") { () =>
  }

  Then( """^the train closes its doors$""") { () =>
  }

  Then( """^the train opens its doors$""") { () =>
  }

  Then( """^the train doesn't open its doors$""") { () =>
  }

  Given( """^the doors are closed$""") { () =>
  }

  Given( """^the doors are open$""") { () =>
  }


}
