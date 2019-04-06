package _040_pattern_matching

object _13_03_CustomPatternMatching extends App {

  val oneWay: Unit = {
    object SingleDigit {
      def unapply(arg: Int): Option[Int] =
        if (0 <= arg && arg < 10) Some(arg)
        else None
    }

    object Even {
      def unapply(arg: Int): Option[Int] =
        if (arg % 2 == 0) Some(arg)
        else None
    }

    //    val classify: Int => String = (n: Int) => n match {
    val classify: Int => String = {
      case SingleDigit(n) => s"A single digit number ($n)"
      case Even(n) => s"An even number ($n)"
      case n => s"Something else ($n)"
    }

    println(classify(8))
    println(classify(16))
    println(classify(25))
  }

  val anotherWay: Unit = {
    object SingleDigit {
      def unapply(arg: Int): Boolean = -10 < arg && arg < 10
    }

    object Even {
      def unapply(arg: Int): Boolean = arg % 2 == 0
    }

    val classify: Int => String = {
      case SingleDigit() => "A single digit number"
      case Even() => "An even number"
      case _ => s"Something else"
    }

    println(classify(8))
    println(classify(16))
    println(classify(25))
  }
}
