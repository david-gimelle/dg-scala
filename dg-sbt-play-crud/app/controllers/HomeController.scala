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
      "name" -> text
    )(Person.apply)(Person.unapply)
  }

  def addPerson = Action { implicit request =>
    val person = personForm.bindFromRequest.get
    println("A PERSON.name>"+person.name)

    val db = Database.forConfig("h2mem1")
    try {

      // The query interface for the Suppliers table
      val suppliers: TableQuery[PersonTable] = TableQuery[PersonTable]

      val setupAction: DBIO[Unit] = DBIO.seq(
        // Create the schema by combining the DDLs for the Suppliers and Coffees
        // tables using the query interfaces
        (suppliers.schema).create,

        // Insert some suppliers
        suppliers += (150, person.name)
      )

      val setupFuture: Future[Unit] = db.run( setupAction)
      val f = setupFuture.flatMap { _ =>

        // Insert some coffees (using JDBC's batch insert feature)
        val insertAction: DBIO[Option[Int]] = suppliers ++= Seq (
          (System.nanoTime(),"Bob")
        )

        val insertAndPrintAction: DBIO[Unit] = insertAction.map { coffeesInsertResult =>
          // Print the number of rows inserted
          coffeesInsertResult foreach { numRows =>
            println(s"Inserted $numRows rows into the Coffees table")
          }
        }

        val allSuppliersAction: DBIO[Seq[(Long, String)]] =
          suppliers.result

        val combinedAction: DBIO[Seq[(Long, String)]] =
          insertAndPrintAction >> allSuppliersAction

        val combinedFuture: Future[Seq[(Long, String)]] =
          db.run(combinedAction)

        combinedFuture.map { allSuppliers =>
          allSuppliers.foreach(println)
        }

      }.flatMap { _ =>

        /* Manual SQL / String Interpolation */

        // A value to insert into the statement
        val state = "CA"

        // Construct a SQL statement manually with an interpolated value
        val plainQuery = sql"select PERSON_NAME from PERSON".as[String]

        println("Generated SQL for plain query:\n" + plainQuery.statements)

        // Execute the query
        db.run(plainQuery).map(println)

      }
      Await.result(f, Duration.Inf)

    }
    finally db.close()



    //DB.save(person)
    Redirect(routes.HomeController.index())
  }

}
