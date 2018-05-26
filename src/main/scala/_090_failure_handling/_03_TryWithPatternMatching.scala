package _090_failure_handling

import scala.util.{Failure, Success, Try}

object _03_TryWithPatternMatching {
  def convertToInt(s: String): Try[Int] = Try(s.toInt)

  val printMyInteger: Try[_] => Unit = {
    case Success(n) => println(n)
    case Failure(ex) => println(ex)
  }

  def main(args: Array[String]): Unit = {
    val a = convertToInt("123")
    val b = convertToInt("1a2b3")
    val list = List("12", "x", "23", "14", "y", "18")

    printMyInteger(a)
    printMyInteger(b)

    println(list.map(convertToInt))
  }
}