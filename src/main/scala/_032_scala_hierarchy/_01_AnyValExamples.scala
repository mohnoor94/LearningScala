package _032_scala_hierarchy

object _01_AnyValExamples extends App {
  /* The value classes support the usual arithmetic and boolean operators as methods. For instance, Int has methods
   * named + and *, and Boolean has methods named || and &&. Value classes also inherit all methods from class Any.
   */
  println(s"42.toString: ${42.toString}")
  println(s"42.hashCode: ${42.hashCode}")
  println(s"42.##: ${42.##}")
  println(s"42 equals 42 ==> ${42 equals 42}")
  println(s"42 == 42 ==> ${42 == 42}")
  println(s"42 != 42 ==> ${42 != 42}")
  println()

  /* Note that the value class space is flat; all value classes are subtypes of scala.AnyVal, but they do not subclass
   * each other. Instead there are implicit conversions between different value class types. For example, an instance
   * of class scala.Int is automatically widened (by an implicit conversion) to an instance of class scala.Long when
   * required. Implicit conversions are also used to add more functionality to value types. For instance, the type Int
   * supports all of the operations below.
   * Here's how this works: The methods min, max, until, to, and abs are all defined in a class scala.runtime.RichInt,
   * and there is an implicit conversion from class Int to RichInt. The conversion is applied whenever a method is
   * invoked on an Int that is undefined in Int but defined in RichInt. Similar "booster classes" and implicit
   * conversions exist for the other value classes.
   */
  println(s"42 max 43 ==> ${42 max 43}")
  println(s"42 min 43 ==> ${42 min 43}")
  println(s"1 until 5 ==. ${1 until 5}")
  println(s"1 to 5 ==> ${1 to 5}")
  println(s"1.abs ==> ${1.abs}")
  println(s"-3.abs ==> ${-3.abs}")
  println()
}