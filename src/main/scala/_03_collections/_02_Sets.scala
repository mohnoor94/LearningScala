package _03_collections

import scala.collection.immutable.{HashSet, TreeSet}

/**
  * A Set is a collection with unique items with no order. They can
  * either be as HashSet which is stored is special type of collection
  * called trie. This will have fast lookup, add, and remove.
  *
  * A Set is can also be a TreeSet.
  * This will have logarithmic performance. It will win
  * generally in performance when you need to
  * find the smallest element
  * of the set. As far as API is concerned
  * you should expect no difference.
  */
object _02_Sets extends App {
  val set = Set(1, 2, 3, 4)
  val set2 = Set(1, 2, 3, 4, 5)
  val set3 = Set(1, 2, 3, 4, 5, 6)
  val set4 = Set(1, 2, 3, 4, 5, 6, 6, 7)
  val set5 = Set(1, 2)

  println(s"set ==> $set")
  println(s"set2 ==> $set2")
  println(s"set3 ==> $set3")
  println(s"set4 ==> $set4")
  println(s"set5 ==> $set5")

  println("==================")

  println(s"set diff set4 ==> ${set diff set4}") // Set()
  println(s"set4 diff set ==> ${set4 diff set}") // Set(5, 6, 7)

  println("==================")

  println(s"set union set4 ==> ${set union set4}") // Set(5, 1, 6, 2, 7, 3, 4)
  println(s"set intersect set4 ==> ${set intersect set4}") // Set(1, 2, 3, 4)
  println(s"set5 intersect set4 ==> ${set5 intersect set4}") // Set(1, 2)

  println("==================")

  // ++ like union but with any collection
  println(s"set ++ set2 ==> ${set ++ set2}") // Set(5, 1, 2, 3, 4)
  println(s"set ++ List(15, 20, 30, 30) ==> ${set ++ List(15, 20, 30, 30)}") // Set(20, 1, 2, 3, 30, 4, 15)
  println
  println(s"set + 10 ==> ${set + 10}") // Set(10, 1, 2, 3, 4)

  println("==================")

  // -- remove collection
  println(s"set -- set5 ==> ${set -- set5}") // Set(3, 4)
  println(s"set -- Set(3, 4) ==> ${set -- Set(3, 4)}") // Set(1, 2)
  println(s"set -- set ==> ${set -- set}") // Set()
  println
  println(s"set - 3 ==> ${set - 3}") // Set(1, 2, 4)

  println("==================")

  // all are the same... (contains)
  println(s"set.apply(4) ==> ${set.apply(4)}")
  println(s"set(4) ==> ${set(4)}")
  println(s"set.contains(4) ==> ${set.contains(4)}")
  println
  println(s"set.apply(40) ==> ${set.apply(40)}")
  println(s"set(40) ==> ${set(40)}")
  println(s"set.contains(40) ==> ${set.contains(40)}")

  println("==================")

  val hashSet = HashSet(1, 2, 3, 4, 5, 6, 8)
  println(s"hashSet ==> $hashSet")
  println(s"hashSet.contains(4) ==> ${hashSet.contains(4)}")
  println(s"hashSet.apply(4) ==> ${hashSet.apply(4)}")
  println(s"hashSet.apply(40) ==> ${hashSet.apply(40)}")

  println("==================")

  val treeSet = TreeSet(1, 2, 3, 4, 5, 6, 8)
  println(s"treeSet ==> $treeSet")
  println(s"treeSet.contains(4) ==> ${treeSet.contains(4)}")
  println(s"treeSet.apply(4) ==> ${treeSet.apply(4)}")
  println(s"treeSet.apply(40) ==> ${treeSet.apply(40)}")
}