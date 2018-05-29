package _021_collections_with_functions

import scala.language.postfixOps

/**
  * > The zip and unzip methods provide one way to operate on multiple lists together.
  * > Useful special case is to zip a list with its index. This is done most efficiently with the zipWithIndex
  * method, which pairs every element of a list with the position where it appears in the list.
  * > The zipped method on tuples generalizes several common operations to work on multiple lists instead of just one.
  * >> One such operation is map. The map method for two zipped lists maps pairs of elements rather than individual
  * elements. One pair is for the first element of each list, another pair is for the second element of each list, and so on
  */
object _07_ZipAndUnzip extends App {
  val a = List(1, 2, 3, 4)
  val b = List(5, 6, 7, 8)
  val z = a zip b

  println("zip: " + z)
  println()

  println(s"(1 to 5) zip (6 to 9) ==> ${(1 to 5) zip (6 to 9)}")
  println(s"(1 to 2) zip (6 to 9) ==> ${(1 to 2) zip (6 to 9)}")
  println()

  println(s"a zipWithIndex ==> ${a zipWithIndex}")
  println()

  println("unzip: " + z.unzip)
  println()

  val intPair = (List(10, 20), List(3, 4, 5))
  val stringLengths = (List("abc", "de"), List(3, 2))
  println(s"intPair.zipped.map(_ * _) ==> ${intPair.zipped.map(_ * _)}")
  println(s"stringLengths.zipped.forall(_.length == _) ==> ${stringLengths.zipped.forall(_.length == _)}")
  println(s"stringLengths.zipped.exists(_.length != _) ==> ${stringLengths.zipped.exists(_.length != _)}")
}
