package _020_collections

import java.time.LocalTime

/**
  * > Lists are quite similar to arrays, but there are two important differences.
  * >> First, lists are immutable. That is, elements of a list cannot be changed by assignment.
  * >> Second, lists have a recursive structure (i.e., a linked list), whereas arrays are flat.
  *
  * > Perhaps the most important sequence type to know about is class List,the immutable linked-list.
  * >> Lists support fast addition and removal of items to the beginning of the list, but they do not provide fast
  * access to arbitrary indexes because the implementation must iterate through the list linearly.
  *
  * > The list type in Scala is covariant. This means that for each pair of types S and T, if S is a subtype of T, then
  * List[S] is a subtype of List[T]. For instance, List[String] is a subtype of List[Object]
  * >> This is natural because every list of strings can also be seen as a list of objects.
  * >> The empty list has type List[Nothing].
  * >> So the empty list object, which has type List[Nothing], can also be seen as an object of every other list type of
  * the form List[T] (Nothing is the bottom type of every other type in Scala).
  *
  *
  * >> IMPORTANT:
  * Study '16.10 Understanding Scala's type inference algorithm', From: Programming in Scala, Third Edition.
  */
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
  /**
    * > Unlike head and tail, which both run in constant time, init and last need to traverse the whole list to compute
    * their result.
    * >> As a result, they take time proportional to the length of the list.
    * ▶ It's a good idea to organize your data so that most accesses are at the head of a list, rather than the last
    * element.
    */
  println(s"a.init: ${a.init}")
  println(s"a.last: ${a.last}")

  println("===================")

  println(s"a(3): ${a(3)}")
  println(s"a.min: ${a.min}")
  println(s"a.max: ${a.max}")
  /**
    * > On lists, unlike arrays, length is a relatively expensive operation.
    * >> It needs to traverse the whole list to find its end, and therefore
    * >> takes time proportional to the number of elements in the list.
    * >> That's why it's not a good idea to replace a test such as xs.isEmpty by xs.length == 0.
    * >> The result of the two tests is equivalent, but the second one is slower, in particular if the list xs is long.
    */
  println(s"a.isEmpty: ${a.isEmpty}")
  println(s"a.nonEmpty: ${a.nonEmpty}")
  println(s"a.updated(3, 100): ${a.updated(3, 100)}")

  println("===================")

  println(s"a indices ==> ${a.indices}")

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

  /**
    * If at some point in the computation an algorithm demands frequent accesses to the end of a list, it's sometimes
    * better to reverse the list first and work with the result instead.
    */
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