package _040_pattern_matching

// really rare!
// Option (or Option of tuple) should be enough
object _22_CustomReturnType extends App {

  case class Person(name: String, age: Int)

  abstract class Wrapper[T] {
    def isEmpty: Boolean

    def get: T // special method, has all what you want to return, if you want to return multiple values, return a tuple
  }

  object PersonWrapper {
    def unapply(person: Person): Wrapper[String] = new Wrapper[String] {
      override def isEmpty: Boolean = false

      override def get: String = person.name
    }
  }

  val bob = Person("Bob", 25)

  println(bob match {
    case PersonWrapper(n) => s"This person's name is $n"
    case _ => "An alien"
  })

}
