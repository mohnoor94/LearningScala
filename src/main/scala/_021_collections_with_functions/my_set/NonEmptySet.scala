package _021_collections_with_functions.my_set

import scala.language.postfixOps

case class NonEmptySet[A](head: A, tail: MySet[A]) extends MySet[A] {

  override def contains(elem: A): Boolean = elem == head || (tail contains elem)

  override def +(elem: A): MySet[A] =
    if (this contains elem) this
    else NonEmptySet[A](elem, this)

  override def -(elem: A): MySet[A] =
    if (head == elem) tail
    else tail - elem + head

  override def ++(anotherSet: MySet[A]): MySet[A] = tail ++ anotherSet + head

  override def --(anotherSet: MySet[A]): MySet[A] = filter(!anotherSet)

  // or...
  //  override def --(anotherSet: MySet[A]): MySet[A] =
  //    if (anotherSet contains head) tail -- anotherSet
  //    else tail -- anotherSet + head

  override def &(anotherSet: MySet[A]): MySet[A] = filter(anotherSet) // anotherSet contains elem

  override def unary_! : MySet[A] = ???

  override def map[B](f: A => B): MySet[B] = (tail map f) + f(head)

  override def flatMap[B](f: A => MySet[B]): MySet[B] = (tail flatMap f) ++ f(head)

  override def filter(predicate: A => Boolean): MySet[A] = {
    val filteredTail = tail filter predicate

    if (predicate(head)) filteredTail + head
    else filteredTail
  }

  override def foreach(f: A => Unit): Unit = {
    f(head)
    tail foreach f
  }
}