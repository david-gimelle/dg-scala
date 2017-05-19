package com.davidgimelle.scalatest.maven.template

import com.davidgimelle.scalatest.maven.template.domain.example.Pet
import org.scalatest.WordSpec

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
