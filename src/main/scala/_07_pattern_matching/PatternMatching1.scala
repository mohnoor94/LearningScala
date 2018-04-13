package _07_pattern_matching

object PatternMatching1 extends App {
  println(Number1(10).show())
  println(Sum1(Number1(10), Number1(20)).show())
}

trait Expr1 {
  def show(): String = this match {
    case Number1(x) => x.toString
    case Sum1(l, r) => l.show + " + " + r.show
  }
}

case class Number1(n: Int) extends Expr1

case class Sum1(e1: Expr1, e2: Expr1) extends Expr1