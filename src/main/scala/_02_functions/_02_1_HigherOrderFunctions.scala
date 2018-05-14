package _02_functions

import scala.language.postfixOps

object _02_1_HigherOrderFunctions extends App {
  // Functions with functions (Higher order functions)
  // function2...
  //  val f: (Int, Int => Int) => Int = (x: Int, y: Int => Int) => y(x)
  val f = (x: Int, y: Int => Int) => y(x)

  // all following are the same!
  println(f(3, (m: Int) => m + 1))
  println(f(3, m => m + 1))
  println(f(3, _ + 1))
  println(f(3, 1 + _))
  println(f(3, 1 +))


  val g = (x: Int) => (y: Int) => x + y
  println(g(4)(5))

  val gg = g(5)
  println(gg(10))
}