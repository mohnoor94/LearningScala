package _050_implicit

/**
  * implicit is done per scope so in the following example, we will begin with
  * an implicit value and call it from inside a method which uses a
  * multiple parameter list.
  */
object _03_ImplicitScopes {
  implicit val currency: String = "$"

  def calculatePayment(hours: Int)(implicit currentRate: Int, currency: String): String =
    currency + (hours * currentRate)

  def main(args: Array[String]): Unit = {
    implicit val rate: Int = 20
    println(s"calculatePayment(40): ${calculatePayment(40)}")
    print("calculatePayment(40)(50, \"JOD\"): ")
    println(calculatePayment(40)(50, "JOD"))
  }
}
