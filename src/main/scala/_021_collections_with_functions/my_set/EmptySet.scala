package _021_collections_with_functions.my_set

class EmptySet[A] extends MySet[A] {

  override def contains(elem: A): Boolean = false

  override def +(elem: A): MySet[A] = NonEmptySet(elem, this)

  override def -(elem: A): MySet[A] = this

  override def ++(anotherSet: MySet[A]): MySet[A] = anotherSet

  override def --(anotherSet: MySet[A]): MySet[A] = this

  override def &(anotherSet: MySet[A]): MySet[A] = this

  override def unary_! : MySet[A] = ???

  override def map[B](f: A => B): MySet[B] = new EmptySet[B]

  override def flatMap[B](f: A => MySet[B]): MySet[B] = new EmptySet[B]

  override def filter(predicate: A => Boolean): MySet[A] = this

  override def foreach(f: A => Unit): Unit = ()
}