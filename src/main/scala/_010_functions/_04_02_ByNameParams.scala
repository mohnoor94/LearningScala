package _010_functions

object _04_02_ByNameParams extends App {

  def byName(n: => Int) = {
    println("byName called")
    n + 1
  }

  // 0-lambda (HOF)
  def byFunction(f: () => Int) = {
    println("byFunction called")
    f() + 1
  }

  def method: Int = 500

  def parenthesesMethod(): Int = {
    println("parenthesesMethod called")
    5000
  }

  println(s"byName(5) => ${byName(5)}\n\n")
  println(s"byName(method) => ${byName(method)}\n\n") // method will be evaluated to its value

  //noinspection EmptyParenMethodAccessedAsParameterless
  println(s"byName(parenthesesMethod) => ${byName(parenthesesMethod)}\n\n")
  println(s"byName(parenthesesMethod()) => ${byName(parenthesesMethod())}\n\n")

  // byName(() => 50) // not ok
  println("Use lambda and call it:")
  println((() => 50) ()) // ok!
  println("\n")

  // byName(parenthesesMethod _) // not ok

  println("//" * 50)
  println("\n")

  // byFunction(50) // not ok!
  // byFunction(method) // not ok!! no ETA-expansion by compiler for parameterless methods
  println(s"byFunction(parenthesesMethod) => ${byFunction(parenthesesMethod)}\n\n") // ETA-expansion

  //noinspection ConvertibleToMethodValue
  println(s"byFunction(parenthesesMethod _) => ${byFunction(parenthesesMethod _)}\n\n") // ETA-expansion (auto)

  println(s"byFunction(() => 900) => ${byFunction(() => 900)}")
}