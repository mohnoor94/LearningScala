package _032_scala_hierarchy

object _02_AnyRefExamples extends App {
  /* The equality operation == in Scala is designed to be transparent with respect to the type's representation. For
   * value types, it is the natural (numeric or boolean) equality. For reference types other than Java's boxed numeric
   * types, == is treated as an alias of the equals method inherited from Object. That method is originally defined as
   * reference equality, but is overridden by many subclasses to implement their natural notion of equality. This also
   * means that in Scala you never fall into Java's well-known trap concerning string comparisons. In Scala, string
   * comparison works as it should ( == is same as 'equals' in Java).
   */
  val x = "abcd".substring(2)
  val y = "abcd".substring(2)
  println(s"x: $x")
  println(s"y: $y")
  println(s"x == y ==> ${x == y}")
  println()

  /* However, there are situations where you need reference equality instead of user-defined equality. For example, in
   * some situations where efficiency is paramount, you would like to hash cons with some classes and compare their
   * instances with reference equality. For these cases, class AnyRef defines an additional eq method, which cannot be
   * overridden and is implemented as reference equality (i.e., it behaves like == in Java for reference types).
   * There's also the negation of eq, which is called ne.
   * ▶ You hash cons instances of a class by caching all instances you have created in a weak collection. Then, any time
   * you want a new instance of the class, you first check the cache. If the cache already has an element equal to the
   * one you are about to create, you can reuse the existing instance. As a result of this arrangement, any two
   * instances that are equal with equals() are also equal with reference equality.
   */
  val x2 = new String("abc")
  val y2 = new String("abc")
  println(s"x2 == y2 ==> ${x2 == y2}")
  println(s"x2 eq y2 ==> ${x2 eq y2}")
  println(s"x2 ne y2 ==> ${x2 ne y2}")
  println()

}