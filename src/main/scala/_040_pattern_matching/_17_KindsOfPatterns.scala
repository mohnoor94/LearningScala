package _040_pattern_matching

import _040_pattern_matching._16_BasicOperationsExample.{BinOp, Expr, Number, UnOp}

//noinspection ScalaUnusedSymbol
object _17_KindsOfPatterns extends App {
  /**
    * 1> Wildcard patterns (_)
    * >> The wildcard pattern (_) matches any object whatsoever.
    */
  val wildCardPattern = (expr: Expr) => expr match {
    case BinOp(op, left, right) =>
      println(expr + " is a binary operation")
    case _ => // handle the default case
  }

  /**
    * 2> Constant patterns (A constant pattern matches only itself)
    * >> e,g:  5, true, "hello", and Nil (for an empty list)...
    */
  def describe(x: Any) = x match {
    case 5 => "five"
    case true => "truth"
    case "hello" => "hi!"
    case Nil => "the empty list"
    case _ => "something else"
  }

  /**
    * 3> Variable patterns
    * >> A variable pattern matches any object, just like a wildcard.
    * >> But unlike a wildcard, Scala binds the variable to whatever the object is.
    * >> You can then use this variable to act on the object further.
    */
  val variablePattern = (expr: Int) => expr match {
    case 0 => "zero"
    case somethingElse => "not zero: " + somethingElse
  }


  /**
    * -> Variable or constant?
    * --> Scala uses a simple lexical rule for disambiguation:
    * --> a simple name starting with a lowercase letter is taken to be a pattern variable;
    * --> all other references are taken to be constants.
    * --> You can still use a lowercase name for a pattern constant, if you need to, by using one of two tricks.
    * e,g: `pi`
    *
    * -> As you can see, the back-tick syntax for identifiers is used for two different purposes in Scala to help you
    * code your way out of unusual circumstances.
    * --> Here you see that it can be used to treat a lowercase identifier as a constant in a pattern match.
    * --> Earlier on, you saw that it can also be used to treat a keyword as an ordinary identifier, e.g., writing
    * Thread.`yield`() treats yield as an identifier rather than a keyword.
    */
  {
    import math.{E, Pi}
    println {
      E match {
        case Pi => "strange math? Pi = " + Pi
        case _ => "OK"
      }
    }

    val pi = math.Pi
    println {
      E match {
        case pi2 => "strange math? Pi = " + pi2
        // case _ => "OK" // warning: unreachable code
      }
    }

    println {
      E match {
        case `pi` => "strange math? Pi = " + pi
        case _ => "OK"
      }
    }
  }

  /**
    * 4> Constructor patterns
    * >> Assuming the name designates a case class, such a pattern means to first check that the object is a member of
    * the named case class, and then to check that the constructor parameters of the object match the extra patterns
    * supplied.
    */
  val constructorPattern = (expr: Expr) => expr match {
    case BinOp("+", e, Number(0)) => println("a deep match")
    case _ =>
  }

  /**
    * 5> Sequence patterns
    * >> You can match against sequence types, like List or Array, just like you match against case classes.
    * >> Use the same syntax, but now you can specify any number of elements within the pattern.
    * >> If you want to match against a sequence without specifying how long it can be, you can specify _* as the last
    * element of the pattern.
    * >>> This funny-looking pattern matches any number of elements within a sequence, including zero elements.
    */
  {
    val sequencePattern1 = (list: List[_]) => list match {
      case List(0, _, _) => println("found it")
      case _ =>
    }

    val sequencePattern2 = (list: List[_]) => list match {
      case List(0, _*) => println("found it")
      case _ =>
    }
  }

  /**
    * 6> Tuple patterns
    * >> You can match against tuples too.
    * >> A pattern like (a, b, c) matches an arbitrary 3-tuple.
    */
  def tupleDemo(expr: Any): Unit =
    expr match {
      case (a, b, c) => println("matched " + a + b + c)
      case _ =>
    }

  /**
    * 7> Typed patterns
    * >> You can use a typed pattern as a convenient replacement for type tests and type casts.
    * >> An equivalent but more long-winded way that achieves the effect of a match against a typed pattern employs a
    * type test followed by a type cast.
    * >>> using if,  expr.isInstanceOf[String], and  expr.asInstanceOf[String]
    * >> As you will have noted by now, writing type tests and casts is rather verbose in Scala.
    * >>> That's intentional because it is not encouraged practice.
    * >>> You are usually better off using a pattern match with a typed pattern.
    * >>> That's particularly true if you need to do both a type test and a type cast, because both operations are then
    * rolled into a single pattern match.
    *
    * Note: there is a 'size' method for String in Scala as well, but take the following as an example.
    */
  def generalSize(x: Any): Int = x match {
    case s: String => s.length
    case m: Map[_, _] => m.size
    case _ => -1
  }

  /**
    * Type erasure
    * > Can you also test for a map with specific element types?
    * >> This would be handy, say, for testing whether a given value is a map from type Int to type Int. Let's try:
    *
    * > Scala uses the erasure model of generics, just like Java does.
    * >> This means that no information about type arguments is maintained at runtime.
    * >> Consequently, there is no way to determine at runtime whether a given Map object has been created with two
    * Int arguments, rather than with arguments of different types.
    * >> All the system can do is determine that a value is a Map of some arbitrary type parameters.
    *
    * > The only exception to the erasure rule is arrays,
    * >> because they are handled specially in Java as well as in Scala.
    * >>The element type of an array is stored with the array value, so you can pattern match on it.
    */
  {
    def isIntIntMap(x: Any): Boolean = x match {
      case m: Map[Int, Int] => true // warning: non-variable type argument Int in type
      case _ => false
    }

    def isStringArray(x: Any): String = x match {
      case a: Array[String] => "yes"
      case _ => "no"
    }
  }


  /**
    * Variable binding
    * > In addition to the standalone variable patterns, you can also add a variable to any other pattern.
    * >> You simply write the variable name, an at sign (@), and then the pattern.
    * >> This gives you a variable-binding pattern, which means the pattern is to perform the pattern match as normal,
    * >> and if the pattern succeeds, set the variable to the matched object just as with a simple variable pattern.
    *
    * > the example below shows a pattern match that looks for the absolute value operation being applied twice in a row.
    * >> Such an expression can be simplified to only take the absolute value one time.
    */
  val simplifyAbs = (expr: Expr) => expr match {
    case UnOp("abs", e@UnOp("abs", _)) => e
    case _ =>
  }
}