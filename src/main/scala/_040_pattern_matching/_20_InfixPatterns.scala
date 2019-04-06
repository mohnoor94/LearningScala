package _040_pattern_matching

object _20_InfixPatterns extends App {

  // only works when you have only 2 things in the pattern

  case class Or[A, B](a: A, b: B) // Either

  val either = Or(2, "two")

  val humanDescription: String = either match {
    case number Or string => s"$number is written as $string" // (Or (number, string)
  }

  println(humanDescription)
}
