package _04_collections_with_functions

object FlatMapFunction extends App {
  val a = (1 to 6).toList

  // Collection of collection => Collection
  println(a.map(x => List(-x, 0, x)))
  println(a.map(x => List(-x, 0, x)).flatten)
  println(a.flatMap(x => List(-x, 0, x)))

  println

  val b = List(List(List(1, 2, 3), List(4, 5, 6)), List(List(7, 8, 9), List(10, 11, 12)))
  println(b)
  println(b.flatMap(c => c))
  println(b.flatMap(c => c).flatMap(c => c))
  println(b.flatMap(c => c).flatMap(c => c).flatMap(c => List(-c, c)))
  println()
  println(b.flatten)
  println(b.flatten.flatten)
  println(b.flatten.flatten.flatMap(c => List(-c, c)))

  println

  println(Set(2, 4, 10, 11).flatMap(x => Set(x, x * 5)))

  println

  val originalMap = Map(1 -> "One", 2 -> "Two", 3 -> "Three")
  println(originalMap)
  println(originalMap.flatMap(t => Map(t._1 -> t._2, (t._1 * 100) -> (t._2 + " Hundred"))))

  println

  println(Some(4).map(x => Some(x + 19)))
  println(Some(4).flatMap(x => Some(x + 19)))
  //  println(None.flatMap(x => Some(x + 19)))
  println(None.asInstanceOf[Option[Int]].flatMap(x => Some(x + 19)))

  println

  println(Some(10).flatMap(_ => None))

  println

  // WoW Again!
  println(List(Some(4), None, Some(5), None, None, Some(10)).flatMap(x => x))
  println(List(Some(4), None, Some(5), None, None, Some(10)).flatten)
}