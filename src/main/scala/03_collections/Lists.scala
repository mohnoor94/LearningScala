package collections

object Lists extends App {
  val a = List(1, 2, 3, 4, 5)
  val a2 = List.apply(1, 2, 3, 4, 5)
  val a3 = 1 :: 2 :: 3 :: 4 :: 5 :: Nil


  println(a)
  println(a2)
  println(a3)

  println("===================")

  println(a.head)
  println(a.tail)
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
}
