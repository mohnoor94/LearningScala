package _04_collections_with_functions

object ForEachFunction extends App {
  val a = 1 to 10
  // to perform a side effect
  a.foreach(x => println(x))
  println
  a.foreach(println(_))
  println
  a.foreach(println _)
  println
  a.foreach(println)
}
