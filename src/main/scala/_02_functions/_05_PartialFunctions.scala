package _02_functions

/**
  * Partial Function...
  * ...is like a function, but with an added method called isDefined.
  * isDefined() returns true or false, it also has an `apply` method to
  * invoke the function if isDefined returns true.
  * Partial Functions together should form a complete
  * function.
  *
  * @see '_06_pattern_matching' => '_15_PartialFunctionsUsingPatternMatching'
  *      for more examples!
  */
object _05_PartialFunctions extends App {
  // function
  val f: String => String = {
    case "ping" => "pong"
    // we can add a default value here (case _)
  }

  println("f(\"ping\"): " + f("ping"))
  //  println(f("test")) // will give an error because f is not defined at 'test'


  // using partial functions, we can test if a function is defined
  // at some point (value)

  val f2: PartialFunction[String, String] = {
    case "ping" => "pong"
  }
  println
  println("f2(\"ping\"):" + f2("ping"))

  if (f2.isDefinedAt("test")) println(f2("test"))
  else println("f2 not defined at 'test'")

  // Map in Scala is a partial function
  val map = Map(1 -> 2, 2 -> 4, 4 -> 8)
  println
  println("map(1): " + map(1))

  if (map.isDefinedAt(5)) println(map(5))
  else println("map is not defined at '5'")

  // remember that you can convert a map to a full function using 'withDefaultValue'
  val fullMap = map withDefaultValue (-1)

  println
  println("fullMap(1): " + fullMap(1))
  println("fullMap(5): " + fullMap(5))


  // isDefinedAt does not always guarantee that the function will be defined at
  // a given point. For example with nested pattern matching!

  val g: PartialFunction[List[Int], String] = {
    case Nil => "one"
    case x :: rest =>
      rest match {
        case Nil => "two"
      }
  }

  val l = List(1, 2, 3)
  println
  println(g.isDefinedAt(l))
  //  println(g(l)) // while isDefinedAt gave us true, this will give matchError exception...
}