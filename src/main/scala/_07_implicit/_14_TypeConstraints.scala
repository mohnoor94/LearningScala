package _07_implicit

/**
  * Type Constraints are used to ensure that a particular method can run
  * if a particular generic is of a certain type, this is typically
  * used for one method
  *
  * uses one operator, =:= which is actually the full type =:=[A,B] that
  * will to see if something is of the same type
  */
object _14_TypeConstraints {

  class MyPair[A, B](a: A, b: B) {
    def first: A = a
    def second: B = b
    def toList(implicit ev: A =:= B): List[A] = List(a, b).asInstanceOf[List[A]]
  }

  def main(args: Array[String]): Unit = {
    println(new MyPair(3, 10).toList)
//    println(new MyPair(3, 10.5).toList)
//    println(new MyPair(3.5, 10).toList) // will throw an error
  }
}