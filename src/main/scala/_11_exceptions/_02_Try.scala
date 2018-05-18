package _11_exceptions

import scala.util.Try

/**
  * Try in Scala is like the Option, but the 2 possible values of it will have a payload
  * either a Success with the result, or a Failure with the exception.
  */
object _02_Try extends App {
  val val1 = "123"
  val val2 = "1a2b3"

  val intVal1 = Try { val1.toInt }
  val intVal2 = Try { val2.toInt }

  println(val1 + " ==> " + intVal1)
  println(val2 + " ==> " + intVal2)
//  println(intVal1.get + intVal2.get) // this will throw exception

  println
}