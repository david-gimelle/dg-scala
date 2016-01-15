package com.dgdevx.sbt.cucumber.tube.train

import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers

/**
 * @author  davidgimelle on 15/01/2016.
 */
class StopSteps  extends ScalaDsl with EN with Matchers{

  Then("""^the train stops gently$"""){ () =>
  }

  Then("""^the train stops immediately$"""){ () =>
  }

  When("""^I push the break$"""){ () =>
  }

  When("""^I stop to push the dead man's handle$"""){ () =>
  }



}
