package _96_scala_puzzlers

/**
  * Puzzler 3 - Location, Location, Location
  * What is the result of executing the following code?
  *
  * In the first expression, once we create a BMember object, it
  * will at first execute the A trait, which will execute the
  * 'println("Hello " + audience)' statement, here we did not override the
  * value of audience yet, so it will print audience as null.
  * While in the second expression we immediately override the audience with
  * 'Readers', then executes what's inside A and continue...
  *
  * --> We execute anything inside the constructor, then all super traits and
  * classes from left to right as they inserted.
  */
object _03_LocationMatters {

  trait A {
    val audience: String
    println("Hello " + audience)
  }

  class BMember(a: String = "World") extends A {
    val audience: String = a
    println("I repeat: Hello " + audience)
  }

  class BConstructor(val audience: String = "World") extends A {
    println("I repeat: Hello " + audience)
  }

  def main(args: Array[String]): Unit = {
    new BMember("Readers")
    new BConstructor("Readers")
    println("\n===== Possible Solution =====\n")
    new PossibleSolution.BMember("Readers")
    new PossibleSolution.BConstructor("Readers")
  }

  object PossibleSolution {

    trait A {
      val audience: String
      println("Hello " + audience)
    }

    class BMember(a: String = "World") extends {
      val audience: String = a
    } with A {
      println("I repeat: Hello " + audience)
    }

    class BConstructor(val audience: String = "World") extends A {
      println("I repeat: Hello " + audience)
    }

    def main(args: Array[String]): Unit = {
      new BMember("Readers")
      new BConstructor("Readers")
    }
  }

}