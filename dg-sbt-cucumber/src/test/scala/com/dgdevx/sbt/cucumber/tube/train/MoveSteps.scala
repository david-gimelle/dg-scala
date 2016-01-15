package com.dgdevx.sbt.cucumber.tube.train

import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers

/**
 * @author  davidgimelle on 15/01/2016.
 */
class MoveSteps  extends ScalaDsl with EN with Matchers{


  When("""^I push the dead man's handle at level (\d+)$"""){ (arg0:Int) =>
  }

  When("""^I start the train$"""){ () =>
  }

  Then("""^the train starts$"""){ () =>
  }

  Given("""^the train moves at speed (\d+)$"""){ (arg0:Int) =>
  }

  Then("""^the train speed changes to speed (\d+)$"""){ (arg0:Int) =>
  }

  Given("""^the train is not moving$"""){ () =>
  }

  Then("""^the train doesn't move$"""){ () =>
  }

  Given("""^the train is moving$"""){ () =>
  }


}
