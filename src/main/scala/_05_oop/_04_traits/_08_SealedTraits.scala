package _05_oop._04_traits

/**
  * A sealed trait is a trait that will have children,
  * but it will define all it's children and not one else will have the
  * ability to extend the number of children any further. All children
  * must be produced within the same file. This will also create what
  * is called a union type if you are familiar with Haskell, Elm, F#,
  * and other functional languages.
  *
  * You can also have sealed abstract classes, which will operate under
  * the same rules, the children must all be inside the same file,
  * and the children should be final.
  *
  * Why would you choose one over the other?
  * You can multiple inherit a trait and mixin traits.
  * Abstract classes offer stronger "is-a" relationships
  * A popular sealed abstract class is Option[+T], Some[T], and None.
  *
  *
  * Sealed traits are also a good idea for pattern matching
  * exhaustiveness. The compiler will be able to recognize the subclasses
  * of all sealed traits (help to not get runtime exception surprises).
  */
sealed trait Tree[+A]

/**
  * I have added 'final' so no one else can extend Node
  * 'sealed' prevents any one from extending the Tree trait itself
  * but not its children.
  */
final case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A]

final case class Leaf[A](value: A) extends Tree[A]

/**
  * 'case' on object mainly for pattern matching
  */
case object Empty extends Tree[Nothing]


object _08_SealedTraits extends App {
  val tree: Tree[Int] = Node(Leaf(5), Leaf(10))
  println(tree.asInstanceOf[Node[_]].left.asInstanceOf[Leaf[_]].value)

  val treeDetails = (tree: Tree[_]) => tree match {
    case Node(Leaf(x), Leaf(y)) => s"Two Leaves: $x and $y"
    case Leaf(x) => s"Leaf $x"
    case Empty => "Empty"
  }

  println(treeDetails(tree))
  println(treeDetails(Leaf(10)))
  println(treeDetails(Empty))
}
