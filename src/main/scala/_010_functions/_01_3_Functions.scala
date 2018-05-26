package _010_functions

/**
  * Functions, and Closures
  *
  * A closure is a function which uses one or more variables declared outside this function.
  * Pure Closure: When the used vars are vals. else it called Impure closure.
  */
object _01_3_Functions {

  var number = 10
  val addClosure1: Int => Int = (x: Int) => x + number
  val addClosure2: Int => Int = (_: Int) => {
    number *= 2
    number
  }

  def main(args: Array[String]): Unit = {
    println(sum(5, 15))
    println(max(5, 15))
    println()

    println(doSomething(5, 15))
    println()

    println(MyMath.add(5, 15))
    println(MyMath.sub(5, 15))
    println(MyMath.mul(5, 15))
    println(MyMath.div(5, 15))
    println()

    println(MyMath.square(5))
    println(MyMath square 5)
    println()

    println(MyMath.add())
    println(MyMath.add(5))
    println(MyMath.add(5, 10))
    println()

    printString(5, "Hello ")
    println("Hello, " * 10)

    println(MyMath.^(10))
    println(MyMath ^ 10)
    println()

    val x = MyMath.add(4, 10)
    println(x)

    println()
    val anonymousAdd = (x: Int, y: Int) => x + y // anonymous function
    println(anonymousAdd(10, 15))
    println()

    // Closures
    println(addClosure1(15))
    number += number * 2
    println(addClosure1(15))
    println()

    println(addClosure2(4))
    println(addClosure2(4))
  }


  def sum(x: Int, y: Int): Int = x + y

  def max(x: Int, y: Int): Int = if (x > y) x else y

  def doSomething(x: Int, y: Int): Int = x + y * 5

  def printString(x: Int, y: String): Unit = {
    println(y * x)
  }
}

object MyMath {
  def add(x: Double = 0, y: Double = 0): Double = x + y

  def sub(x: Double, y: Double): Double = x - y

  def mul(x: Double, y: Double): Double = x * y

  def div(x: Double, y: Double): Double = x / y

  def square(x: Double): Double = x * x

  def ^(x: Double): Double = x * x
}