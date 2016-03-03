package com.dgdevx.sbt.cucumber.tube.train



object Train {

  //TODO create a context and put some Trains in it, instead have only one unic train
  //TODO what about case class
  //TODO what about cake pattern with traits
  var stopImmediately = false
  var stopGently = false
  var doorClosed = true
  var currentDriverName = "noDriver"
  var currentSpeed = 0
  var messageToPassenger = ""

  def pushTheBrake() = {
    logMessage("!!> Push the break!")
    stopImmediatly()
  }

  def releasedDeadManHandles() = {
    logMessage("!!> Release the dead man! OMG!!!")
    stopImmediatly()
  }

  def stopImmediatly() = {
    stopGently = false
    stopImmediately = true
    currentSpeed = 0
    logMessage("!!> Emergency stop!!!")
  }

  def informPassengers(message: String): Unit = {
    messageToPassenger = message
    logMessage("((( " + message + " )))")
  }

  def pushDeadManTo(driverName: String, deadLevel: Int) = {
    //TODO refactor this with a function in arg at least
    if (currentDriverName.equals(driverName)) {
      moveAt(deadLevel)
    }
    else {
      logMessage("!!> You are not the driver, you cannot use the dead man hand!")
    }
  }

  def closeDoors() = {
    doorClosed = true
    logMessage("--> Doors closed")
  }

  def openDoors() = {
    if (currentSpeed == 0) {
      doorClosed = false
      logMessage("--> Doors opened")
    }
    else {
      logMessage("!!> Impossible to open the doors of a moving train!")
    }
  }

  def driveBy(driverName: String) = {
    Train.currentDriverName = driverName
    logMessage("--> new driver: " + driverName)
  }

  def orderToCloseDoors(driverName: String) = {
    //TODO refactor this with a function in arg at least
    if (currentDriverName.equals(driverName)) {
      closeDoors()
    }
    else {
      logMessage("!!> You are not the driver, you cannot close the doors!")
    }
  }

  def orderToOpenDoors(driverName: String) = {
    //TODO refactor this with a function in arg at least
    if (currentDriverName.equals(driverName)) {
      openDoors()
    }
    else {
      logMessage("!!> You are not the driver, you cannot open the doors!")
    }
  }

  def hasStopGently(): Boolean = {
    stopGently
  }

  def hasStopImmediately(): Boolean = {
    stopImmediately
  }

  def moveAt(newSpeed: Int): Any = {
    stopImmediately = false
    if (doorClosed) {
      if (newSpeed < currentSpeed && (newSpeed == 0)) {
        stopGently = true
        logMessage("-|> train stop gently")
      }
      else {
        stopGently = false
        logMessage("->> train at speed " + currentSpeed)
      }
      currentSpeed = newSpeed
    }
    else {
      logMessage("!!> R u mad? Not possible to move a train with doors opened!")
    }
  }

  def logMessage(message: String) = {
    println("\n" + message)
  }

  def beep(): Unit = {
    logMessage("((( Beep Beep Beep )))")
  }

}
