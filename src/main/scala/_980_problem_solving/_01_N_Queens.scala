package _980_problem_solving

import scala.language.postfixOps

/**
  * The eight queens problem is to place eight queens on a
  * chessboard so that no queens is threatened by another.
  *
  * In other words, there can't be two queens in the same row,
  * column, or diagonal.
  *
  * We now develop a solution for a chessboard of any size.
  *
  * One way to solve the problem is to place a queen on each row.
  * Once we have placed k - 1 queens, one must place the kth queen
  * in a column where it's not 'in check' with any other queen
  * on the board.
  *
  * 4-Queens Example (1 possible solution):
  *
  * \\| 0 | 1 | 2 | 3 |
  * --+---+---+---+---+--
  * 0 |   | q |   |   |
  * --+---+---+---+---+--
  * 1 |   |   |   | q |
  * --+---+---+---+---+--
  * 2 | q |   |   |   |
  * --+---+---+---+---+--
  * 3 |   |   | q |   |
  * --+---+---+---+---+--
  *
  * --> List(2,0,3,1) : list of row-position of each queen (reversed).
  */
object _01_N_Queens extends App {
  // Tests
  println(queens(4))
  println((queens(4) map show) mkString "\n")
  println
  println("==========================")
  val queens8 = queens(8)
  println(queens8)
  println(queens8 size)
  println((queens8 take 3 map show) mkString "\n")
  println
  println("==========================")

  // n: # of rows.
  def queens(n: Int): Set[List[Int]] = {
    def placeQueens(k: Int): Set[List[Int]] =
      if (k == 0) Set(List())
      else
        for {
          queens <- placeQueens(k - 1)
          col <- 0 until n
          if isSafe(col, queens)
        } yield col :: queens

    def isSafe(col: Int, queens: List[Int]): Boolean = {
      val row = queens.length
      val queensWithRow = (row - 1 to 0 by -1) zip queens
      queensWithRow forall {
        case (r, c) => col != c && math.abs(col - c) != row - r
      }
    }

    placeQueens(n)
  }

  def show(queens: List[Int]): String = {
    val lines =
      for (col <- queens.reverse)
        yield Vector.fill(queens.length)(" * ").updated(col, " X ").mkString
    "\n" + (lines mkString "\n")
  }


}