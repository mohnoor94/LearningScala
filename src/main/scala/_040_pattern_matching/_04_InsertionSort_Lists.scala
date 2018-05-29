package _040_pattern_matching

/**
  * "Divide and Conquer" design principle for programs over recursive data structures such as lists.
  * > Many algorithms over lists first split an input list into simpler cases using a pattern match.
  * >> That's the divide part of the principle.
  * > They then construct a result foreach case. If the result is a non-empty list, some of its parts may be constructed
  * by recursive invocations of the same algorithm.
  * >> That's the conquer part of the principle.
  */
object _04_InsertionSort_Lists extends App {
  println(insertionSort(List(5, 9, 4, 2, 1, 6, 0, 3, 6)))
  println(insertionSort(List(5, 0, 9, -3, -6, 8)))
  println(insertionSort(List(5, 4, 3, 2, 1)))
  println(insertionSort(List(1, 2, 3, 4, 5)))

  // Complexity ~ O(n * n)
  def insertionSort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, insertionSort(ys))
  }

  private def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
  }
}