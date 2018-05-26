package _040_pattern_matching

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