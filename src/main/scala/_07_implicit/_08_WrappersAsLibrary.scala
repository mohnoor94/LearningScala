package _07_implicit

/**
  * A good idea is to place a implicit inside of an object and use it
  * anywhere in your code base!
  */
object _08_WrappersAsLibrary extends App {

  import AdvancedInt._

  println(s"10.isOdd? ${10.isOdd}")
  println(s"10.isEven? ${10.isEven}")
  println(s"(10 + 6).isEven? ${(10 + 6).isEven}")
}

object AdvancedInt {
  class IntWrapper(x: Int) {
    def isEven: Boolean = x % 2 == 0
    def isOdd: Boolean = !isEven
  }

  implicit val int2IntWrapper: Int => IntWrapper = (x: Int) => new IntWrapper(x)
}