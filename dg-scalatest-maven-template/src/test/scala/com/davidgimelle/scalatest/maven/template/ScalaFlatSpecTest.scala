package com.davidgimelle.scalatest.maven.template

import java.util
import java.util.EmptyStackException

import com.davidgimelle.scalatest.maven.template.domain.example.Pet
import org.scalatest.FlatSpec

/**
 * @author  davidgimelle on 26/11/2015.
 */
class ScalaFlatSpecTest extends FlatSpec {

    "A Stack" should "pop values in last-in-first-out order" in {
      val stack = new util.Stack[Int]
      stack.push(1)
      stack.push(2)
      assert(stack.pop() === 2)
      assert(stack.pop() === 1)
    }

    it should "throw EmptyStackException if an empty stack is popped" in {
      val emptyStack = new util.Stack[String]
      intercept[EmptyStackException] {
        emptyStack.pop()
      }
    }

}
