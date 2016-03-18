package models

import play.api.libs.json.Json

/**
  * Created by gimelled on 11/03/2016.
  */
case class Person(firstName: String, lastName: String)

object Person {

  implicit val personFormat = Json.format[Person]

}
