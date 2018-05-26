package _990_random

object Destructuring extends App {
  def returnMultiValues(): (String, Int, Double) = ("Hello", 5, 10.5)

  val tuple = returnMultiValues()
  val (str, int, double) = returnMultiValues()

  println(s"tuple= $tuple")
  println(s"tuple._1= $tuple._1")
  println(s"tuple._2= $tuple._2")
  println(s"tuple._3= $tuple._3")
  println
  // or...
  println(s"str= $str")
  println(s"int= $int")
  println(s"double= $double")
  println

  // Entirety @ => we may use this with pattern matching if we care only about the type

  val a@(b, c, d) = (5, 10, "Foo")
  println(s"a= $a")
  println(s"b= $b")
  println(s"c= $c")
  println(s"d= $d")
  println(s"a._1= ${a._1}")
}
