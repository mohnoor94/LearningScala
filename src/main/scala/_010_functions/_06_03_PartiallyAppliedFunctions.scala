package _010_functions

object _06_03_PartiallyAppliedFunctions extends App {

  // curried function;
  // receives multiple parameters lists
  // returns a function
  val superAdder: Int => Int => Int =
  x => y => x + y

  val add3: Int => Int = superAdder(3) // y => y + 3
  println(s"add3(5) => ${add3(5)}")
  println(s"superAdder(3)(5) => ${superAdder(3)(5)}")
  println()

  def curriedAdder(x: Int)(y: Int): Int = x + y // curried method!

  // val add4 = curriedAdder(4) // will not work without type; invalid method call!
  // val add4 = curriedAdder(4) _ // will work; force the compiler to do ETA-expansion for us; details below
  val add4: Int => Int = curriedAdder(4) // will work
  println(s"add4(10) => ${add4(10)}")
  println()

  // this is called lifting or ETA-EXPANSION => transforming a method into a function
  // remember: functions != methods
  // in JVM; a method is a part of an instance of a class / singleton object

  val anotherEtaExpansionExample: Unit = {
    def increment(x: Int) = x + 1

    // when we write
    val a = List(1, 2, 3).map(increment)
    // the compiler will do ETA-expansion of this and convert it to:
    val b = List(1, 2, 3).map(x => increment(x))

    println("anotherEtaExpansionExample")
    println(a)
    println(b)
    println()
  }

  val add7Exercise: Unit = {
    println("add7Exercise")

    val simpleAddFunction = (x: Int, y: Int) => x + y

    def simpleAddMethod(x: Int, y: Int) = x + y

    def curriedAddMethod(x: Int)(y: Int) = x + y

    // implement add7 : Int => Int = y => 7 + y in different ways

    def add7a(x: Int) = simpleAddMethod(x, 7)

    val add7b = simpleAddFunction.curried(7)

    val add7c = curriedAddMethod(7) _ // PAF: PartiallyAppliedFunction
    val add7d = curriedAddMethod(7)(_) // PAF, same as above

    val add7e = simpleAddMethod(_: Int, 7) // rewritten to y => simpleAddFunction(7, y)
    val add7f = simpleAddFunction(_: Int, 7) // rewritten to y => simpleAddFunction(7, y)

    println(s"${add7a(3)} *-* ${add7b(3)} *-* ${add7c(3)} *-* ${add7d(3)} *-* ${add7e(3)} *-* ${add7f(3)}\n")
  }

  // underscores are powerful!
  val underscorePower: Unit = {
    println("underscorePower")

    def concatenatior(a: String, b: String, c: String) = a + b + c

    val greetings = concatenatior("Hello, I'm ", _: String, ", how are you?!") // ETA-expansion by compiler!
    println(greetings("Mohammad"))

    val fillTheBlanks = concatenatior("Hello, ", _: String, _: String) // ETA-expansion by compiler!
    println(fillTheBlanks("I'm ", "Noor"))
  }
}