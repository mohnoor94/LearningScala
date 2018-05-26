package _050_implicit

import scala.language.implicitConversions

abstract class Currency
case class Dollar(value: Int) extends Currency
case class Yuan(value: Int) extends Currency
case class Euro(value: Int) extends Currency

/**
  * 'implicit' can also convert things to make it fit into a particular API,
  * this is called implicit conversion.
  */
object _10_ImplicitConversion {
  implicit val int2Dollar: Int => Dollar = (x: Int) => Dollar(x)
//  implicit def int2Dollar(x: Int): Dollar = Dollar(x)

  def addDollars(x: Dollar, y: Dollar) = Dollar(x.value + y.value)

  def main(args: Array[String]): Unit = {
    // normal use
    println(s"addDollars(Dollar(10), Dollar(20)): ${addDollars(Dollar(10), Dollar(20))}")

    // using conversion we can type:
    println(s"addDollars(10, 20): ${addDollars(10, 20)}")

    println

    // using an implicit defined in the package object:
    def numItems(list:List[String]): String = list.mkString(",")
    print("numItems(5 -> \"Wow\") ==> ")
    println(numItems(5 -> "Wow"))
  }
}