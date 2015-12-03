package com.davidgimelle.scalatest.maven.template.domain.example

object XMLHelloWorld {
  def main(args: Array[String]): Unit = {
    val myPet = Pet("World Pet")
    println(myPet.name)
  }
}
