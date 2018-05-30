package _980_problem_solving

/**
  * Strings: Making Anagrams
  * For problem description:
  * @see https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
  */
object MakingAnagrams {
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val a = stdin.readLine
    val b = stdin.readLine

    println(a.length + b.length - 2 * a.intersect(b).length)
  }
}