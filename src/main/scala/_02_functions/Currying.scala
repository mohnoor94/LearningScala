package _02_functions

object Currying extends App {
  //  val g = (x: Int) => (y: Int) => x + y
  //  val f = (x: Int, y: Int) => x + y
  //
  //  val fc = f.curried // = g
  //
  //  val f2 = Function.uncurried(fc) // = f
  //
  //  println(g(4)(5))
  //  println(f(4, 5))
  //  println(fc(4)(5))
  //  println(f2(4, 5))


  // Curry Parameters

  def foo(x: Int, y: Int, z: Int): Int = x + y + z

  def bar(x: Int)(y: Int)(z: Int): Int = x + y + z

  def baz(x: Int, y: Int)(z: Int): Int = x + y + z


  val f3 = foo _ // => function3
  val f1 = bar _ // => function1
  val f2 = baz _ // => function2

  val g1 = foo(5, _: Int, _: Int)
  val g2 = bar(5) _


  println(g1(10, 15))
  println(g2(10)(15))

}
