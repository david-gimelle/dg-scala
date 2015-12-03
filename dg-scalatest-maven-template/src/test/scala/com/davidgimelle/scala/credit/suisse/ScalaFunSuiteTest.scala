package com.davidgimelle.scala.credit.suisse

import com.davidgimelle.scalatest.maven.template.domain.example.Pet
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite


/**
 * @author  david-gimelle on 03/12/2015.
 */
@RunWith(classOf[JUnitRunner])
class ScalaFunSuiteTest extends FunSuite {

    test("An pet should have a name") {
      assert(Pet("Milou").name == "Milou")
    }

    test("An empty Set should have size 0") {
      assert(Set.empty.size == 0)
    }

    test("Invoking head on an empty Set should produce NoSuchElementException") {
      intercept[NoSuchElementException] {
        Set.empty.head
      }
    }

}
