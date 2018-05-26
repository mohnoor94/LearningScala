package _04_collections_with_functions.examples

import scala.language.postfixOps

object _02_EncodeList extends App {
  println(pack(List("a", "a", "a", "b", "c", "c", "a")))
  println(packEncode1(List("a", "a", "a", "b", "c", "c", "a")))
  println(packEncode2(List("a", "a", "a", "b", "c", "c", "a")))

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: _ =>
      val (first, rest) = xs span (p => p == x)
      first :: pack(rest)
  }

  def packEncode1[T](xs: List[T]): List[(T, Int)] = xs match {
    case Nil => Nil
    case x :: _ =>
      val (first, rest) = xs span (p => p == x)
      (first head, first length) :: packEncode1(rest)
  }

  def packEncode2[T](xs: List[T]): List[(T, Int)] =
    pack(xs) map (ys => (ys head, ys length))
}