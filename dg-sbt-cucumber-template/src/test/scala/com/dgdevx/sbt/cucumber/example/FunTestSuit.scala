package com.dgdevx.sbt.cucumber.example

/**
 * @author  davidgimelle on 07/01/2016.
 */

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

  test("Just for testing the constant is 42") {
    new Calculator
    assert((new Calculator()).constant==42)
  }


}