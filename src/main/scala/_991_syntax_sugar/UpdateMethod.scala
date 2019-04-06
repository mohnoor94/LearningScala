package _991_syntax_sugar

/**
  * In Scala, calls to update can be written as assignments.
  * For instance, for an array arr
  * arr(i) = 0
  * is translated to
  * arr.update(i, 0)
  * which calls an update method which can be thought of as follows:
  * class Array[T] {
  * def update(idx: Int, value: T): Unit
  * ...
  * }
  *
  * Generally, an indexed assignment like f(E1, ..., En) = E
  * is translated to f.update (E1, ..., En , E).
  * This works also if n = 0: f () = E is shorthand for f.update(E).
  * Hence,
  * for sig, a val from any class that have an update() method:
  * sig.update(5)
  * can be abbreviated to
  * sig() = 5
  */
object UpdateMethod extends App {
  val a = Array(5, 10, 15)
  println(s"a= ${a.toList}")
  // when we write:
  a(1) = 100
  println(s"after (a(1) = 100), a= ${a.toList}")
  // this is translated to:
  a.update(1, 100)
  println(s"after (a.update(1, 100)), a= ${a.toList}")

  // because Scala compiler translates () to update()

  // Custom Example
  class UpdateExample(var value: Int) {
    var moreValues = List(1, 2, 3, 4, 5)

    def update(value: Int): Unit = {
      println("*** 'update(value: Int)' has been called ***")
      this.value = value
    }

    def update(index: Int, value: Int): Unit = {
      println("*** 'update(index: Int, value: Int)' has been called ***")
      moreValues = moreValues.updated(index, value)
    }
  }

  val x = new UpdateExample(5)
  println("\n\nCustom Example:")
  println(s"x.value= ${x.value}")
  x() = 10
  println(s"x.value (after x() = 10)= ${x.value}")
  println
  println(s"x.moreValues= ${x.moreValues}")
  x(1) = 500
  println(s"x.moreValues (after x(1, 500))= ${x.moreValues}")
}
