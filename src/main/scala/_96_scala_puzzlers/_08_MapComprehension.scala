package _96_scala_puzzlers

/**
  * Puzzler 8 - Map Comprehension
  * What is the result of executing the following code?
  *
  * zs fails because there are no default case and no case for List of 2 members.
  *
  * In Scala, the i <- 0 to 1 syntax is called a generator. With generators that perform a simple variable assignment,
  * it's easy to forget that the generator's left-hand side is not a simple variable, it's a pattern, as demonstrated
  * by Seq(x, y, z) <- xs in the code sample. The Scala compiler desugars generators with non-trivial patterns
  * (i.e., patterns that constistute more than a simple variable assignment) differently.
  * This expression:
  * for (pattern <- expr) yield fun
  * ends up being rewritten as:
  * expr map { case pattern => fun }
  *
  * for ys:
  * for (i <- 0 to 1) yield i + 1
  * is desugared to:
  * expr withFilter {
  * case pattern => true
  * case _ => false
  * } map { case pattern > fun }
  *
  * It is this withFilter invocation that transparently "strips out" the non-matching value that causes the
  * MatchError in our attempted desugaring.
  *
  * --> Because for comprehensions are very common in Scala code, familiarizing yourself with how for expressions are
  * desugared is time well spent.
  *
  * --> Unlike filter, which creates a new collection and so incurs the overhead of an entire run through the source
  * collection, withFilter is simply a "view." It lazily restricts the items passed on to subsequent map, flatMap,
  * foreach, and withFilter calls and is specifically designed for efficient chaining of these operations.
  */
object _08_MapComprehension extends App {
  val xs = Seq(Seq("a", "b", "c"), Seq("d", "e", "f"),
    Seq("g", "h"), Seq("i", "j", "k"))

  val ys = for (Seq(x, y, z) <- xs) yield x + y + z

  //  val zs = xs map { case Seq(x, y, z) => x + y + z } // throws scala.MatchError: List(g, h)

  println(xs)
  println(ys)
  //  println(zs)

  println("\n===== Solution =====\n")
  println(Solution.xs)
  println(Solution.ys)
  println(Solution.zs)

  /**
    * You can treat pattern matching generators in for comprehensions as including an "if matches" guard—guards are
    * desugared to withFilter invocations
    */
  object Solution {
    val xs = Seq(Seq("a", "b", "c"), Seq("d", "e", "f"),
      Seq("g", "h"), Seq("i", "j", "k"))

    val ys: Seq[String] = for (Seq(x, y, z) <- xs) yield x + y + z

    val zs: Seq[String] = xs withFilter {
      case Seq(_, _, _) => true
      case _ => false
    } map { case Seq(x, y, z) => x + y + z }
  }

}