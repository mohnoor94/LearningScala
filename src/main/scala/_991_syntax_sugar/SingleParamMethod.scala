package _991_syntax_sugar

import scala.util.Try

object SingleParamMethod extends App {

  println("Method with single param: you can write the param as multi-line code block with { .. }::\n")

  def singleArgMethod(arg: Int): String = s"$arg little ducks..."

  val normalCall = singleArgMethod(10)

  val fancyCall = singleArgMethod { // multi line
    // some complex code
    20
  }

  val aTryInstance = Try { // similar to java's try catch
    throw new RuntimeException
  }

  val ints = List(1, 2, 3).map { x =>
    x + 1
  }

  println(normalCall)
  println(fancyCall)
  println(aTryInstance)
  println(ints)
}
