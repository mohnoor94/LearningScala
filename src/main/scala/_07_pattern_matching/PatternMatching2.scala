package _07_pattern_matching

object PatternMatching2 extends App {
  println(Number2(10).show())
  println(Sum2(Number2(10), Number2(20)).show())
}

trait Expr2 {
  def show(): String = this match {
    // TODO implement this and support parentheses
    case _ => throw new UnsupportedOperationException("Not implemented yet!")
  }
}

case class Number2(n: Int) extends Expr2

case class Sum2(e1: Expr2, e2: Expr2) extends Expr2

case class Prod2(e1: Expr2, e2: Expr2) extends Expr2

case class Var2(n: String) extends Expr2

