package _021_collections_with_functions.my_set

// Contains all elements of type A which satisfy a property
// { x in A | property(x) }
class PropertyBasedSet[A](property: A => Boolean) extends MySet[A] {
  override def contains(elem: A): Boolean = property(elem)

  // { x in A | property(x) } + elem = { x in A | property(x) || x == elem }
  override def +(elem: A): MySet[A] = new PropertyBasedSet[A](x => property(x) || x == elem)

  // { x in A | property(x) } - elem = { x in A | property(x) && x !=  elem }
  // override def -(elem: A): MySet[A] = new PropertyBasedSet[A](x => property(x) && x != elem)
  override def -(elem: A): MySet[A] = filter(x => x != elem)

  // { x in A | property(x) } ++ set = { x in A | property(x) || anotherSet contains x }
  override def ++(anotherSet: MySet[A]): MySet[A] = new PropertyBasedSet[A](x => property(x) || anotherSet(x))

  // override def --(anotherSet: MySet[A]): MySet[A] = new PropertyBasedSet[A](x => property(x) && !anotherSet(x))
  override def --(anotherSet: MySet[A]): MySet[A] = filter(!anotherSet)

  // override def &(anotherSet: MySet[A]): MySet[A] = new PropertyBasedSet[A](x => property(x) && anotherSet(x))
  override def &(anotherSet: MySet[A]): MySet[A] = filter(anotherSet)

  override def unary_! : MySet[A] = new PropertyBasedSet[A](x => !property(x))

  override def filter(predicate: A => Boolean): MySet[A] = new PropertyBasedSet[A](x => property(x) && predicate(x))

  // you can go from infinite set to a finite set
  // e.g., all integers => (_ % 3) => [0, 1, 2]!
  override def map[B](f: A => B): MySet[B] = politelyFail

  override def flatMap[B](f: A => MySet[B]): MySet[B] = politelyFail

  override def foreach(f: A => Unit): Unit = politelyFail

  def politelyFail = throw new IllegalArgumentException("Really deep rabbit hole!")
}
