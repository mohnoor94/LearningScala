package _04_collections_with_functions

import scala.language.postfixOps

object GeneralExample04_ScalarProduct extends App {
  /*
   * Compute scalar product of 2 vectors
   */
  def scalarProduct1(xs: Vector[Double], ys: Vector[Double]): Double =
    (xs zip ys).map(xy => xy._1 * xy._2).sum

  def scalarProduct2(xs: Vector[Double], ys: Vector[Double]): Double =
    (xs zip ys).map { case (x, y) => x * y }.sum


  println(scalarProduct1(Vector(2.5, 3.5, 4.5), Vector(5.6, 6, 9)))
  println(scalarProduct2(Vector(2.5, 3.5, 4.5), Vector(5.6, 6, 9)))
}