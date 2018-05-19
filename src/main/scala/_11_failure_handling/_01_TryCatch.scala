package _11_failure_handling

object _01_TryCatch extends App {
  val val1 = "123"
  val val2 = "1a2b3"

  try {
    val1.toInt
    val2.toInt
  }
  catch {
    case nfe: NumberFormatException => println(nfe.getMessage)
    case problem => println(s"val1 = $val1 encounters another problem: $problem")
  }
}