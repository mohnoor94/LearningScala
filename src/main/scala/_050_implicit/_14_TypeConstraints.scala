package _050_implicit

/**
  * Type Constraints are used to ensure that a particular method can run
  * if a particular generic is of a certain type, this is typically
  * used for one method
  *
  * uses one operator, =:= which is actually the full type =:=[A,B] that
  * will to see if something is of the same type
  *
  * an instance of `A =:= B` witnesses that the types `A` and `B` are equal
  * An instance of `A <:< B` witnesses that `A` is a subtype of `B`.
  */
object _14_TypeConstraints {

  class MyPair[A, B](a: A, b: B) {
    def first: A = a
    def second: B = b
    // ev: evidence
    def toList(implicit ev: A =:= B): List[A] = List(a, b).asInstanceOf[List[A]]
    def toList2(implicit ev1: A <:< AnyVal, ev2: B <:< AnyVal): List[A] = List(a, b).asInstanceOf[List[A]]
  }

  def main(args: Array[String]): Unit = {
    println(new MyPair(3, 10).toList)
    //    println(new MyPair(3, 10.5).toList) // will throw an error
    //    println(new MyPair(3.5, 10).toList) // will throw an error

    println(new MyPair(3, 10).toList2)
    println(new MyPair(3, 10.5).toList2)
    println(new MyPair(3.5, 10).toList2)

    // toMap uses <:<
    println(List(1 -> "One", 2 -> "Two").toMap)
    //    println(List(1, 2, 3).toMap) // will throw an error
  }
}