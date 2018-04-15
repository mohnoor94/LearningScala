package _06_pattern_matching

object Example06_MergeSort_TuplesAndPairs extends App {
  println(mergeSort(List(5, 9, 4, 2, 1, 6, 0, 3, 6)))
  println(mergeSort(List(5, 0, 9, -3, -6, 8)))
  println(mergeSort(List(5, 4, 3, 2, 1)))
  println(mergeSort(List(1, 2, 3, 4, 5)))

  def mergeSort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
        case (Nil, ys1) => ys1
        case (xs1, Nil) => xs1
        case (x :: xs1, y :: ys1) =>
          if (x < y) x :: merge(xs1, ys)
          else y :: merge(ys1, xs)
      }

      val (fst, snd) = xs splitAt n
      merge(mergeSort(fst), mergeSort(snd))
    }
  }
}
