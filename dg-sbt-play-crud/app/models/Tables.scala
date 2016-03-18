package models

import slick.driver.H2Driver.api._
import slick.lifted.{ProvenShape, ForeignKeyQuery}

/**
  * Created by gimelled on 16/03/2016.
  */
class PersonTable(tag: Tag) extends Table[(Long, String, String)](tag, "PERSON") {

  def id: Rep[Long] = column[Long]("PERSON_ID")
  def firstName: Rep[String] = column[String]("PERSON_FIRSTNAME")
  def lastName: Rep[String] = column[String]("PERSON_LASTNAME",O.PrimaryKey)

  def * : ProvenShape[(Long, String, String)] = (id, firstName, lastName)

}
