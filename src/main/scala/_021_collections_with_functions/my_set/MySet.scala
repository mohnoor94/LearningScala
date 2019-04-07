package _021_collections_with_functions.my_set

import scala.annotation.tailrec

/**
  * Building a fully functional set!
  */
trait MySet[A] extends (A => Boolean) {

  def apply(elem: A): Boolean = contains(elem)

  def contains(elem: A): Boolean

  def +(elem: A): MySet[A] // add

  def -(elem: A): MySet[A] // remove

  def ++(anotherSet: MySet[A]): MySet[A]

  def --(anotherSet: MySet[A]): MySet[A] // difference

  def &(anotherSet: MySet[A]): MySet[A] // intersection

  def unary_! : MySet[A] // negation

  def map[B](f: A => B): MySet[B]

  def flatMap[B](f: A => MySet[B]): MySet[B]

  def filter(predicate: A => Boolean): MySet[A]

  def foreach(f: A => Unit): Unit
}

// helper
object MySet {
  def apply[A](values: A*): MySet[A] = {

    @tailrec def buildSet(valSeq: Seq[A], acc: MySet[A]): MySet[A] = {
      if (valSeq.isEmpty) acc
      else buildSet(valSeq.tail, acc + valSeq.head)
    }

    buildSet(values, new EmptySet[A])
  }
}