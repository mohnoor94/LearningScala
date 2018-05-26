package _021_collections_with_functions.examples

import scala.language.postfixOps

/**
  * Given a positive integer n, find all pairs of positive integers
  * i and j, with 1 <= j < i < n such that i + j is prime.
  *
  * For example if n = 7, the sought pairs are:
  * i   | 2 3 4 4 5 6 6
  * j   | 1 2 1 3 2 1 5
  * ----+---------------
  * i+j | 3 5 5 7 7 7 11
  */
object _06_PrimePairs extends App {

  def isPrime(n: Int): Boolean = !((2 until n) exists (n % _ == 0))


  import io.StdIn._

  print("Enter a value: ")
  val n = readInt()

  val values1 = (1 until n) flatMap (i => (1 until i) map (j => (i, j))) filter (pair => isPrime(pair._1 + pair._2))

  // or... use loops! (for comprehensions / for expressions)

  val values2 = for {i <- 1 until n
                     j <- 1 until i
                     if isPrime(i + j)
  } yield (i, j, i + j)

//  // or with () and ;
  //  val values3 = for (i <- 1 until n;
  //                     j <- 1 until i if isPrime(i + j)) yield (i, j, i + j)

  println(values1)
  println(values2)


}