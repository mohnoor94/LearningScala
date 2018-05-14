package _02_functions

import java.util.Date

/**
  * Partially Applied Function
  */
object _06_PartiallyAppliedFunction {

  def log(date: Date, message: String): Unit = {
    println(s"$date --> $message")
  }

  def main(args: Array[String]): Unit = {
    // Fully Applied Function
    val sum = (a: Int, b: Int, c: Int) => a + b + c
    println(s"sum(1, 2, 3): ${sum(1, 2, 3)}")
    println

    // Partially Applied Function!
    val f1 = sum(_: Int, 10, 20)
    val f2 = sum(10, _: Int, 20)
    val f3 = sum(10, 20, _: Int)
    val f4 = sum(10, _: Int, _: Int)
    val f5 = sum(_: Int, _: Int, 10)

    println(s"f1(30): ${f1(30)}")
    println(s"f2(30): ${f2(30)}")
    println(s"f3(30): ${f3(30)}")
    println(s"f4(30): ${f4(30, 40)}")
    println(s"f5(30): ${f5(30, 40)}")
    println

    val date = new Date()
    val newLog = log(date, _: String)

    newLog("Hi")
    newLog("Hello")
  }
}