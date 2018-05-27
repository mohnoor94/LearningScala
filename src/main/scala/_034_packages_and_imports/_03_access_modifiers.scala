package _034_packages_and_imports

/**
  * > Members of packages, classes, or objects can be labeled with the access modifiers private and protected.
  * > These modifiers restrict access to the members to certain regions of code.
  * > Scala's treatment of access modifiers roughly follows Java's but there are some important differences.
  *
  * --> look at 'Private members' section below.
  * --> look at 'Protected members' section below.
  *
  * Public members
  * > Scala has no explicit modifier for public members: Any member not labeled private or protected is public.
  * > Public members can be accessed from anywhere.
  */
object _03_access_modifiers {

  /**
    * Private members
    * > Private members in Scala are treated similarly to Java. A member labeled private is visible only inside the class
    * or object that contains the member definition.
    * > In Scala, this rule applies also for inner classes. This treatment is more consistent, but differs from Java.
    * > In Scala, the access (new Inner).f() is illegal because f is declared private in Inner and the access is not
    * from within class Inner. By contrast, the first access to f in class InnerMost is OK, because that access is
    * contained in the body of class Inner.
    * > Java would permit both accesses because it lets an outer class access private members of its inner classes.
    */
  class Outer {
    class Inner {
      private def f(): Unit = { println("f") }
      class InnerMost {
        f() // OK
      }
    }
      // (new Inner).f() // error: f is not accessible
  }


  /**
    * Protected members
    * > Access to protected members in Scala is also a bit more restrictive than in Java.
    * > In Scala, a protected member is only accessible from subclasses of the class in which the member is defined.
    * > In Java such accesses are also possible from other classes in the same package.
    *
    * - In example below, the access to f in class Sub is OK because f is declared protected in Super and Sub is a
    * subclass of Super. By contrast the access to f in Other is not permitted, because Other does not inherit from Super.
    * n Java, the latter access would be still permitted because Other is in the same package as Sub.
    */
  {
    class Super {
      protected def f() = {
        println("f")
      }
    }

    class Sub extends Super {
      f()
    }

    class Other {
      // (new Super).f() // error: f is not accessible
    }
  }
}