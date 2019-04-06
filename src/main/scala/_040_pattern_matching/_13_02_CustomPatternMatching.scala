package _040_pattern_matching

object _13_02_CustomPatternMatching extends App {

  class Person(val name: String, val age: Int)

  object Person {
    // unapply in singleton/companion object used for pattern matching
    def unapply(person: Person): Option[(String, Int)] = Some((person.name, person.age))

    def unapply(age: Int): Option[String] =
      Some(if (age < 21) "minor" else "major")
  }

  val bob = new Person("Bob", 25)

  val greeting = bob match {
    case Person(n, a) => s"Hi, my name is $n and I'm $a"
  }

  val legalState = bob.age match {
    case Person(status) => s"My legal status is $status"
  }

  println(greeting)
  println(legalState)
}
