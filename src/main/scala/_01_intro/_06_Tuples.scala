package _01_intro

object _06_Tuples extends App {
  val t = (1, "Hello", 3.2)

  println(t._1)
  println(t._2)
  println(t._3)

  // or...
  //  val t2: (Int, String, Double) = t
  //  val t3:Tuple3[Int, String, Double] = t

  val tuple2 = (1, "Hello")
  println(tuple2)
  println(tuple2 swap)
  println(tuple2.swap)
  println(tuple2)

  val (x, y) = (1, 2)
  println(x)
  println(y)
}
