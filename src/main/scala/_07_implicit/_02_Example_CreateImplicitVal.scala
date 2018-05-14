package _07_implicit

/**
  * Implicits is like a Map[Class[A], A] where A is any object and it is tied
  * into the scope, and it is there when you need it, hence it is implicit.
  * This provide a lot of great techniques that we can use in Scala.
  */
object _02_Example_CreateImplicitVal extends App {
  implicit val rate: Int = 20

  /**
    * It's never about the name but the type
    */
  def calculatePayment(hours: Int)(implicit currentRate: Int): Int = hours * currentRate

  println(s"calculatePayment(40) [Implicit Value]: ${calculatePayment(40)}")

  /**
    * will allow you to place something manually, if you want to
    * override the implicit value
    */
  println(s"calculatePayment(40)(10) [Manual Value]: ${calculatePayment(40)(10)}")
}