package _980_problem_solving

import java.io.PrintWriter

/**
  * Arrays: Left Rotation
  * For problem description:
  *
  * @see https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
  */
object ArraysLeftRotation {
  def rotLeft(a: Array[Int], d: Int): Array[Int] = {
    val aLength = a.length
    val b = new Array[Int](aLength)
    for (i <- a.indices) b((aLength - d + i).abs % aLength) = a(i)
    b
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
//    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
    val nd = stdin.readLine.split(" ")
    val n = nd(0).trim.toInt
    val d = nd(1).trim.toInt
    val a = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = rotLeft(a, d)
//    printWriter.println(result.mkString(" "))
    println(result.mkString(" "))
//    printWriter.close()
  }
}