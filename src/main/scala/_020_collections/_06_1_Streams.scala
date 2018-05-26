package _020_collections

/**
  * Streams are similar to lists, but their tail is evaluated only on
  * demand.
  *
  * Comparing the Two Range Functions (List VS Stream)
  * The functions have almost identical structure yet they evaluate
  * quite differently.
  * ▶ listRange(start, end) will produce a list with end - start
  * elements and return it.
  * ▶ streamRange(start, end) returns a single object of type Stream
  * with start as head element.
  * ▶ The other elements are only computed when they are needed,
  * where “needed” means that someone calls tail on the stream.
  *
  * Streams uses the ideas of lazy vals and by-name parameters (=>).
  *
  * The one major exception (between lists and streams) is ::
  * x :: xs always produces a list, never a stream.
  * There is however an alternative operator #:: which produces a stream.
  * x #:: xs == Stream.cons(x, xs)
  * #:: can be used in expressions as well as patterns
  */
object _06_1_Streams extends App {
  val s1 = Stream(1, 2, 3, 4, 5)
  println(s"s1= $s1")

  val s2 = (1 to 1000).toStream
  println(s"s2= $s2")

  val s3 = 10 #:: s1
  println(s"s3= $s3")
  println

  val l1 = s1.toList
  println(s"l1= $l1")
  println(s"s1= $s1")
  println

  val l2 = s2.take(10).toList
  println(s"l2= $l2")
  println(s"s2= $s2")
  println

  val l3 = s3.take(2).toList
  println(s"l3= $l3")
  println(s"s3= $s3")
  println
}