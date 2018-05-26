package _021_collections_with_functions

/**
  * -> foldLeft will take two parameters group, the first
  * will contain a seed and then a function that will
  * aggregate the collection into one.
  * -> foldLeft apply operation to the total with each element (left total first)
  *
  * -> reduce will collapse all elements of a collection using a function.
  * It will start the first element as the 'seed' or 'accumulation
  */
//noinspection SimplifiableFoldOrReduce
object _06_FoldAndReduce extends App {
  val foldLeftResult = (1 to 10).foldLeft(0)((total: Int, next: Int) => total + next)
  //  val foldLeftResult = (1 to 10).foldLeft(0) { (total: Int, next: Int) =>
  //    println(s"Total: $total, Next: $next")
  //    total + next
  //  }
  println("fold left: " + foldLeftResult)

  // reduce automatically chose first item as the seed!
  val reduceLeftResult = (1 to 10).reduceLeft((total: Int, next: Int) => total + next)
  println("reduce left: " + reduceLeftResult)

  val foldRightResult = (1 to 10).foldRight(0)((next: Int, total: Int) => total + next)
  //  val foldRightResult = (1 to 10).foldRight(0) { (next: Int, total: Int) =>
  //    println(s"Total: $total, Next: $next")
  //    total + next
  //  }
  println("fold right: " + foldRightResult)

  val reduceRightResult = (1 to 10).reduceRight((next: Int, total: Int) => total + next)
  println("reduce right: " + reduceRightResult)

  val sum = (1 to 10).sum
  println("sum: " + sum)

  val product = (1 to 10).product
  println("product: " + product)

  println("fold left: " + (1 to 10).foldLeft(0)(_ + _))
  println("reduce left: " + (1 to 10).reduceLeft(_ + _))

  println("mkString: " + (1 to 10).mkString(", "))
  println

  print("List(1, 3, 8).foldLeft(100)((s, x) => s - x) ==> ")
  println(List(1, 3, 8).foldLeft(100)((s, x) => s - x))
  println("Execution: ((100-1) - 3) - 8")
  println

  print("List(1, 3, 8).foldRight(100)((s, x) => s - x) ==> ")
  println(List(1, 3, 8).foldRight(100)((s, x) => s - x))
  println("Execution: 1 - (3 - (8 - 100))")
  println

  print("List(1, 3, 8).reduceLeft((s, x) => s - x) ==> ")
  println(List(1, 3, 8).reduceLeft((s, x) => s - x))
  println("Execution: (1 - 3) - 8")
  println

  print("List(1, 3, 8).reduceRight((s, x) => s - x) ==> ")
  println(List(1, 3, 8).reduceRight((s, x) => s - x))
  println("Execution: 1 - (3 - 8)")
  println


  def mySumReduce(xs: List[Int]): Int = (0 :: xs) reduceLeft (_ + _)

  def myProductReduce(xs: List[Int]): Int = (1 :: xs) reduceLeft (_ * _)

  println
  println("mySumReduce: " + mySumReduce((1 to 10).toList))
  println("myProductReduce: " + myProductReduce((1 to 10).toList))

  def mySumFold(xs: List[Int]): Int = (xs foldLeft 0) (_ + _)

  def myProductFold(xs: List[Int]): Int = (xs foldLeft 1) (_ * _)

  println
  println("mySumFold: " + mySumFold((1 to 10).toList))
  println("myProductFold: " + myProductFold((1 to 10).toList))


  def concat[T](xs: List[T], ys: List[T]): List[T] =
    (xs foldRight ys) (_ :: _)

  // // this will not work: types will not match! :: not applicable to T type
  // // foldLeft apply operation to the total with each element (left total first)
  // // foldRight apply operation to each element with total (right next first)
  //  def concatUsingFoldLeft[T](xs: List[T], ys: List[T]): List[T] =
  //    (xs foldLeft ys) (_ :: _)

  println
  println("concat: " + concat(List(1, 2, 3), List("Hi", "Hello", "Bye")))

  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight List[U]()) ((t, u) => f(t) :: u)

  println
  println("mapFun: " + mapFun[Int, Int](List(1, 2, 3), x => x * x))
  println("mapFun: " + mapFun[String, Int](List("Hi", "Hello", "Bye"), _.length))

  def lengthFun[T](xs: List[T]): Int =
    (xs foldRight 0) ((_, x) => x + 1)

  println
  println("lengthFun: " + lengthFun(List(1, 2, 3)))
  println("lengthFun: " + lengthFun(List("Hi", "Hello", "Bye", 5, 3.25, "test")))
  println

  def factorialWithFoldLeft(x: Int): Int = (1 to x).foldLeft(1)(_ * _)

  def factorialWithReduce(x: Int): Int = (1 to x).reduce(_ * _)

  println(s"factorialWithFoldLeft(5): ${factorialWithFoldLeft(5)}")
  println(s"factorialWithFoldLeft(10): ${factorialWithFoldLeft(10)}")
  println
  println(s"factorialWithReduce(5): ${factorialWithReduce(5)}")
  println(s"factorialWithReduce(10): ${factorialWithReduce(10)}")

}