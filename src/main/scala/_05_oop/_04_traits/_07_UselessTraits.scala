package _05_oop._04_traits

/**
  * Don't use useless traits!
  *
  * Useless trait is a trait that has only 1 method in it,
  * or a one who has only one implementation.
  */
object _07_UselessTraits {

  trait Foo {
    def execute(input: String): String
  }

  def myFunction1(foo: Foo): String = {
    foo.execute("Blah")
  }

  def myFunction2(foo: String => String): String = {
    foo("Blah")
  }

  // Why should you use trait while you only have 1 implementation for it?
  // It's a useless trait!
  trait Foo2 {
    def foo(): String

    def bar(): String
  }

  class Foo2Implementation(fooValue: String, barValue: String) extends Foo2 {
    override def foo(): String = fooValue

    override def bar(): String = barValue
  }

  def myFunction3(foo2: Foo2): String = {
    foo2.foo() + ": " + foo2.bar()
  }


  // While we can rewrite the Foo2 trait and Foo2Implementation class
  // in one class like this?
  // Note: That's apply if we know that there will be no additional
  // implementations for this trait in future.
  class Foo3(fooValue: String, barValue: String) {
    def foo(): String = fooValue

    def bar(): String = barValue
  }

  def myFunction4(foo3: Foo3): String = {
    foo3.foo() + ": " + foo3.bar()
  }

  def main(args: Array[String]): Unit = {
    // Why to do this?
    //noinspection ConvertExpressionToSAM
    println(myFunction1(new Foo {
      override def execute(input: String): String = input.toLowerCase
    }))

    // While you can just use a function?
    println(myFunction2(foo => foo.toLowerCase))

    println

    println(myFunction3(new Foo2Implementation("My Foo", "My Bar")))
    println(myFunction4(new Foo3("My Foo", "My Bar")))
  }
}