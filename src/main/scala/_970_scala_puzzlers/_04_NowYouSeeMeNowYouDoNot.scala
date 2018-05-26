package _970_scala_puzzlers

/**
  * Puzzler 4 - Now You See Me, Now You Don't
  * What will this code print?
  *
  * Strange?
  * What happen here is because any val can be initialized only once,
  * and since 'bar' overridden in class C, it will read as its the default
  * value (default value of any Int is 0) at any point before class C!
  */
object _04_NowYouSeeMeNowYouDoNot {

  trait A {
    val foo: Int
    val bar = 10
    println("In A ==> foo: " + foo + ", bar: " + bar)
  }

  class B extends A {
    val foo: Int = 25
    println("In B ==> foo: " + foo + ", bar: " + bar)
  }

  class C extends B {
    override val bar = 99
    println("In C ==> foo: " + foo + ", bar: " + bar)
  }

  def main(args: Array[String]): Unit = {
    new C
    println("\n===== Methods Solution =====\n")
    new MethodSolution.C
    println("\n===== Lazy Vals Solution =====\n")
    new LazyValSolution.C
    println("\n===== Pre-Initialized Fields Solution =====\n")
    new PreInitializedFieldSolution.C
  }

  // Solutions!

  /**
    * One drawback of using methods is that they are evaluated upon each and every invocation.
    * Also, Scala conforms to the Uniform Access Principle,[4] so defining a parameterless method
    * in the superclass does not prevent it from being overridden as a val in a subclass,
    * which would cause the puzzling behavior to reappear, ruining all the careful planning.
    */
  object MethodSolution {

    trait A {
      val foo: Int

      def bar: Int = 10

      println("In A ==> foo: " + foo + ", bar: " + bar)
    }

    class B extends A {
      val foo: Int = 25
      println("In B ==> foo: " + foo + ", bar: " + bar)
    }

    class C extends B {
      override def bar: Int = 99

      println("In C ==> foo: " + foo + ", bar: " + bar)
    }

  }

  /**
    * Note that lazy vals are typically used to defer expensive initializations to the last possible moment
    * (sometimes they may never be initialized). That is not the goal here: in this case, lazy vals are used
    * to ensure the proper order of initialization at runtime.
    *
    * Be aware, however, that lazy vals can have some disadvantages:
    * ▶ They incur a slight performance cost, due to synchronization that happens under the hood.
    * ▶ You cannot declare an abstract lazy val.
    * ▶ Using lazy vals is prone to creating cyclic references that can result in stack overflow errors
    * on first access, or possibly even deadlock.
    * ▶ You can even get a deadlock when a cyclic dependency does not exist between lazy vals,
    * but between objects that declare them. Such scenarios can be very subtle and non-obvious.
    */
  object LazyValSolution {

    trait A {
      val foo: Int
      lazy val bar = 10
      println("In A ==> foo: " + foo + ", bar: " + bar)
    }

    class B extends A {
      val foo: Int = 25
      println("In B ==> foo: " + foo + ", bar: " + bar)
    }

    class C extends B {
      override lazy val bar = 99
      println("In C ==> foo: " + foo + ", bar: " + bar)
    }

  }

  /**
    * The only difference between this and the original program is that bar is initialized in the early
    * field definition clause of class C. An early field definition clause is the code within curly braces
    * immediately following the extends keyword. It is the part of a subclass that is intended to run
    * before its superclass constructor. By doing that, you make sure bar is initialized before trait A is constructed.
    */
  object PreInitializedFieldSolution {

    trait A {
      val foo: Int
      val bar = 10
      println("In A ==> foo: " + foo + ", bar: " + bar)
    }

    class B extends A {
      val foo: Int = 25
      println("In B ==> foo: " + foo + ", bar: " + bar)
    }

    class C extends {
      override val bar = 99
    } with B {
      println("In C ==> foo: " + foo + ", bar: " + bar)
    }

  }

}