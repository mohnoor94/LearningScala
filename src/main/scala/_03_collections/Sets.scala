package _03_collections

object Sets extends App {
  val set = Set(1, 2, 3, 4)
  val set2 = Set(1, 2, 3, 4, 5)
  val set3 = Set(1, 2, 3, 4, 5, 6)
  val set4 = Set(1, 2, 3, 4, 5, 6, 6, 7)

  println(set)
  println(set2)
  println(set3)
  println(set4)

  val set5 = Set(1, 2)

  println("==================")

  println(set diff set4) // Set()
  println(set4 diff set) // Set(5, 6, 7)

  println("==================")

  println(set union set4) // Set(5, 1, 6, 2, 7, 3, 4)
  println(set intersect set4) // Set(1, 2, 3, 4)
  println(set5 intersect set4) // Set(1, 2)

  println("==================")

  // ++ like union but with any collection
  println(set ++ set2) // Set(5, 1, 2, 3, 4)
  println(set ++ List(15, 20, 30, 30)) // Set(20, 1, 2, 3, 30, 4, 15)

  println(set + 10) // Set(10, 1, 2, 3, 4)

  println("==================")

  // -- remove collection
  println(set -- set5) // Set(3, 4)
  println(set -- Set(3, 4)) // Set(1, 2)
  println(set -- set) // Set()

  println(set - 3) // Set(1, 2, 4)

  println("==================")

  // all are the same... (contains)
  println(set.apply(4))
  println(set(4))
  println(set.contains(4))

  println(set.apply(40))
  println(set(40))
  println(set.contains(40))
}
