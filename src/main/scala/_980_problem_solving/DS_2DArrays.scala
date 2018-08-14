package _980_problem_solving

/**
  * 2D Array - DS
  * Problem Statement: https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
  */
object DS_2DArrays {

  def hourglassSum(arr: Array[Array[Int]]): Int = {
    (for {
      i <- 1 until arr.length - 1
      j <- 1 until arr(i).length - 1
    } yield arr(i - 1)(j - 1) + arr(i - 1)(j) + arr(i - 1)(j + 1) + arr(i)(j) +
      arr(i + 1)(j - 1) + arr(i + 1)(j) + arr(i + 1)(j + 1)).max
  }

  def main(args: Array[String]): Unit = {
    println(hourglassSum(
      Array(
        Array(1, 1, 1, 0, 0, 0),
        Array(0, 1, 0, 0, 0, 0),
        Array(1, 1, 1, 0, 0, 0),
        Array(0, 0, 2, 4, 4, 0),
        Array(0, 0, 0, 2, 0, 0),
        Array(0, 0, 1, 2, 4, 0))))
  }
}
