package _04_collections_with_functions

import scala.language.postfixOps

object GeneralExample05_isPrime extends App {

  def isPrime1(n: Int): Boolean = !((2 until n) exists (n % _ == 0))

  def isPrime2(n: Int): Boolean = (2 until n) forall (n % _ != 0)

  println(s"05: ${isPrime1(5)} - ${isPrime2(5)}")
  println(s"10: ${isPrime1(10)} - ${isPrime2(10)}")
  println(s"15: ${isPrime1(15)} - ${isPrime2(15)}")
  println(s"01: ${isPrime1(1)} - ${isPrime2(1)}")
  println(s"02: ${isPrime1(2)} - ${isPrime2(2)}")
  println(s"00: ${isPrime1(0)} - ${isPrime2(0)}")
}