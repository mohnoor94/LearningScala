package _02_functions

/**
  * Currying is the technique of transforming a function that takes multiple arguments
  * into a function that take a single argument
  */
object _03_Currying extends App {
  {
    println("First Example:")
    val g = (x: Int) => (y: Int) => x + y
    val f = (x: Int, y: Int) => x + y

    val fc = f.curried // = g

    val f2 = Function.uncurried(fc) // = f

    println(g(4)(5))
    println(f(4, 5))
    println(fc(4)(5))
    println(f2(4, 5))
  }

  println("=========================")

  {
    println("Second Example:")
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

  println("=========================")

  {
    println("Third Example:")

    def add(x: Int, y: Int): Int = x + y

    // Currying Function | Better
    def add2(x: Int): Int => Int = (y: Int) => x + y

    // Simpler way, but you have to provide _ when currying
    def add3(x: Int)(y: Int): Int = x + y

    println(add(10, 20))

    println(add2(10)(20))

    // Currying
    val sum40 = add2(40)
    println(sum40(30))

    println(add3(10)(20))

    val sum50 = add3(50) _
    println(sum50(100))
  }
}