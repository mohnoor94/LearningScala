package _010_functions

// But REMEMBER: Partial functions can only have ONE parameter type
object _05_04_PartialFunctionIsAFullFunction extends App {

  // since a partial function is a subclass of a function, we can write:
  val aTotalFunction: Int => Int = {
    case 1 => 100
  } // !!

  // HOF accepts partial functions as well
  val mapMe = (x: List[Int]) => x.map {
    case 1 => 10
    case 2 => 200
    case 3 => 500
  }

  println(s"mapMe(List(1, 2, 3)) ==> ${mapMe(List(1, 2, 3))}")
  // println(s"mapMe(List(1, 2, 5)) ==> ${mapMe(List(1, 2, 5))}") // will throw an exception
}
