package _04_collections_with_functions

object FilterFunction extends App {
  val a = 1 to 10
  println(a.filter(x => x % 2 == 0))
  println(a.filter(_ % 2 == 0))
  println()
  println()
  println(a.filterNot(x => x % 2 == 0))
  println(a.filterNot(_ % 2 == 0))
  println()
  println()
  println(a.exists(x => x % 2 == 0))
  println(a.exists(_ % 2 == 0))
  println()
  println()
  println()

  // you may use Regex for this!
  def filterVowels(s: String) = s.toLowerCase.filter(c => Set('a', 'e', 'i', 'o', 'u').contains(c))

  println(filterVowels("Orange"))
  println()
  println()
  val b = Set("Brown", "Red", "Green", "purple", "Gray", "Yellow")
  println(b.filter(s => filterVowels(s).length > 1))

  println()
  println()
  val m = Map(1 -> "One", 2 -> "Two", 3 -> "Three", 4 -> "Four")
  println(m.filterKeys(_ % 2 == 0))

  println()
  println()
  println(Some(5).filter(_ % 2 == 0)) // THIS IS WOW!
  println(Some(4).filter(_ % 2 == 0))

}
