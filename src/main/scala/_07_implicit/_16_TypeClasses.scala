package _07_implicit

/**
  * Typeclasses are a way of generating or extending behavior using Java-like interfaces,
  * but operate as outside.  There is another term for this,
  * and it's called ad-hoc polymorphism.
  *
  *
  * can be used to determine equality, so whether than make equals inside of an class,
  * it is now an outside concern
  */
object _16_TypeClasses {

  trait Eq[T] {
    def myEquals(a: T, b: T): Boolean
  }

  implicit val eqTypeClass: Eq[Team] = (a: Team, b: Team) => {
    a.city == b.city &&
      a.manager == b.manager &&
      a.mascot == b.mascot
  }

  def isEquals[A](a: A, b: A)(implicit eq: Eq[A]): Boolean = eq.myEquals(a, b)

  class Team(val mascot: String, val city: String, val manager: String)

  def main(args: Array[String]): Unit = {
    val a1 = new Team("Blue Jays", "Toronto", "Bobby Filet")
    val a2 = new Team("Blue Jays", "Toronto", "Bobby Filet")
    val a3 = new Team("Nationals", "Washington", "Carla Annapolis")

    println(isEquals(a1, a2))
    println(isEquals(a1, a3))
  }
}
