package _02_functions

object _02_2_HigherOrderFunctions {

  def math(x: Double, y: Double, f: (Double, Double) => Double): Double = f(x, y)

  def math(x: Double, y: Double, z: Double, f: (Double, Double) => Double): Double = f(f(x, y), z)

  def main(args: Array[String]): Unit = {
    println(s"math(10, 5, (x, y) => x + y) ==> ${math(10, 5, (x, y) => x + y)}")
    println(s"math(10, 5, (x, y) => x - y) ==> ${math(10, 5, (x, y) => x - y)}")
    println(s"math(10, 5, (x, y) => x * y) ==> ${math(10, 5, (x, y) => x * y)}")
    println(s"math(10, 5, (x, y) => x / y) ==> ${math(10, 5, (x, y) => x / y)}")
    println(s"math(10, 5, (x, y) => x max y) ==> ${math(10, 5, (x, y) => x max y)}")
    println(s"math(10, 5, (x, y) => x min y) ==> ${math(10, 5, (x, y) => x min y)}")
    println()

    println(s"math(20, 10, 5, (x, y) => x + y) ==> ${math(20, 10, 5, (x, y) => x + y)}")
    println(s"math(20, 10, 5, (x, y) => x - y) ==> ${math(20, 10, 5, (x, y) => x - y)}")
    println(s"math(20, 10, 5, (x, y) => x * y) ==> ${math(20, 10, 5, (x, y) => x * y)}")
    println(s"math(20, 10, 5, (x, y) => x / y) ==> ${math(20, 10, 5, (x, y) => x / y)}")
    println(s"math(20, 10, 5, (x, y) => x max y) ==> ${math(20, 10, 5, (x, y) => x max y)}")
    println(s"math(20, 10, 5, (x, y) => x min y) ==> ${math(20, 10, 5, (x, y) => x min y)}")
    println()

    // _ (Wild card) => Something!
    println(s"math(10, 5, _ + _) ==> ${math(10, 5, _ + _)}")
    println(s"math(10, 5, _ - _) ==> ${math(10, 5, _ - _)}")
    println(s"math(10, 5, _ * _) ==> ${math(10, 5, _ * _)}")
    println(s"math(10, 5, _ / _) ==> ${math(10, 5, _ / _)}")
    println(s"math(10, 5, _ max _) ==> ${math(10, 5, _ max _)}")
    println(s"math(10, 5, _ min _) ==> ${math(10, 5, _ min _)}")
  }
}