package _04_collections_with_functions

object _02_Filter_FilterNot_Exsits_Functions extends App {
  val a = 1 to 10
  println(a.filter(x => x % 2 == 0))
  println(a.filter(_ % 2 == 0))
  println
  println
  println(a.filterNot(x => x % 2 == 0))
  println(a.filterNot(_ % 2 == 0))
  println
  println
  println(a.exists(x => x % 2 == 0))
  println(a.exists(_ % 2 == 0))
  println
  println

  // you may use Regex for this!
  def filterVowels(s: String) = s.toLowerCase.filter(c => Set('a', 'e', 'i', 'o', 'u').contains(c))

  println(filterVowels("Orange"))
  println
  println
  val b = Set("Brown", "Red", "Green", "purple", "Gray", "Yellow")
  println(b.filter(s => filterVowels(s).length > 1))

  println
  println
  val m = Map(1 -> "One", 2 -> "Two", 3 -> "Three", 4 -> "Four")
  println(m.filterKeys(_ % 2 == 0))

  println
  println
  println(Some(5).filter(_ % 2 == 0)) // THIS IS WOW!
  println(Some(4).filter(_ % 2 == 0))

  println
  println
  val xs = Array(1, 2, 3, 44)
  println((xs map (2 *)).toList) // convert to list only to show contents

  println
  println
  val s = "Hello World"
  println(s filter (_.isUpper))
}
