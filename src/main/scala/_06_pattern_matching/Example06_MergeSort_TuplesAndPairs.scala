package _06_pattern_matching

object Example06_MergeSort_TuplesAndPairs extends App {
  println("===== version 1 =====")
  println(mergeSort1(List(5, 9, 4, 2, 1, 6, 0, 3, 6)))
  println(mergeSort1(List(5, 0, 9, -3, -6, 8)))
  println
  println("===== version 2 =====")
  println(mergeSort2(List(5, 9, 4, 2, 1, 6, 0, 3, 6))((x, y) => x < y))
  println(mergeSort2(List(5, 0, 9, -3, -6, 8))((x, y) => x < y))
  println(mergeSort2(List(5.2, 0.6, 9, -3.25, -6, 8))((x, y) => x < y))
  println(mergeSort2(List("pineapple", "apple", "orange", "banana"))((x, y) => x.compareTo(y) < 0))
  println
  println("===== version 3 =====")
  println(mergeSort3(List(5, 9, 4, 2, 1, 6, 0, 3, 6))(Ordering.Int))
  println(mergeSort3(List(5, 0, 9, -3, -6, 8))(Ordering.Int))
  println(mergeSort3(List(5.2, 0.6, 9, -3.25, -6, 8))(Ordering.Double))
  println(mergeSort3(List("pineapple", "apple", "orange", "banana"))(Ordering.String))
  println
  println(">> Check version 4 using implicits in next package!")


  def mergeSort1(xs: List[Int]): List[Int] = {
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
      merge(mergeSort1(fst), mergeSort1(snd))
    }
  }

  def mergeSort2[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys1) => ys1
        case (xs1, Nil) => xs1
        case (x :: xs1, y :: ys1) =>
          if (lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(ys1, xs)
      }

      val (fst, snd) = xs splitAt n
      merge(mergeSort2(fst)(lt), mergeSort2(snd)(lt))
    }
  }

  def mergeSort3[T](xs: List[T])(ord: Ordering[T]): List[T] = {
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
      merge(mergeSort3(fst)(ord), mergeSort3(snd)(ord))
    }
  }
}
