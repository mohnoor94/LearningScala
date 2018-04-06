package collections_with_functions

object FoldAndReduce extends App {
  val foldLeftResult = (1 to 10).foldLeft(0)((total: Int, next: Int) => total + next)
  //  val foldLeftResult = (1 to 10).foldLeft(0) { (total: Int, next: Int) =>
  //    println(s"Total: $total, Next: $next")
  //    total + next
  //  }
  println(foldLeftResult)
  println

  // reduce automatically chose first item as the seed!
  val reduceLeftResult = (1 to 10).reduceLeft((total: Int, next: Int) => total + next)
  println(reduceLeftResult)
  println

  val foldRightResult = (1 to 10).foldRight(0)((total: Int, next: Int) => total + next)
  //  val foldRightResult = (1 to 10).foldRight(0) { (next: Int, total: Int) =>
  //    println(s"Total: $total, Next: $next")
  //    total + next
  //  }
  println(foldRightResult)
  println

  val reduceRightResult = (1 to 10).reduceRight((next: Int, total: Int) => total + next)
  println(reduceRightResult)
  println

  val sum = (1 to 10).sum
  println(sum)
  println

  val product = (1 to 10).product
  println(product)
  println

  println((1 to 10).foldLeft(0)(_ + _))
  println((1 to 10).reduceLeft(_ + _))

  println
  println((1 to 10).mkString(", "))
}
