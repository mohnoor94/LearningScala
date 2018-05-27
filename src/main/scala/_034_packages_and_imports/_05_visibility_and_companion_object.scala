package _034_packages_and_imports

/**
  * > In Java, static members and instance members belong to the same class, so access modifiers apply uniformly to them.
  * > You have already seen that in Scala there are no static members; instead you can have a companion object that
  * contains members that exist only once.
  * > Scala's access rules privilege companion objects and classes when it comes to private or protected accesses.
  * > A class shares all its access rights with its companion object and vice versa.
  * > In particular, an object can access all private members of its companion class, just as a class can access all
  * private members of its companion object.
  *
  * > One exception where the similarity between Scala and Java breaks down concerns protected static members.
  * >> A protected static member of a Java class C can be accessed in all subclasses of C.
  * >> By contrast, a protected member in a companion object makes no sense, as singleton objects don't have any
  * subclasses.
  */
class _05_visibility_and_companion_object {

  class Rocket {

    import Rocket.fuel

    // Rocket class can access method fuel, which is declared private in object Rocket.
    private def canGoHomeAgain = fuel > 20
  }

  object Rocket {
    private def fuel = 10

    def chooseStrategy(rocket: Rocket): Unit = {
      // Rocket object can access the private method canGoHomeAgain in class Rocket.
      if (rocket.canGoHomeAgain)
        goHome()
      else
        pickAStar()
    }

    def goHome(): Unit = {}

    def pickAStar(): Unit = {}
  }

}