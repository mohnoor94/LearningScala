package _039_oop_more

/**
  * Here, we invoke static methods (inside companion objects).
  * This case, we do not need to create an instance of that class
  * to test the functionality implemented inside the companion
  * object. This a static method that belongs to the type (class)
  * level, not for every individual object. Use it when you need it,
  * it's may a personal preference.
  */
object _02_InstanceMethodsInvokeStatic {

  class Foo(barVariable: Option[String]) {
    def convert(in: String): String = in.toLowerCase

    def bar(): String = convert(barVariable.getOrElse("default"))
  }

  class Foo2(barVariable: Option[String]) {
    def bar(): String = Foo2.convert(barVariable.getOrElse("default"))
  }

  // Companion object for Foo2 class
  object Foo2 {
    def convert(in: String): String = in.toLowerCase
  }

  def main(args: Array[String]): Unit = {
    println(new Foo(Some("TEST")).bar())
    println(new Foo2(Some("TEST")).bar())
  }
}