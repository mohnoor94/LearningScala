/**
  * Chapter 15 - Case Classes and Pattern Matching
  * From: Programming in Scala, Third Edition
  *
  * *** Contents from the book started with file #16 in this section
  *
  * > Case classes and pattern matching, are twin constructs that support you when writing regular, non-encapsulated
  * data structures.
  * > These two constructs are particularly helpful for tree-like recursive data.
  * > Case classes are Scala's way to allow pattern matching on objects without requiring a large amount of boilerplate.
  * >> Generally, all you need to do is add a single case keyword to each class that you want to be pattern matchable.
  * > Using the modifier "case" makes the Scala compiler add some syntactic conveniences to your class:
  *   >> it adds a factory method with the name of the class. This means that, for instance, you can write
  *   Var("x") to construct a Var object, instead of the slightly longer new Var("x").
  *   >> all arguments in the parameter list of a case class implicitly get a val prefix, so they are maintained
  *   as fields.
  *   >> the compiler adds "natural" implementations of methods toString, hashCode, and equals to your class.
  *   >> the compiler adds a copy method to your class for making modified copies.
  *     >>> This method is useful for making a new instance of the class that is the same as another one except that one
  *     or two attributes are different.
  *     >>> The method works by using named and default parameters.
  *     >>> You specify the changes you'd like to make by using named parameters.
  *     >>> For any parameter you don't specify, the value from the old object is used.
  *   >> the biggest advantage of case classes is that they support pattern matching.
  *
  * @see _16_BasicOperationsExample (without the explanations)
  *
  * match compared to switch
  * > Match expressions can be seen as a generalization of Java-style switches. A Java-style switch can be naturally
  * expressed as a match expression, where each pattern is a constant and the last pattern may be a wildcard
  * (which represents the default case of the switch).
  * > However, there are three differences to keep in mind:
  *   >> First, match is an expression in Scala (i.e., it always results in a value).
  *   >> Second, Scala's alternative expressions never "fall through" into the next case (no need to 'break').
  *   >> Third, if none of the patterns match, an exception named MatchError is thrown.
  *     >>> This means you always have to make sure that all cases are covered, even if it means adding a default case
  *     where there's nothing to do.
  *     e.g;
  *     ``
  *     expr match {
  *       case BinOp(op, left, right) =>
  *         println(expr + " is a binary operation")
  *       case _ =>
  *     }
  *     ``
  *     --> this match expression will return the unit value '()' in all cases.
  *
  *
  * 15.2 KINDS OF PATTERNS
  * @see _17_KindsOfPatterns
  *
  *
  * 15.3 PATTERN GUARDS
  * @see _18_patternGuards
  *
  *
  * 15.4 PATTERN OVERLAPS
  * @see _19_PatternOverlaps
  *
  *
  * 15.5 SEALED CLASSES
  * @see _16_BasicOperationsExample
  *
  *
  * Read 15.8 A LARGER EXAMPLE, from the book.
  */
package object _040_pattern_matching {
}