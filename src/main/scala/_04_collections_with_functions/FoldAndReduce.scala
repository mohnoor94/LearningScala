package _04_collections_with_functions

//noinspection SimplifiableFoldOrReduce
object FoldAndReduce extends App {
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

  def mySumReduce(xs: List[Int]) = (0 :: xs) reduceLeft (_ + _)

  def myProductReduce(xs: List[Int]) = (1 :: xs) reduceLeft (_ * _)

  println
  println("mySumReduce: " + mySumReduce((1 to 10).toList))
  println("myProductReduce: " + myProductReduce((1 to 10).toList))

  def mySumFold(xs: List[Int]) = (xs foldLeft 0) (_ + _)

  def myProductFold(xs: List[Int]) = (xs foldLeft 1) (_ * _)

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
}
