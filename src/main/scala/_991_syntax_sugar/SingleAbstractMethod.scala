package _991_syntax_sugar

object SingleAbstractMethod extends App {

  println("Single abstract method: Implement it with a lambda::\n")

  trait Action {
    def act(x: Int): Int
  }

  val anInstance1: Action = new Action { // normal way with anonymous class definition
    override def act(x: Int): Int = x + 1
  }

  val anInstance2: Action = (x: Int) => x + 1 // compiler magic

  println(anInstance1.act(10))
  println(anInstance2.act(10))

  // example:
  val aThread = new Thread(() => println("hello, Scala! <== I'm out of sync!"))
  aThread.start()

  // we can use it if we have multiple members/methods implemented but only one unimplemented method
  abstract class AnAbstractType {
    def implemented: Int = 100

    def f(a: Int): Unit // abstract
  }

  val anAbstractInstance: AnAbstractType = (a: Int) => println("Sweet! " * a)
  anAbstractInstance.f(3)
}
