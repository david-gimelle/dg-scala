/**
 * @author  davidgimelle on 07/01/2016.
 */

import com.sbtco.sandbox.JustForTesting
import org.scalatest.FunSuite

class SetSuite extends FunSuite {

  test("An empty Set should have size 0") {
    assert(Set.empty.size == 0)
  }

  test("Invoking head on an empty Set should produce NoSuchElementException") {
    intercept[NoSuchElementException] {
      Set.empty.head
    }
  }

  test("Just for testing constant is 5") {
    new JustForTesting
    assert((new JustForTesting()).constant==5)
  }

  test("Just for ttest") {
    assert(5==5)
  }

}