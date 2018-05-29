package _020_collections

/**
  * > An array is a java based array with a Scala wrapper around it to perform the functionality.
  * > Arrays allow you to hold a sequence of elements and efficiently access an element at an arbitrary position,
  * either to get or update the element, with a zero-based index.
  */
object _04_Arrays_And_RepeatedParameters extends App {
  val a: Array[Int] = Array(1, 2, 3, 4) // int[1,2,3,4]

  println(s"a.head: ${a.head}")
  println(s"a.tail.toList ==> ${a.tail.toList}")
  println(s"a.init.toList ==> ${a.init.toList}")
  println(s"a.last: ${a.last}")
  println(s"a(2): ${a(2)}")
  println(s"a.max: ${a.max}")
  println(s"a.min: ${a.min}")
  println(s"a.isEmpty: ${a.isEmpty}")
  println(s"a.nonEmpty: ${a.nonEmpty}")
  println(s"a.toList: ${a.toList}")
  println(s"a.reverse.toList: ${a.reverse.toList}")
  println(s"a.getClass.getSimpleName: ${a.getClass.getSimpleName}")

  println("===============")

  val fiveInts = new Array[Int](5)
  fiveInts(2) = 1000
  print("fiveInts.mkString(\", \") ==> ")
  println(fiveInts.mkString(", "))
  println(s"fiveInts(3): ${fiveInts(3)}")

  println("===============")

  def repeatedParameterMethod(x: Int, y: String, z: Any*): String = {
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