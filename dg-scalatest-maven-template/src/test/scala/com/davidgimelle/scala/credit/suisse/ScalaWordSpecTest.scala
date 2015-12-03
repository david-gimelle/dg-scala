package com.davidgimelle.scala.credit.suisse

import com.davidgimelle.scalatest.maven.template.domain.example.Pet
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner


import org.scalatest.WordSpec

@RunWith(classOf[JUnitRunner])
class ScalaWordSpecTest extends WordSpec {

  "A Set" when {
    "empty" should {
      "have size 0" in {
        assert(Set.empty.size == 0)
      }

      "produce NoSuchElementException when head is invoked" in {
        intercept[NoSuchElementException] {
          Set.empty.head
        }
      }
    }
  }
}
