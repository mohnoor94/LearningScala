package _06_pattern_matching

object Example05_Methods_withLists extends App {
  println("===== last =====")
  println(last(List(1, 2, 3)))
  println(last(List(1, 2)))
  println(last(List(1)))
  println
  println("===== init =====")
  println(init(List(1, 2, 3)))
  println(init(List(1, 2)))
  println(init(List(1)))
  println
  println("===== reverse =====")
  println(reverse(List(1, 2, 3)))
  println(reverse(List(1, 2)))
  println(reverse(List(1)))
  println
  println("===== removeAt =====")
  println(removeAt(0, List(1, 2, 3)))
  println(removeAt(1, List(1, 2, 3)))
  println(removeAt(2, List(1, 2, 3)))
  println(removeAt(5, List(1, 2, 3)))
  println(removeAt(1, List(1, 2)))
  println(removeAt(0, List(1)))
  println(removeAt(1, List(1)))
  println
  println("===== contact =====")
  println(contact(List(1, 2, 3), List(4, 5, 6)))
  println(contact(Nil, List(4, 5, 6)))
  println(contact(List(1, 2, 3), Nil))



  def last[T](xs: List[T]): T = xs match {
    case List() => throw new Error("last of empty list")
    case List(x) => x
    case _ :: ys => last(ys)
  }

  def init[T](xs: List[T]): List[T] = xs match {
    case List() => throw new Error("init of empty list")
    case List(_) => List()
    case y :: ys => y :: init(ys)
  }

  // O(n)
  def contact[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List() => ys
    case z :: zs => z :: contact(zs, ys)
  }

  // O(n*n)
  def reverse[T](xs: List[T]): List[T] = xs match {
    case List() => xs
    case y :: ys => reverse(ys) ++ List(y)
  }

  def removeAt[T](index: Int, xs: List[T]): List[T] = (xs take index) ::: (xs drop index + 1)
}