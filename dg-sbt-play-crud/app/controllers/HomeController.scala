package controllers

import javax.inject._
import models.{PersonTable, Person}
import play.api._
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
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
class HomeController @Inject() extends Controller with DBtrait {

  /**
    * Create an Action to render an HTML page with a welcome message.
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  val personForm: Form[Person] = Form {
    mapping(
      "firstName" -> text,
      "lastName" -> text
    )(Person.apply)(Person.unapply)
  }

  val people: TableQuery[PersonTable] = TableQuery[PersonTable]

  def getPersons = Action {

    val db = openDbCon()

    try {

      val setupAction: DBIO[Unit] = DBIO.seq()

      val setupFuture: Future[Unit] = db.run(setupAction)
      val f = setupFuture.flatMap { _ =>

        val plainQuery = sql"select PERSON_FIRSTNAME, PERSON_LASTNAME from PERSON".as[(String, String)]

        db.run(plainQuery).map(ve => ve.map(te => Person(te._1, te._2)))

      }
      Await.result(f, Duration.Inf)

      Ok(Json.toJson(f.value.get.get))
    }
    finally closeDbCon()

  }

  def addPerson = Action { implicit request =>
    val person = personForm.bindFromRequest.get

    val db = openDbCon()

    try {
      val setupAction: DBIO[Unit] = DBIO.seq(
        // Insert a person
        people +=(System.nanoTime(), person.firstName, person.lastName)
      )
      val setupFuture: Future[Unit] = db.run(setupAction)
      Await.result(setupFuture, Duration.Inf)
    }
    finally closeDbCon()

    Redirect(routes.HomeController.index())
  }

}
