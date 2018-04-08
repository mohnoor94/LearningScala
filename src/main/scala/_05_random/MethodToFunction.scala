package _05_random

object MethodToFunction extends App {
  def mulBy3(x: Int) = x * 3

  val f = mulBy3 _

  val list = List(1, 2, 3)

  // you could do...

  println(list.map(_ * 3))
  println(list.map(v => v * 3))
  println(list.map(mulBy3))
  println(list.map(f))

  // a method is attached to a context (belongs to a class)
  // a function is a verb that does something or perform an action
}