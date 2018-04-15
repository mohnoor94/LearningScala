package _04_collections_with_functions

object MoreFunctions extends App {
  val a = List(1, 2, 3, 4, 5, 6)
  //  val b = a partition (x => x % 2 == 0)
  val b = a partition (_ % 2 == 0)
  println("===== partition =====")
  println(b)
  println(b._1)
  println(b._2)

  println("> partition is filter + filterNot:")
  println(a filter (_ % 2 == 0))
  println(a filterNot (_ % 2 == 0))

  println
  println("*------*")
  println

  val colours = List("Red", "Orange", "Green", "Grey", "Purple", "Pink")
  //  val gb = colours.groupBy(x => x.head)
  val gb = colours.groupBy(_.head)
  println("===== groupBy =====")
  println(gb)

  println
  println("*------*")
  println

  println("===== take =====")
  println((1 to 100).take(10).toList)
  println((1 to 100).takeRight(10).toList)
  println((1 to 100).takeWhile(_ < 10).toList)

  println
  println("*------*")
  println

  println("===== drop =====")
  println((1 to 100).drop(90).toList)
  println((1 to 100).dropRight(90).toList)
  println((1 to 100).dropWhile(_ < 90).toList)

  println
  println("*------*")
  println

  println("===== span =====")
  println("> span is takeWhile + dropWhile")
  println((1 to 100).span(_ < 10))
  println((1 to 100).span(_ < 90))

  println
  println("*------*")
  println

  println("===== reverse =====")
  println((1 to 10).reverse.toList)

  println
  println("*------*")
  println

  println("===== distinct =====")
  println(List(1, 1, 2, 3, 4, 5, 6, 6, 4, 7, 8, 9, 10, 9, 10).distinct)

  println
  println("*------*")
  println

  println("===== empty =====")
  println(List.empty)
  println(List.empty[Int])
  println(List.empty[String])
  println(List.empty[List[Int]])

  println
  println("*------*")
  println

  println("===== by name example =====")
  val f = List.fill(10) {
    val x = 10
    val y = 20
    x + y + 19
  }

  println(f)

  println
  println("*------*")
  println
}
