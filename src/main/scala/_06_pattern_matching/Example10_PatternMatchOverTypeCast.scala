package _06_pattern_matching

/**
  * PatternMatching is way better than type checking and type casting.
  * So, if you need to type cast, it should be done in pattern matching!
  */
object Example10_PatternMatchOverTypeCast {

  def myFunction1(input: Any): String = {
    input.asInstanceOf[String]
  }

  //noinspection TypeCheckCanBeMatch
  def myFunction2(input: Any): Option[String] = {
    if (input.isInstanceOf[String])
      Some(input.asInstanceOf[String])
    else None
  }

  def myFunction3(input: Any): Option[String] = input match {
    case str: String => Some(str)
    case _ => None
  }

  def main(args: Array[String]): Unit = {
    println(myFunction1("foo"))
    println

//    try {
//      println(myFunction1(2))
//    } catch {
//      case e: Throwable => e.printStackTrace()
//    }
//    println

    println(myFunction2("foo"))
    println(myFunction2(2))
    println

    println(myFunction3("foo"))
    println(myFunction3(2))
    println
  }
}