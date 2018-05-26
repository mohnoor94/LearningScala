package _010_functions

object _01_2_Functions extends App {
  //  val f0 = (s: String) => s.length
  val f0: String => Int = _.length
  print("f0(\"Hello\"): ")
  println(f0("Hello"))

  println("======================")

  /*
    * If the type system has enough information either because
    * of the left hand side of an assignment, or a parameter in method, or
    * the way generic types are situated within a class,
    * you can get rid of some additional code. In the following example, you
    * can drop the underline and leave 5+, but will come with some warnings
    * that you can turn off with
    */

  import scala.language.postfixOps

  val plus5: Int => Int = 5 +;
  println(s"plus5(10): ${plus5(10)}")
  println("======================")


  /*
    * A closure is a function that will "wrap" or "close"
    * around an outside value.
    *
    * A closure is a function which uses one or more variables declared outside this function.
    * Pure Closure: When the used vars are vals. else it called Impure closure.
    */
  def createFunction(i: Int): Int => Int = {
    x: Int => x + i
  }

  val function: Int => Int = createFunction(4)

  println(s"function(10): ${function(10)}")

  val function2: Int => Int = createFunction(5)

  println(s"Vector(1, 2, 3).map(function2)) ==> ${Vector(1, 2, 3).map(function2)}")
  println("======================")

  /*
    * Closure have some particular implications. One such implication
    * is called currying. Currying will break a function of one or
    * more arguments into parts so that they can be applied
    * partially
    */
  def foo(f: Int => Int) = f(40)

  val f: (Int, Int, Int) => Int = (x: Int, y: Int, z: Int) => x + y + z
  val fc: Int => Int => Int => Int = f.curried
  val f1: Int => Int => Int = fc(3)
  val f2: Int => Int = f1(4)
  val f3: Int = f2(10)
  println(s"f3: $f3")
  println(s"f2: ${f2(5)}")
  println(s"f1: ${f1(5)(10)}")
  println(s"f: ${fc(5)(10)(20)}")

  val manuallyCurried = (x: Int) => (y: Int) => (z: Int) => x + y + z
  println(s"manuallyCurried(4)(10)(3): ${manuallyCurried(3)(4)(10)}")
  println("======================")

  /*
    * Compose is the equivalent of f(g(x)).  But what this is takes
    * some perspective.  g(x) should be evaluated first and then the
    * result of that (let's call it a) should be applied to f,
    * therefore f(a) to get result b.  But these functions can be
    * applied together to form one cohesive function
    */
  {
    val tupleFirst = (t: (String, Int)) => t._1
    val getFirstThreeLetters = (s: String) => s.substring(0, 3)
    val composedFunction: ((String, Int)) => String =
      getFirstThreeLetters.compose(tupleFirst)

    print("composedFunction(\"Fellow\", 100): ")
    println(composedFunction("Fellow", 100))
    println("======================")
  }
  /*
    * andThen is g(f(x)).  f(x) is applied first and
    * then g is then applied. In the following example we
    * recreate the compose but using andThen
    */
  {
    val tupleFirst = (t: (String, Int)) => t._1
    val getFirstThreeLetters = (s: String) => s.substring(0, 3)
    val andThenFunction = tupleFirst.andThen(getFirstThreeLetters)

    print("andThenFunction(\"Fellow\", 100): ")
    println(andThenFunction("Fellow", 100))
    println("======================")
  }
}