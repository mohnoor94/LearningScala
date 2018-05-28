package _040_pattern_matching

import _040_pattern_matching._16_BasicOperationsExample.{BinOp, Expr, Number}

/**
  * Sometimes, syntactic pattern matching is not precise enough. For instance, say you are given the task of formulating
  * a simplification rule that replaces sum expressions with two identical operands, such as e + e, by multiplications
  * of two (e.g., e * 2).
  */
object _18_patternGuards {
  //  def simplifyAdd(e: Expr): Expr = e match {
  //    case BinOp("+", x, x) => BinOp("*", x, Number(2)) // error: x is already defined as value x
  //    case _ => e
  //  }

  /**
    * > This fails because Scala restricts patterns to be linear: a pattern variable may only appear once in a pattern.
    * However, you can re-formulate the match with a pattern guard, as below.
    *
    * > A pattern guard comes after a pattern and starts with an if.
    * >> The guard can be an arbitrary boolean expression, which typically refers to variables in the pattern.
    * >> If a pattern guard is present, the match succeeds only if the guard evaluates to true.
    * >> Hence, the first case above would only match binary operations with two equal operands.
    */
  def simplifyAdd(e: Expr): Expr = e match {
    case BinOp("+", x, y) if x == y =>
      BinOp("*", x, Number(2))
    case _ => e
  }

  /** Some other examples of guarded patterns are: */
  {
    // match only positive integers
    // case n: Int if 0 < n => ...

    // match only strings starting with the letter `a'
    // case s: String if s(0) == 'a' => ...
  }
}