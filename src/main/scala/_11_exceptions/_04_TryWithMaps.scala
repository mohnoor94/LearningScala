package _11_exceptions

import scala.util.Try

object _04_TryWithMaps {
  def convertToInt(s: String): Try[Int] = Try(s.toInt)

  val mapMe: Try[Int] => Int = (a: Try[Int]) => a map (x => x) getOrElse 0

  def main(args: Array[String]): Unit = {
    val a = convertToInt("123")
    val b = convertToInt("1a2b3")

    val list = List("12", "x", "23", "14", "y", "18")

    println(mapMe(a))
    println(mapMe(b))
    println(list.map(convertToInt))
  }
}