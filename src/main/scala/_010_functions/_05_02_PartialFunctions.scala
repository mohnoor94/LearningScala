package _010_functions

object _05_02_PartialFunctions extends App {

  val addOne = (x: Int) => x + 1 // a (full) function Function[Int, Int] === Int => Int
  println(s"addOne(5): ${addOne(5)}")

  println("*" * 50)

  println("but... we need a function that applies only to certain cases::")
  val aFussyFunction = (x: Int) =>
    if (x == 1) 10
    else if (x == 2) 50
    else if (x < 10) 100
    else throw new FunctionNotApplicableException

  class FunctionNotApplicableException extends RuntimeException

  println(s"aFussyFunction(1): ${aFussyFunction(1)}")
  println(s"aFussyFunction(2): ${aFussyFunction(2)}")
  println(s"aFussyFunction(5): ${aFussyFunction(5)}")
  //  println(s"aFussyFunction(10): ${aFussyFunction(10)}")

  println("*" * 50)

  println("A better implementation (with pattern matching) would be:")
  val aNicerFussyFunction = (x: Int) => x match {
    case 1 => 10
    case 2 => 50
    case n if n < 10 => 100
  } // a total function

  println(s"aNicerFussyFunction(1): ${aNicerFussyFunction(1)}")
  println(s"aNicerFussyFunction(2): ${aNicerFussyFunction(2)}")
  println(s"aNicerFussyFunction(5): ${aNicerFussyFunction(5)}")
  //  println(s"aNicerFussyFunction(50): ${aNicerFussyFunction(50)}")

  println("*" * 50)

  println("or... as a partial function")

  val aPartialFunction: PartialFunction[Int, Int] = {
    case 1 => 10
    case 2 => 50
    case n if n < 10 => 100
  } // partial function value

  println(s"aPartialFunction(1): ${aPartialFunction(1)}")
  println(s"aPartialFunction(2): ${aPartialFunction(2)}")
  println(s"aPartialFunction(5): ${aPartialFunction(5)}")
  //  println(s"aPartialFunction(50): ${aPartialFunction(50)}")

  // NOTE: Partial functions can only have ONE parameter type
}