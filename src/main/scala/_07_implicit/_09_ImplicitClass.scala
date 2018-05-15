package _07_implicit

/**
  * 'implicit' can be use a short hand version of this called implicit classes,
  * before using them there are some rules:
  *   1. They can only be used inside of an object/trait/class
  *   2. They can only take one parameter in the constructor
  *   3. There can not be any colliding method name as that
  * with the implicit outer scope
  *
  *
  * 'implicit' is done automatically in Scala because what is inside of
  * scala.Predef, for example, it explains how be can set a
  * scala.Float, and there is java.lang.Float, java primitive float.
  * We can investigate this by looking at the documentation.
  */
object _09_ImplicitClass {
  implicit class IntWrapper(x: Int) {
    def isEven: Boolean = x % 2 == 0
    def isOdd: Boolean = !isEven
  }

  def main(args: Array[String]): Unit = {
    println(s"25.isOdd? ${25.isOdd}")
    println
    println("Some other interesting stuffs done using implicits (scala.Predef._):")
    println(s"-10.abs: ${-10.abs}")
    println(s"5.toLong: ${5.toLong}")
    println(s"1 to 10 ==> ${1 to 10}")
    println(s"1 max 10: ${1 max 10}")
    print("1 -> \"One\" ==> ")
    println(1 -> "One")
  }
}