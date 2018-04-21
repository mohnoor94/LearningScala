package _05_oop

/**
  * We prefer mixing over deep inheritance.
  *
  * Deep Inheritance: is where you have trait that extends a trait
  * that extends a trait... They become difficult to follow and
  * a lot complicated the further down they go.
  *
  * Mixing is to declare multiple traits and use what you want using
  * 'with' keyword when declaring new classes or even in the fly!
  */
object MixinsOverInheritance {

  // Deep Inheritance (StringContainer, Countable, and LowerCaseable)
  trait StringContainer {
    def string(): String
  }

  trait Countable extends StringContainer {
    def count(): Int
  }

  trait LowerCaseable extends Countable {
    def lowerCased(): String
  }

  class MyStringContainer(val string: String) extends LowerCaseable {
    val count: Int = string.length
    val lowerCased: String = string.toLowerCase
  }

  def myFunction(in: Countable) = {
    println(in.count())
    println(in.string())
  }

  trait StringContainer2 {
    def string(): String
  }

  trait Countable2 {
    def count(): Int
  }

  trait LowerCaseable2 {
    def lowerCased(): String
  }

  // Mixing traits when defining new classes
  class MyStringContainer2(val string: String) extends StringContainer2 with LowerCaseable2 {
    val lowerCased: String = string.toLowerCase
  }

  def myFunction2(in: LowerCaseable2): Unit = {
    println(in.lowerCased())
  }

  class MyListContainer[A](list: List[A]) extends Countable2 {
    val count: Int = list.length
  }

  def myFunction3(in: Countable2): Unit = {
    println(in.count())
  }

  // Lengthed represents any type that have a method length that returns Int!
  type Lengthed = {def length: Int}

  trait Countable3 {
    protected def value: Lengthed

    // reflective call!
    def count: Int = value.length
  }

  class MyLengthedContainer(val value: Lengthed)

  def myFunction4(in: Countable3): Unit = {
    println(in.count)
  }

  def main(args: Array[String]): Unit = {
    myFunction(new MyStringContainer("This is a TEST"))
    myFunction2(new MyStringContainer2("This is a TEST"))
    myFunction3(new MyListContainer(List(1, 2, 3, 4, 5)))

    // and... we can mix traits on the fly! without a need to construct new class
    // but directly when creating a new instance (object)... this is 'dynamic mixing'
    // just WoW!
    myFunction4(new MyLengthedContainer(List(1, 2, 3, 4, 5)) with Countable3)
    myFunction4(new MyLengthedContainer("This is another test") with Countable3)

    //     this is invalid because Int does not have the method length inside
    //     so that it cannot be of type 'Lengthed'
    ////    myFunction4(new MyLengthedContainer(25) with Countable3)
  }
}