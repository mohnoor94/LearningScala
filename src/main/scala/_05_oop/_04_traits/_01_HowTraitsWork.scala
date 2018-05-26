package _05_oop._04_traits

object _01_HowTraitsWork {

  /**
    * This trait is named Philosophical. It does not declare a superclass, so like a class, it has the default
    * superclass of AnyRef.
    *
    *
    * > At this point you might philosophize that traits are like Java interfaces with concrete methods, but they can
    * actually do much more. Traits can, for example, declare fields and maintain state. In fact, you can do anything in
    * a trait definition that you can do in a class definition, and the syntax looks exactly the same, with only two
    * exceptions:
    * - First, a trait cannot have any "class" parameters (i.e., parameters passed to the primary constructor of a class).
    * - The other difference between classes and traits is that whereas in classes, super calls are statically bound, in
    * traits, they are dynamically bound. If you write "super.toString" in a class, you know exactly which method
    * implementation will be invoked. When you write the same thing in a trait, however, the method implementation to
    * invoke for the super call is undefined when you define the trait. Rather, the implementation to invoke will be
    * determined anew each time the trait is mixed into a concrete class. This curious behavior of super is key to
    * allowing traits to work as stackable modifications.
    */
  trait Philosophical {
    def philosophize(): Unit = {
      println("I consume memory, therefore I am!")
    }
  }

  class Animal

  trait HasLegs

  /**
    * > Once a trait is defined, it can be mixed in to a class using either the extends or with keywords.
    * >  Scala programmers "mix in" traits rather than inherit from them, because mixing in a trait has important
    * differences from the multiple inheritance found in many other languages.
    * > You can use the extends keyword to mix in a trait; in that case you implicitly inherit the trait's superclass.
    */
  class Frog extends Animal with Philosophical with HasLegs {
    override def toString = "green"

    override def philosophize(): Unit = {
      println("It ain't easy being " + toString + "!")
    }
  }

  def main(args: Array[String]): Unit = {
    val frog = new Frog
    frog.philosophize()

    val philosophical1: Philosophical = frog
    philosophical1.philosophize()

    val philosophical2 = new Philosophical {}
    philosophical2.philosophize()
  }
}