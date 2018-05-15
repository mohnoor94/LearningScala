package _07_implicit

import scala.language.implicitConversions

/**
  * 'implicit' can be used for something like what Ruby has called
  * monkey patching or Groovy calls mopping where we can add functionality to
  * a class that we don't have access to, like isOdd/isEven
  * in the Int class. This is what we call implicit wrappers.
  * we can use a conversion method or a function for that!
  */
object _07_WrappersUsingImplicits {
  class IntWrapper(x: Int) {
    def isEven: Boolean = x % 2 == 0
    def isOdd: Boolean = !isEven
  }

  //  implicit def int2IntWrapper(x:Int):IntWrapper = new IntWrapper(x)
  implicit val int2IntWrapper: Int => IntWrapper = (x: Int) => new IntWrapper(x)

  def main(args: Array[String]): Unit = {
    println(s"10.isOdd? ${10.isOdd}")
    println(s"10.isEven? ${10.isEven}")
    println(s"(10 + 6).isEven? ${(10 + 6).isEven}")
  }
}