package _021_collections_with_functions

import scala.language.postfixOps

object _99_MoreFunctions extends App {
  val a = List(1, 2, 3, 4, 5, 6)
  //  val b = a partition (x => x % 2 == 0)
  /** xs partition p    equals    (xs filter p, xs filter (!p(_))) */
  val b = a partition (_ % 2 == 0)
  println("===== partition =====")
  println(b)
  println(b._1)
  println(b._2)

  println("> partition is filter + filterNot:")
  println(a filter (_ % 2 == 0))
  println(a filterNot (_ % 2 == 0))

  println()
  /** The find method is also similar to filter, but it returns the first element satisfying a given predicate,
    * rather than all such elements. */
  println("===== find =====")
  println(a find (_ % 2 == 0))

  println()

  val colours = List("Red", "Orange", "Green", "Grey", "Purple", "Pink")
  //  val gb = colours.groupBy(x => x.head)
  val gb = colours groupBy (_.head)
  println("===== groupBy =====")
  println(gb)

  println()

  println("===== sort =====")
  println(colours sortWith (_.length < _.length))
  println(colours sortBy (_.head))
  println(colours sorted)

  println()

  println("===== take =====")
  println((1 to 100).take(10).toList)
  println((1 to 100).takeRight(10).toList)
  println((1 to 100).takeWhile(_ < 10).toList)

  println()

  println("===== drop =====")
  println((1 to 100).drop(90).toList)
  println((1 to 100).dropRight(90).toList)
  println((1 to 100).dropWhile(_ < 90).toList)

  println()

  println("===== splitAt =====")
  println("> xs splitAt n equals (xs take n, xs drop n)")
  println(">> However, splitAt avoids traversing the list xs twice.")
  println((1 to 100).splitAt(50))
  println((1 to 100).splitAt(20))

  println()

  println("===== span =====")
  /** xs span p    equals    (xs takeWhile p, xs dropWhile p)
    * Like splitAt, span avoids traversing the list xs twice */
  println("> span is takeWhile + dropWhile")
  println((1 to 100).span(_ < 10))
  println((1 to 100).span(_ < 90))

  println()

  println("===== reverse =====")
  println((1 to 10).reverse.toList)

  println()

  println("===== distinct =====")
  println(List(1, 1, 2, 3, 4, 5, 6, 6, 4, 7, 8, 9, 10, 9, 10).distinct)

  println()

  println("===== empty =====")
  println(List.empty)
  println(List.empty[Int])
  println(List.empty[String])
  println(List.empty[List[Int]])

  println()

  println("===== exists =====")
  println(a exists (_ >= 5))
  println(a exists (_ <= 5))

  println()

  println("===== forall =====")
  println(a forall (_ >= 5))
  println(a forall (_ <= 5))
  println(a forall (_ <= 6))

  println()

  println("===== fill =====")
  println(List.fill(10)('a'))
  println(List.fill(10)(5))
  println(List.fill(10)(" "))
  println(List.fill(2, 3)('b'))

  println()

  println("===== tabulate =====")
  /** The tabulate method creates a list whose elements are computed according to a supplied function. */
  println(List.tabulate(5)(n => n * n))
  println(List.tabulate(5, 5)(_ * _))

  println()

  println("===== collect =====")
  /* collect will apply a partial function to all elements
  * and will return a different collection. It will
  * actually be the combination between
  * map and filter
  */
  val collectResult = List(1, 2, 3, 4, 5)
    .collect { case x: Int if x % 2 == 0 => x * 2 }
  println(collectResult)

  println()

  println("===== scan =====")
  /* scan is like a reduce but maintains a running total
  * with each iteration
  */
  val scanResult = List(1, 2, 3).scan(1) { (total, next) => total * next }
  println(scanResult)

  println()

  println("===== view =====")
  /* view will not immediately evaluate a chain until a terminal
  * operation is called, like reduce, count, mkString, fold, or force
  * (for laziness)
  */
  val viewResult = (1 to 1000000000).view.map(x => x * 2).take(10).mkString(", ")
  println(viewResult)

  println()

  println("===== by name example =====")
  val f = List.fill(10) {
    val x = 10
    val y = 20
    x + y + 19
  }

  println(f)
}
