package _99_random

object Destructuring extends App {
  def returnMultiValues(): (String, Int, Double) = ("Hello", 5, 10.5)

  val tuple = returnMultiValues()
  val (str, int, double) = returnMultiValues()

  println(tuple)
  println(tuple._1)
  println(tuple._2)
  println(tuple._3)

  // or...
  println(str)
  println(int)
  println(double)
}
