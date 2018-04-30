package _03_collections

/**
                        Iterable
             _____________|______________
             |            |             |
            Seq          Set           Map
      _______|_____________________
     |               |            |
    List           Vector       Range

 String and Array support the same operations as Seq and can
 implicitly be converted to sequences where needed,
 but they cannot be subclasses of Seq because they come from Java.

 @see https://docs.scala-lang.org/tutorials/FAQ/collections.html
       for full details
 */
object _04_Arrays_And_RepeatedParameters extends App {
  val a: Array[Int] = Array(1, 2, 3, 4) // int[1,2,3,4]

  println(a.head)
  println(a.tail)
  println(a.init)
  println(a.last)
  println(a(2))
  println(a.max)
  println(a.min)
  println(a.isEmpty)
  println(a.nonEmpty)

  println("===============")

  def repeatedParameterMethod(x: Int, y: String, z: Any*) = {
    println(z)
    "%d %ss give you %s".format(x, y, z.mkString(", "))
  }

  println(repeatedParameterMethod(3, "egg", "a delicious sandwich", "protein", "high cholesterol"))
  println
  println(repeatedParameterMethod(3, "egg", List("a delicious sandwich", "protein", "high cholesterol")))
  println
  println(repeatedParameterMethod(3, "egg", List("a delicious sandwich", "protein", "high cholesterol"): _*))
  println
}
