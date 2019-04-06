package _991_syntax_sugar

object InfixGenericType extends App {

  // example 1
  class Composite[A, B]

  //val composite1: Composite[Int, String] = ???
  //val composite2: Int Composite String = ??? // same as above

  // example 2
  class -->[A, B]

  // val towards: Int --> String = ???

  // will back to this later
}
