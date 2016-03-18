package controllers

import javax.inject._
import models.{PersonTable, Person}
import play.api._
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._
import slick.backend.DatabasePublisher
import slick.driver.H2Driver.api._

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() extends Controller {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  val  personForm: Form[Person] = Form {
    mapping(
      "firstName" -> text,
      "lastName" -> text
    )(Person.apply)(Person.unapply)
  }

  def getPersons = Action {
    println("Get Persons (get People! )")

    // ??? HOW TO SHARE THIS DATABASE between 2 requests

    val db = Database.forConfig("h2mem1")

    val res = "Some People!"
    try {

      // The query interface for the PERSON table
      val people: TableQuery[PersonTable] = TableQuery[PersonTable]

      val setupAction: DBIO[Unit] = DBIO.seq(
        // Create the schema
        (people.schema).create
      )

      val setupFuture: Future[Unit] = db.run( setupAction)
      //TODO do this with some map function instead of plain query ...
      val f = setupFuture.flatMap { _ =>

        /* Manual SQL / String Interpolation */

        // A value to insert into the statement
        val state = "CA"

        // Construct a SQL statement manually with an interpolated value
        val plainQuery = sql"select PERSON_FIRSTNAME, PERSON_LASTNAME from PERSON".as[(String,String)]

        println("Generated SQL for plain query:\n" + plainQuery.statements)

        // Execute the query
        db.run(plainQuery).map(println)

      }
      Await.result(f, Duration.Inf)


    }
    finally db.close()

    Ok(res)
  }

  def addPerson = Action { implicit request =>
    val person = personForm.bindFromRequest.get
    println("A PERSON.firstName>"+person.firstName +" lastName>"+person.lastName)

    val db = Database.forConfig("h2mem1")
    try {

      // The query interface for the PERSON table
      val people: TableQuery[PersonTable] = TableQuery[PersonTable]

      val setupAction: DBIO[Unit] = DBIO.seq(
        // Create the schema
        (people.schema).create ,

        // Insert a person
        people += (150, person.firstName, person.lastName)
      )

      val setupFuture: Future[Unit] = db.run( setupAction)
      val f = setupFuture.flatMap { _ =>

        // Insert some random person (using JDBC's batch insert feature)
        val insertAction: DBIO[Option[Int]] = people ++= Seq (
          (System.nanoTime(),"Bob","Dvorak"),
          (System.nanoTime()+1,"Bob2","Zorglub"),
          (System.nanoTime()+2,"Bob3","notlucky")
        )

        val insertAndPrintAction: DBIO[Unit] = insertAction.map { coffeesInsertResult =>
          // Print the number of rows inserted
          coffeesInsertResult foreach { numRows =>
            println(s"Inserted $numRows rows into the Coffees table")
          }
        }

        val allPeopleAction: DBIO[Seq[(Long, String, String)]] =
          people.result

        val combinedAction: DBIO[Seq[(Long, String, String)]] =
          insertAndPrintAction >> allPeopleAction

        val combinedFuture: Future[Seq[(Long, String, String)]] =
          db.run(combinedAction)

        combinedFuture.map { allPeople =>
          allPeople.foreach(println)
        }

      }.flatMap { _ =>

        /* Update */

        // Construct an update query with the firstName column being the one to update
        val updateQuery: Query[Rep[String], String, Seq] = people.filter(_.lastName === person.lastName).map(_.firstName)

        val updateAction: DBIO[Int] = updateQuery.update("JOE")

        // Print the SQL for the Person update query
        println("Generated SQL for Person update:\n" + updateQuery.updateStatement)

        // Perform the update
        db.run(updateAction.map { numUpdatedRows =>
          println(s"Updated $numUpdatedRows rows")
        })

      }

        .flatMap { _ =>

          /* Delete */

          // Construct a delete query
          val deleteQuery: Query[PersonTable,(Long, String, String), Seq] =
            people.filter(_.lastName === "notlucky")

          val deleteAction = deleteQuery.delete

          // Print the SQL for the Coffees delete query
          println("Generated SQL for Coffees delete:\n" + deleteAction.statements)

          // Perform the delete
          db.run(deleteAction).map { numDeletedRows =>
            println(s"Deleted $numDeletedRows rows")
          }

        }


        .flatMap { _ =>

        /* Manual SQL / String Interpolation */

        // A value to insert into the statement
        val state = "CA"

        // Construct a SQL statement manually with an interpolated value
        val plainQuery = sql"select PERSON_FIRSTNAME, PERSON_LASTNAME from PERSON".as[(String,String)]

        println("Generated SQL for plain query:\n" + plainQuery.statements)

        // Execute the query
        db.run(plainQuery).map(println)

      }
      Await.result(f, Duration.Inf)

    }
    finally db.close()



    Redirect(routes.HomeController.index())
  }

}
