package _980_problem_solving

/**
  * Arrays: Left Rotation
  * For problem description:
  *
  * @see https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
  */
object ArraysLeftRotation {
  def rotateLeft(a: Array[Int], d: Int): Array[Int] = {
    val aLength = a.length
    val b = new Array[Int](aLength)
    for (i <- a.indices) b((aLength - d + i).abs % aLength) = a(i)
    b
  }

  def main(args: Array[String]): Unit = {
    println(rotateLeft(Array(1, 2, 3, 4, 5), 4).mkString(", "))
  }
}