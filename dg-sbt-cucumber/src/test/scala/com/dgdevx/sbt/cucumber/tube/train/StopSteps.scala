package com.dgdevx.sbt.cucumber.tube.train

import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers

/**
 * @author  davidgimelle on 15/01/2016.
 */
class StopSteps  extends ScalaDsl with EN with Matchers{

  Then("""^the train stops gently$"""){ () =>
    assert(Train.hasStopGently())
  }

  Then("""^the train stops immediately$"""){ () =>
    assert(Train.stopImmedialty)
  }

  When("""^I push the brake$"""){ () =>
    Train.pushTheBrake()
  }

  When("""^I stop to push the dead man's handle$"""){ () =>
    Train.releasedDeadManHandles();
  }

}
