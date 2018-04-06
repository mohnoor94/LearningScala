package _01_intro

import java.time.LocalDate

class EmployeeWithCompanionObject private(val firstName: String, val lastName: String, val title: String, val hireDate: LocalDate) {
  override def toString = s"EmployeeWithCompanionObject($firstName, $lastName, $title, $hireDate)"

  def +(e: EmployeeWithCompanionObject) = true
}

object EmployeeWithCompanionObject {
  def create(firstName: String, lastName: String, title: String) =
    new EmployeeWithCompanionObject(firstName, lastName, title, LocalDate.now)

  def create(firstName: String, lastName: String, title: String, localDate: LocalDate) =
    new EmployeeWithCompanionObject(firstName, lastName, title, localDate)
}

object Runner extends App {
  val e1 = EmployeeWithCompanionObject.create("Moh", "Noor", "Dev")
  val e2 = EmployeeWithCompanionObject.create("Jack", "Well", "Dev", LocalDate.of(2005, 5, 22))

  println(e1)
  println(e2)

  println(e1 + e2)
}