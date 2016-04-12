package controllers

import models.PersonTable
import slick.driver.H2Driver.api._
import slick.jdbc.meta.MTable
import scala.concurrent.duration._

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

object MyDBConnection {

  private var initiated=false
  private val db: Database = initDB()

  def initDB() = {
    if(!initiated){
      initiated=false
      println("Init Db")
      val newDb: Database = Database.forConfig("h2mem1")
      println("newDB ok>>>"+newDb)

        // The query interface for the PERSON table
        val people: TableQuery[PersonTable] = TableQuery[PersonTable]

      // http://stackoverflow.com/questions/30036964/check-table-existance-in-slick-3-0
      val tables = Await.result(newDb.run(MTable.getTables), 5.seconds).toList
      println("in the table>>>")
      tables.foreach(println)
      tables.map(e => e.name.name).foreach(println)

      if (tables.map(e=>e.name.name).contains("PERSON")){
        println("PERSON ALREADY EXISTING!")
      }
      else {
        println("Will really instanciate the schema")
        // check if the tables exist and create a new one only if it is not existing already
        val setupAction: DBIO[Unit] = DBIO.seq(
          // Create the schema
          (people.schema).create // move this up to no create the schema 2 times ... ?

        )

        val f: Future[Unit] = newDb.run(setupAction)


        Await.result(f, Duration.Inf)
      }
      newDb

    }
    else {
      println("Db already up")
      db
    }
  }

  def releaseDB() = {
    if (initiated) {
      println("close and Release db")
      db.close()
      initiated=false
    }
    else {
      println("Nothing to release")
    }
  }

  def openConnection():Database ={
    println("Open connection")
    initDB()
  }

  def closeConnection() = {
    if (!initiated){
      println("nothing to close")
    }
    else {
      println("close connection")
      db.close()
    }
  }

}

trait DBtrait {

  def openDbCon(): Database ={
    MyDBConnection.openConnection()
  }

  def closeDbCon()={
    MyDBConnection.closeConnection()
  }

  def downDbCon()={
    MyDBConnection.releaseDB()
  }


}
