package _06_pattern_matching

object _15_PartialFunctionsUsingPatternMatching {
  val doubleEvens: PartialFunction[Int, Int] = new PartialFunction[Int, Int]() {
    override def isDefinedAt(x: Int): Boolean = x % 2 == 0

    override def apply(v1: Int): Int = v1 * 2
  }

  // doubleEvens could be written using pattern matching as:
  val doubleEvens2: PartialFunction[Int, Int] = {
    case x: Int if x % 2 == 0 => x * 2
  }

  val tripleOdds: PartialFunction[Int, Int] = new PartialFunction[Int, Int]() {
    override def isDefinedAt(x: Int): Boolean = x % 2 != 0

    override def apply(v1: Int): Int = v1 * 3
  }

  def main(args: Array[String]): Unit = {
    val doubleEvensOrTripleOdds = doubleEvens orElse tripleOdds
    println(s"doubleEvensOrTripleOdds(10): ${doubleEvensOrTripleOdds(10)}")
    println(s"doubleEvensOrTripleOdds(15): ${doubleEvensOrTripleOdds(15)}")
    println

    /*
    * doubleEvensOrTripleOdds can also be trimmed down inline with case statements.
    * Compare the above with the following below:"
    */
    val inlineDoubleEvensOrTripleOdds = (list: List[Int]) =>
      list.map {
        case x: Int if x % 2 == 0 => x * 2
        case y: Int if y % 2 != 0 => y * 3
      }

    println(s"inlineDoubleEvensOrTripleOdds(List(1, 2, 3)) ==> ${inlineDoubleEvensOrTripleOdds(List(1, 2, 3))}")
  }
}