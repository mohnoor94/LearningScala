package _030_oop_introductory_example

import scala.language.postfixOps

object RationalTest extends App {
  println(s"Rational(1, 2): ${Rational(1, 2)}")
  println(s"Rational(10, 20): ${Rational(10, 20)}")
  println()

  val r1 = Rational(1, 2)
  val r2 = Rational(3, 4)
  val r3 = Rational(6, 16)

  println(s"r1: $r1")
  println(s"r2: $r2")
  println(s"r3: $r3")
  println()

  println(s"r1 + r2 ==> ${r1 + r2}")
  println(s"r1 - r2 ==> ${r1 - r2}")
  println(s"r1 * r2 ==> ${r1 * r2}")
  println(s"r1 / r2 ==> ${r1 / r2}")
  println()
  println(s"r1 + 5 ==> ${r1 + 5}")
  println(s"r1 - 5 ==> ${r1 - 5}")
  println(s"r1 * 5 ==> ${r1 * 5}")
  println(s"r1 / 5 ==> ${r1 / 5}")
  println()

  println(s"r1 + r2 * r3 ==> ${r1 + r2 * r3}")
  println(s"r1 * r2 + r3 ==> ${r1 * r2 + r3}")
  println()

  println(s"r1 > r2 : ${r1 > r2}")
  println(s"r1 < r2 : ${r1 < r2}")
  println(s"r1 >= r2 : ${r1 >= r2}")
  println(s"r1 <= r2 : ${r1 <= r2}")
  println(s"r1 == r2 : ${r1 == r2}")
  println(s"r1 != r2 : ${r1 != r2}")
  println()

  // using implicit conversion implemented by the companion object
  println(s"5 + r1 ==> ${5 + r1}")
  println(s"5 - r1 ==> ${5 - r1}")
  println(s"5 * r1 ==> ${5 * r1}")
  println(s"5 / r1 ==> ${5 / r1}")
  println()

  println(s"r1 max r2 ==> ${r1 max r2}")
  println(s"r1 min r2 ==> ${r1 min r2}")
  println()

  println(s"r1 abs ==> ${r1 abs}")
  println(s"Rational(-5, 3) abs ==> ${Rational(-5, 3) abs}")
}