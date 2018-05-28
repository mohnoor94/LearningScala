package _040_pattern_matching

/**
  * 15.1 A SIMPLE EXAMPLE
  * ....
  *
  * 15.5 SEALED CLASSES
  * > Whenever you write a pattern match, you need to make sure you have covered all of the possible cases.
  * >> Sometimes you can do this by adding a default case at the end of the match,
  * >> but that only applies if there is a sensible default behavior.
  * >> What do you do if there is no default? How can you ever feel safe that you covered all the cases?
  *
  * > You can enlist the help of the Scala compiler in detecting missing combinations of patterns in a match expression.
  * >> To do this, the compiler needs to be able to tell which are the possible cases.
  * >> In general, this is impossible in Scala because new case classes can be defined at any time and in arbitrary
  * compilation units.
  *
  * > The alternative is to make the superclass of your case classes sealed.
  * >> A sealed class cannot have any new subclasses added except the ones in the same file.
  * >> This is very useful for pattern matching because it means you only need to worry about the subclasses you already
  * know about.
  * >> What's more, you get better compiler support as well. If you match against case classes that inherit from a
  * sealed class, the compiler will flag missing combinations of patterns with a warning message.
  *
  * > If you write a hierarchy of classes intended to be pattern matched, you should consider sealing them.
  */
object _16_BasicOperationsExample {
  sealed abstract class Expr
  case class Var(name: String) extends Expr
  case class Number(num: Double) extends Expr
  case class UnOp(operator: String, arg: Expr) extends Expr
  case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

  def simplifyTop(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e))  => e   // Double negation
    case BinOp("+", e, Number(0)) => e   // Adding zero
    case BinOp("*", e, Number(1)) => e   // Multiplying by one
    case _ => expr
  }

  /**
    * This will give a warning:
    * warning: match is not exhaustive!
    * missing combination           UnOp
    * missing combination          BinOp
    */
  def describe1(e: Expr): String = e match {
    case Number(_) => "a number"
    case Var(_) => "a variable"
  }

  /**
    * > If you are sure that you won't use this method unless with Number and Var,
    * you may add a default cases for others...
    * > That works, but it is not ideal. You will probably not be very happy that you were forced to add code that will
    * never be executed (or so you think), just to make the compiler shut up.
    */
  def describe2(e: Expr): String = e match {
    case Number(_) => "a number"
    case Var(_) => "a variable"
    case _ => throw new RuntimeException // Should not happen
  }

  /**
    * > A more lightweight alternative is to add an @unchecked annotation to the selector expression of the match.
    */
  def describe3(e: Expr): String = (e: @unchecked) match {
    case Number(_) => "a number"
    case Var(_) => "a variable"
  }
}