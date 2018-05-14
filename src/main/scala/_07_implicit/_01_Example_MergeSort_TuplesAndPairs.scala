package _07_implicit

object _01_Example_MergeSort_TuplesAndPairs extends App {
  println("===== version 4 =====")
  println(mergeSort4(List(5, 9, 4, 2, 1, 6, 0, 3, 6)))
  println(mergeSort4(List(5, 0, 9, -3, -6, 8)))
  println(mergeSort4(List(5.2, 0.6, 9, -3.25, -6, 8)))
  println(mergeSort4(List("pineapple", "apple", "orange", "banana")))

  def mergeSort4[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys1) => ys1
        case (xs1, Nil) => xs1
        case (x :: xs1, y :: ys1) =>
          if (ord.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(ys1, xs)
      }
      val (fst, snd) = xs splitAt n
      merge(mergeSort4(fst), mergeSort4(snd))
    }
  }
}
