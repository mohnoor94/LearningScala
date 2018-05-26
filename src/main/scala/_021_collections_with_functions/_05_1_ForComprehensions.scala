package _021_collections_with_functions

import scala.language.postfixOps

object _05_1_ForComprehensions extends App {
  //  for (i <- 1 to 10)
  //    println(i)
  //
  //  println

  val result = for (i <- 1 to 10) yield i + 1
  println(result)

  val result2 = (1 to 10).map(1 +)
  println(result2)

  val result3 = for (i <- Some(100)) yield i + 40
  println(result3)

  val result4 = Some(100).map(40 +)

  val result5 = for (i <- List(1, 2, 3, 4);
                     j <- List(5, 6, 7, 8, 9)) yield (i, j)
  println(result5)

  val result6 = List(1, 2, 3, 4).map(i => List(5, 6, 7, 8).map(j => (i, j)))
  println(result6)

  val result6b = List(1, 2, 3, 4).flatMap(i => List(5, 6, 7, 8, 9).map(j => (i, j)))
  println(result6b)

  val result7 = for (i <- List(1, 2, 3, 4) if (i % 2 == 0);
                     j <- List(5, 6, 7, 8)) yield (i, j)
  println(result7)

  val result7b = for (i <- List(1, 2, 3, 4) if i % 2 == 0;
                      j <- List(5, 6, 7, 8)) yield (i, j)
  println(result7b)

  val result7c = for (i <- List(1, 2, 3, 4)
                      if i % 2 == 0;
                      j <- List(5, 6, 7, 8)) yield (i, j)
  println(result7c)

  val result7d = List(1, 2, 3, 4).filter(i => i % 2 == 0).flatMap(i => List(5, 6, 7, 8).map(j => (i, j)))
  println(result7d)

  // lazy filter
  val result7e = List(1, 2, 3, 4).withFilter(i => i % 2 == 0).flatMap(i => List(5, 6, 7, 8).map(j => (i, j)))
  println(result7e)

  val result8 = for (i <- List(1, 2, 3, 4);
                     j <- List(5, 6, 7, 8) if j < 7) yield (i, j)
  println(result8)

  val result8c = for (i <- List(1, 2, 3, 4);
                      j <- List(5, 6, 7, 8)
                      if j < 7) yield (i, j)
  println(result8c)

  val result8d =
    List(1, 2, 3, 4)
      .flatMap(i => List(5, 6, 7, 8)
        .filter(j => j < 7)
        .map(j => (i, j)))
  println(result8d)

  // lazy filter
  val result8e =
    List(1, 2, 3, 4)
      .flatMap(i => List(5, 6, 7, 8)
        .withFilter(j => j < 7)
        .map(j => (i, j)))
}