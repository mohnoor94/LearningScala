package _04_collections_with_functions

import scala.language.postfixOps

/**
  * A polynomial can be seen as a map from exponents to coefficients.
  *
  * For instance, x(to power of 3) - 2x + 5
  * can be represented with the map:
  * Map (0 -> 5, 1 -> -2, 3-> 1)
  *
  * Based on this observation, let's design a class Poly, that
  * represents polynomials as maps.
  */
object GeneralExample08_Polynomial extends App {

  class Poly1(val terms: Map[Int, Double]) {
    def +(other: Poly1) = new Poly1(terms ++ (other.terms map adjust))

    def adjust(term: (Int, Double)): (Int, Double) = {
      val (exp, coeff) = term
      terms get exp match {
        case Some(coeff1) => exp -> (coeff + coeff1)
        case None => exp -> coeff
      }
    }

    override def toString: String =
      (for ((exp, coeff) <- terms.toList.sorted.reverse) yield s"${coeff}x^$exp") mkString " + "
  }

  /**
    * Maps are 'partial functions'. Applying a map to a key value
    * in map(key) could lead to an exception, if the key was not
    * stored in the map.
    *
    * There is an operation 'withDefaultValue' that turns a map into
    * a total function.
    */
  class Poly2(val terms0: Map[Int, Double]) {
    // nicer way to receive parameters
    def this(bindings: (Int, Double)*) = this(bindings.toMap)

    val terms: Map[Int, Double] = terms0 withDefaultValue 0

    def +(other: Poly2) = new Poly2(terms ++ (other.terms map adjust))

    def adjust(term: (Int, Double)): (Int, Double) = {
      val (exp, coeff) = term
      exp -> (coeff + terms(exp))
    }

    override def toString: String =
      (for ((exp, coeff) <- terms.toList.sorted.reverse) yield s"${coeff}x^$exp") mkString " + "
  }

  /**
    * Using foldLeft to add terms
    *
    * This solution is more efficient because we immediately add the results
    * to terms value, while in Poly and Poly2 we create a new map
    * with (other.terms map adjust) and add the result to
    * terms using '++' operator.
    */
  class Poly3(val terms0: Map[Int, Double]) {
    def this(bindings: (Int, Double)*) = this(bindings.toMap)

    val terms: Map[Int, Double] = terms0 withDefaultValue 0

    def +(other: Poly3) = new Poly3((other.terms foldLeft terms) (addTerm))

    def addTerm(terms: Map[Int, Double], term: (Int, Double)): Map[Int, Double] = {
      val (exp, coeff) = term
      terms + (exp -> (coeff + terms(exp)))
    }

    override def toString: String =
      (for ((exp, coeff) <- terms.toList.sorted.reverse) yield s"${coeff}x^$exp") mkString " + "
  }

  val p1 = new Poly1(Map(1 -> 2, 3 -> 4, 5 -> 6.2))
  val p2 = new Poly1(Map(0 -> 3, 3 -> 7))
  println(p1 + p2)

  val p3 = new Poly2(1 -> 2, 3 -> 4, 5 -> 6.2)
  val p4 = new Poly2(0 -> 3, 3 -> 7)
  println(p3 + p4)

  val p5 = new Poly3(1 -> 2, 3 -> 4, 5 -> 6.2)
  val p6 = new Poly3(0 -> 3, 3 -> 7)
  println(p5 + p6)
}