package _11_exceptions

import scala.util.Try

object _05_TryWithForComprehensions {
  /**
    * Once any Try failed, the execution of the for will be aborted.
    */
  def adder(a: String, b: String): Try[Int] = {
    for {
      n <- Try(a.toInt)
      m <- Try(b.toInt)
    } yield n + m
  }

  def main(args: Array[String]): Unit = {
    println(adder("123", "112"))
    println(adder("123", "ab"))
    println(adder("12gf3", "562"))
  }
}