package _040_pattern_matching

import _040_pattern_matching._16_BasicOperationsExample.{BinOp, Expr, Number, UnOp}

/**
  * > To apply the matching more than once, we use recursion.
  * > It is important that the catch-all cases come after the more specific simplification rules.
  * >> If you wrote them in the other order, then the catch-all case would be run in favor of the more specific rules.
  * >> In many cases, the compiler will even complain if you try (warning: unreachable code).
  */
object _19_PatternOverlaps {
  def simplifyAll(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) =>
      simplifyAll(e) // `-' is its own inverse
    case BinOp("+", e, Number(0)) =>
      simplifyAll(e) // `0' is a neutral element for `+'
    case BinOp("*", e, Number(1)) =>
      simplifyAll(e) // `1' is a neutral element for `*'
    case UnOp(op, e) =>
      UnOp(op, simplifyAll(e))
    case BinOp(op, l, r) =>
      BinOp(op, simplifyAll(l), simplifyAll(r))
    case _ => expr
  }
}