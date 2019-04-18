package _010_functions

/**
  * Process a list of numbers and return their string representations with different formats with a curried
  * format function.
  */
object _06_04_PartiallyAppliedFunctions_formatter {

  val refine: (String, Double) => String =
    (format: String, number: Double) => format.format(number)

  val fourTwo: Double => String = refine("%4.2f", _: Double)
  val eightSix: Double => String = refine("%8.6f", _: Double)
  val fourteenTwelve: Double => String = refine("%14.12f", _: Double)

  def main(args: Array[String]): Unit = {
    val values = List(Math.PI, Math.E, 5, 1.3e-12, 569.879383)

    println(values map fourTwo)
    println(values map eightSix)
    println(values map fourteenTwelve)
  }
}