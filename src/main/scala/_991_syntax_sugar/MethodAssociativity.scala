package _991_syntax_sugar

object MethodAssociativity extends App {

  // Scala spec: last char decides associativity of method
  // - if it ends with a colon (:) ==> it is right associative
  // - if it is not ==> it is left associative (normal method behaviour)!

  val prependedList = 2 :: List(3, 4) // (List(3,4)).::2
  println(prependedList)

  println(1 :: 2 :: 3 :: List(4, 5)) // List(4,5).::(3).::(2).::(1)

  // example
  class MyStream[T] {
    def -->:(value: T): MyStream[T] = this // actual implementation here
  }

  val myStream: MyStream[Int] = 1 -->: 2 -->: 3 -->: new MyStream[Int] // wow
}
