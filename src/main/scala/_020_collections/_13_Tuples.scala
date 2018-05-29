package _020_collections

/**
  * > A tuple combines a fixed number of items together so that they can be passed around as a whole.
  * > Unlike an array or list, a tuple can hold objects with different types.
  *
  * > Tuples save you the tedium of defining simplistic data-heavy classes.
  * > Even though defining a class is already easy, it does require a certain minimum effort, which sometimes serves no
  * purpose.
  * >> Tuples save you the effort of choosing a name for the class, choosing a scope to define the class in, and
  * >> choosing names for the members of the class. If your class simply holds an integer and a string,
  * >> there is no clarity added by defining a class named AnIntegerAndAString.
  *
  * > Because tuples can combine objects of different types,tuples do not inherit from Traversable.
  * >> If you find yourself wanting to group exactly one integer and exactly one string, then you want a tuple, not a
  * List or Array.
  *
  * > A common application of tuples is returning multiple values from a method.
  *
  * ▶ As a note of warning, tuples are almost too easy to use.
  * >> Tuples are great when you combine data that has no meaning beyond "an A and aB."
  * >> However, whenever the combination has some meaning, or you want to add some methods to the combination, it is
  * better to go ahead and create a class.
  * >>> For example, do not use a 3-tuple for the combination of a month, a day, and a year.
  * Make a Date class.
  * >>> It makes your intentions explicit, which both clears up the code for human readers and gives the compiler and
  * language opportunities to help you catch mistakes.
  */
object _13_Tuples {
  /** For example, here is a method that finds the longest word in a collection and also returns its index: */
  def longestWord(words: Array[String]): (String, Int) = {
    var word = words(0)
    var idx = 0
    for (i <- 1 until words.length)
      if (words(i).length > word.length) {
        word = words(i)
        idx = i
      }
    (word, idx)
  }

  def main(args: Array[String]): Unit = {
    val longest = longestWord("The quick brown fox".split(" "))
    println(longest)
    println(longest._1)
    println(longest._2)
    println()

    /** Additionally, you can assign each element of the tuple to its own variable,
      * This syntax is actually a special case of pattern matching. */
    val (a, b) = longest
    println(a)
    println(b)
    println()

    /** By the way, if you leave off the parentheses you get a different result,
      * (This syntax gives multiple definitions of the same expression.) */
    val c, d = longest
    println(c)
    println(d)
    println()
  }
}