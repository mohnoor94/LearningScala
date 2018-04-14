package _03_collections

object Lists extends App {
  val a = List(1, 2, 3, 4, 5)
  val a2 = List.apply(1, 2, 3, 4, 5)
  val a3 = 1 :: 2 :: 3 :: 4 :: 5 :: Nil // :: pronounced as 'cons'
  val empty = List
  val listOfLists = List(List(0, 1, 2), 3, 4)
  val b = List(6, 7, 8, 9)

  println(empty)

  println("===================")

  println(a)
  println(a2)
  println(a3)

  println("===================")

  println(a.head)
  println(a.tail)
  println(a.tail.head)
  println(a.tail.tail.head)
  println(a.init)
  println(a.last)

  println("===================")

  println(a(3))
  println(a.min)
  println(a.max)
  println(a.isEmpty)
  println(a.nonEmpty)
  println(a.updated(3, 100))

  println("===================")

  println(a.mkString(","))
  println(a.mkString("**"))
  println(a.mkString("[", "**", "]"))

  println("===================")

  println(listOfLists)

  println("===================")

  println(a take 2)
  println(a drop 2)

  println("===================")

  // all of these will contact a + b to 1 list
  println(a ++ b)
  println(a ::: b)
  println(b.:::(a))

  println("===================")

  println(a.reverse)

  println("===================")

  println(a indexOf 3)
  println(a indexOf 30)
  println(a contains 3)
  println(a contains 30)

  println("===================")


}
