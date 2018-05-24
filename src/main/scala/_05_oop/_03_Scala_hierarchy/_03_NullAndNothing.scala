package _05_oop._03_Scala_hierarchy

/**
  * 11.3 BOTTOM TYPES
  * >> At the bottom of the type hierarchy there two classes scala.Null and scala.Nothing. These are special types that
  * handle some "corner cases" of Scala's object-oriented type system in a uniform way.
  * >> Class Null is the type of the null reference; it is a subclass of every reference class (i.e., every class that
  * itself inherits from AnyRef). Null is not compatible with value types. You cannot, for example, assign a null value
  * to an integer variable.
  *
  * >> Type Nothing is at the very bottom of Scala's class hierarchy; it is a subtype of every other type. However, there
  * exist no values of this type whatsoever. Why does it make sense to have a type without values? one use of Nothing is
  * that it signals abnormal termination.
  *
  */
object _03_NullAndNothing {
  /**
    * The return type of error is Nothing, which tells users that the method will not return normally (it throws an
    * exception instead). Because Nothing is a subtype of every other type, you can use methods like error in very
    * flexible ways.
    */
  def error(message: String): Nothing =
    throw new RuntimeException(message)

  /**
    * The "then" branch of the conditional, x / y, has type Int, whereas the else branch, the call to error, has type
    * Nothing. Because Nothing is a subtype of Int, the type of the whole conditional is Int, as required.
    */
  def divide(x: Int, y: Int): Int =
    if (y != 0) x / y
    else error("can't divide by zero")

  def main(args: Array[String]): Unit = {
    println(divide(10, 5))
    println(divide(10, 0))
  }
}