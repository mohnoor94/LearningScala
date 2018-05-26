package _04_collections_with_functions.examples

import scala.language.postfixOps

object _03_Combinations extends App {
  /*
   * List all combinations of numbers x and y
   * where x is drawn from 1..M
   * and y is drawn from 1..N
   */

  import io.StdIn._

  println("Enter two numbers: ")
  val N = readInt()
  val M = readInt()

  println("Possible combinations are: ")
  println((1 to M) flatMap (x => (1 to N) map (y => (x, y))))
}