package _040_pattern_matching

object PatternMatching2 extends App {
  println(Number2(10).show())
  println(Sum2(Number2(10), Number2(20)).show())
  println(Sum2(Prod2(Number2(2), Var2("x")), Var2("y")).show())
  println(Prod2(Sum2(Number2(2), Var2("x")), Var2("y")).show())
}

trait Expr2 {
  def show(): String = this match {
    case Prod2(e1: Sum2, e2) => "(" + e1.show() + ") * " + e2.show()
    case Sum2(l, r) => l.show + " + " + r.show
    case Prod2(l, r) => l.show + " * " + r.show
    case Var2(x) => x
    case Number2(x) => x.toString
  }
}

case class Number2(n: Int) extends Expr2

case class Sum2(e1: Expr2, e2: Expr2) extends Expr2

case class Prod2(e1: Expr2, e2: Expr2) extends Expr2

case class Var2(n: String) extends Expr2

