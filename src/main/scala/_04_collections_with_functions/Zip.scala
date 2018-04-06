package _04_collections_with_functions

object Zip extends App {
  val a = List(1, 2, 3, 4)
  val b = List(5, 6, 7, 8)
  println(a zip b)

  println((1 to 5) zip (6 to 9))
  println((1 to 2) zip (6 to 9))
}
