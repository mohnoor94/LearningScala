package _050_implicit

/**
  * we can bring up any implicit directly by merely
  * calling up implicitly
  */
object _06_GetImplicitValue extends App {
  implicit val implicitRate: Rate = Rate(20)
  implicit val implicitCurrency: String = "$"
  implicit val listOfString: List[String] = List("Foo", "Bar", "Baz")
  implicit val listOfDouble: List[Double] = List(30.00, 12.00, 9.0)


  println(s"implicitly[String]: ${implicitly[String]}")
  println(s"implicitly[Rate]: ${implicitly[Rate]}")
  println
  println(s"implicitly[List[String]] ==> ${implicitly[List[String]]}")
  println(s"implicitly[List[Double]] ==> ${implicitly[List[Double]]}")
  println

  /**
    * we can use 'implicitly' if we do not want to allow the user to override
    * the implicit value!
    */
  def calculatePayment(hours: Int): String = {
    val currency = implicitly[String]
    val rate = implicitly[Rate]
    currency + (hours * rate.value)
  }

  println(s"calculatePayment(20): ${calculatePayment(20)}")
}