package _021_collections_with_functions

import scala.language.postfixOps

object _02_Filter_FilterNot_Exsits_Functions extends App {
  val a = 1 to 10
  println(s"a.filter(x => x % 2 == 0) ==> ${a.filter(x => x % 2 == 0)}")
  println(s"a.filter(_ % 2 == 0) ==> ${a.filter(_ % 2 == 0)}")
  println()

  println(s"a.filterNot(x => x % 2 == 0) ==> ${a.filterNot(x => x % 2 == 0)}")
  println(s"a.filterNot(_ % 2 == 0) ==> ${a.filterNot(_ % 2 == 0)}")
  println()

  println(s"a.exists(x => x % 2 == 0) ==> ${a.exists(x => x % 2 == 0)}")
  println(s"a.exists(_ % 2 == 0) ==> ${a.exists(_ % 2 == 0)}")
  println()

  println(s"a.forall(x => x % 2 == 0) ==> ${a.forall(x => x % 2 == 0)}")
  println(s"a.forall(_ % 2 == 0) ==> ${a.forall(_ % 2 == 0)}")
  println()

  // you may use Regex for this!
  def filterVowels(s: String): String = s.toLowerCase.filter(c => Set('a', 'e', 'i', 'o', 'u').contains(c))

  print("filterVowels(\"Orange\") ==> ")
  println(filterVowels("Orange"))
  println()

  val b = Set("Brown", "Red", "Green", "purple", "Gray", "Yellow")
  println(s"b.filter(s => filterVowels(s).length > 1) ==> ${b.filter(s => filterVowels(s).length > 1)}")
  println()

  val m = Map(1 -> "One", 2 -> "Two", 3 -> "Three", 4 -> "Four")
  println(s"m.filterKeys(_ % 2 == 0) ==> ${m.filterKeys(_ % 2 == 0)}")
  println()

  println(s"Some(5).filter(_ % 2 == 0) ==> ${Some(5).filter(_ % 2 == 0)}") // THIS IS WOW!
  println(s"Some(4).filter(_ % 2 == 0) ==> ${Some(4).filter(_ % 2 == 0)}")
  println()

  // convert to list only to show contents
  println(s"(Array(1, 2, 3, 44) map (2 *)).toList ==> ${(Array(1, 2, 3, 44) map (2 *)).toList}")
  println()

  print("\"Hello World\" filter (_.isUpper) ==> ")
  println("Hello World" filter (_.isUpper))
}