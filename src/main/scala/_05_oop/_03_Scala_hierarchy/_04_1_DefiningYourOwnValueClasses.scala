package _05_oop._03_Scala_hierarchy

/**
  * You can define your own value classes to augment the ones that are built in. Like the built-in value classes, an
  * instance of your value class will usually compile to Java bytecode that does not use the wrapper class. In contexts
  * where a wrapper is needed, such as with generic code, the value will get boxed and unboxed automatically.
  *
  * Only certain classes can be made into value classes. For a class to be a value class:
  * ▶ it must have exactly one parameter, and
  * ▶ it must have nothing inside it except defs. Furthermore,
  * ▶ no other class can extend a value class, and
  * ▶ a value class cannot redefine equals or hashCode.
  *
  * >> To define a value class, make it a subclass of AnyVal, and put val before the one parameter. Here is an example
  * value class: (Dollars, below).
  * >> In this example, money refers to an instance of the value class. It is of type Dollars in Scala source code, but
  * the compiled Java bytecode will use type Int directly.
  * This example defines a toString method, and the compiler figures out when to use it. That's why printing money gives
  * $1000, with a dollar sign, but printing money.amount gives 1000
  * >> You can even define multiple value types that are all backed by the same Int value. For example: (SwissFrancs,
  * below).
  * >> Even though both Dollars and SwissFrancs are represented as integers, it works fine to use them in the same scope.
  */
object _04_1_DefiningYourOwnValueClasses {
  class Dollars(val amount: Int) extends AnyVal {
    override def toString: String = "$" + amount
  }

  class SwissFrancs(val amount: Int) extends AnyVal {
    override def toString: String = amount + " CHF"
  }

  def main(args: Array[String]): Unit = {
    val dollars = new Dollars(1000)
    val francs = new SwissFrancs(1000)
    println(s"dollars: $dollars")
    println(s"dollars.amount: ${dollars.amount}")
    println()
    println(s"francs: $francs")
    println(s"francs.amount: ${francs.amount}")
    println()
  }
}