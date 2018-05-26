package _990_random

object CopyMethod {

  case class SimpleTime(hours: Int, minutes: Int)

  def main(args: Array[String]): Unit = {
    val time1 = SimpleTime(9, 45)
    val time2 = time1.copy(minutes = 30)
    val time3 = time1.copy(hours = 3)

    println(s"time1: $time1")
    println(s"time2: $time2")
    println(s"time3: $time3")
  }
}