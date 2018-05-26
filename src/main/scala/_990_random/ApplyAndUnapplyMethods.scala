package _990_random

object ApplyAndUnapplyMethods {

  object Reverse {
    def apply(text: String): String = text.reverse
  }

  case class SimpleTime(hours: Int, minutes: Int)

  def main(args: Array[String]): Unit = {
    println(Reverse("Hello"))

    val time = SimpleTime(10, 15)
    println(time)
    println(SimpleTime.unapply(time)) // unapply used mainly with pattern matching
  }
}