package _020_collections

import java.time.LocalTime

object _01_Lists extends App {
  val a = List(1, 2, 3, 4, 5)
  val a2 = List.apply(1, 2, 3, 4, 5)
  val a3 = 1 :: 2 :: 3 :: 4 :: 5 :: Nil // :: pronounced as 'cons'
  val empty = List
  val listOfLists = List(List(0, 1, 2), 3, 4)
  val b = List(6, 7, 8, 9)

  println(s"empty: $empty")

  println("===================")

  println(s"a: $a")
  println(s"a2: $a2")
  println(s"a3: $a3")

  println("===================")

  println(s"a.head: ${a.head}")
  println(s"a.tail: ${a.tail}")
  println(s"a.tail.head: ${a.tail.head}")
  println(s"a.tail.tail.head: ${a.tail.tail.head}")
  println(s"a.init: ${a.init}")
  println(s"a.last: ${a.last}")

  println("===================")

  println(s"a(3): ${a(3)}")
  println(s"a.min: ${a.min}")
  println(s"a.max: ${a.max}")
  println(s"a.isEmpty: ${a.isEmpty}")
  println(s"a.nonEmpty: ${a.nonEmpty}")
  println(s"a.updated(3, 100): ${a.updated(3, 100)}")

  println("===================")

  print("a.mkString(\",\"): ")
  println(a.mkString(","))

  print("a.mkString(\"**\"): ")
  println(a.mkString("**"))

  print("a.mkString(\"[\", \"**\", \"]\")")
  println(a.mkString("[", "**", "]"))

  println("===================")

  println(s"listOfLists: $listOfLists")

  println("===================")

  println(s"a take 2: ${a take 2}")
  println(s"a drop 2: ${a drop 2}")

  println("===================")

  // all of these will contact a + b to 1 list
  println(s"a ++ b ==> ${a ++ b}")
  println(s"a ::: b ==> ${a ::: b}")
  println(s"b.:::(a) ==> ${b.:::(a)}")
  println(s"List.concat(a, b) ==> ${List.concat(a, b)}")

  println("===================")

  println(s"a.reverse: ${a.reverse}")

  println("===================")

  println(s"a indexOf 3: ${a indexOf 3}")
  println(s"a indexOf 30: ${a indexOf 30}")
  println(s"a contains 3: ${a contains 3}")
  println(s"a contains 30: ${a contains 30}")

  println("===================")

  println(s"a ==> $a")
  println(s"100 +: a :+ 1000 ==> ${100 +: a :+ 1000}")

  println("===================")

  // this will get a by name param to evaluate
  // for every element in the list
  val list = List.fill(3)(LocalTime.now)
  //  // or, we can use { } to add multi statements
  //   val list = List.fill(3){LocalTime.now}
  println(s"list: $list")
}