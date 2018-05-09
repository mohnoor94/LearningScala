package _06_pattern_matching

object Even {
  def unapply(arg: Int): Option[Int] = arg match {
    case arg: Int if arg % 2 == 0 => Some(arg)
    case _ => None
  }
}

object Odd {
  def unapply(arg: Int): Option[Int] = arg match {
    case arg: Int if arg % 2 != 0 => Some(arg)
    case _ => None
  }
}

object _13_CustomPatternMatching extends App {

  def classify(arg: Any): String = arg match {
    case Even(x) => s"'$x' is an even number"
    case Odd(x) => s"'$x' is an odd number"
    case x@_ => s"'$x' in not an integer"
  }

  println(classify(10))
  println(classify(15))
  println(classify(3.5))
  println(classify("Hello"))
}