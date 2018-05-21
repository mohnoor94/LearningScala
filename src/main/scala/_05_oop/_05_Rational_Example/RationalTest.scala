package _05_oop._05_Rational_Example

object RationalTest extends App {
  println(s"new Rational(1, 2): ${new Rational(1, 2)}")
  println(s"new Rational(10, 20): ${new Rational(10, 20)}")
  println()

  val r1 = new Rational(1, 2)
  val r2 = new Rational(3, 4)
  val r3 = new Rational(6, 16)

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
  println(s"r1 > r2 : ${r1 < r2}")
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
}