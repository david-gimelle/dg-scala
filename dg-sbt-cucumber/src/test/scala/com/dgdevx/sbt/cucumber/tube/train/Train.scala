package com.dgdevx.sbt.cucumber.tube.train

object Train {

  var doorClosed = true
  var driverName = "noDriver"

  def driveBy(driverName:String) = {
    Train.driverName=driverName
    System.out.println("--> new driver: "+driverName)
  }

  def checkDriver() ={

  }

  def closeDoor() = {
    doorClosed=true
    System.out.println("--> Closing doors")
  }

  def beep(): Unit ={
    System.out.println("((( Beep Beep Beep )))")
  }

}
