package _040_pattern_matching

/**
  * - In FP, we prefer Options of None over nulls.
  * - Think of Option as a list, but it only has 1 thing.
  * - Prefer to Map/Filter over an Option rather than Pattern Matching
  * --> This allow us to do whatever we want to do with the Option then
  * return the Option to the user so he can determine the default value
  * or do whatever he want with it (as we did in myFunction5). Also
  * we can do any processing we want, and that will be called only if
  * there something in there (not None).
  * --> Using PatternMatching we have to determine what the default
  * value is (we wrapped it in None on myFunction4 as example).
  */
object _09_FilteringMappingOverOptions {

  def myFunction1(input: Option[String]): Boolean = {
    input.exists(in => in.trim.isEmpty)
  }

  def myFunction2(input: Option[String]): Option[Int] = input match {
    case Some(in) if !in.trim.isEmpty => Some(in.length)
    case _ => None
  }

  def myFunction3(input: Option[String]): Option[Int] = {
    // map will be evaluated if there is something there (Some not None)
    input.filter(_.nonEmpty).map(_.length)
  }

  def myFunction4(input: Option[String]): Option[String] = input match {
    case Some(in) => Some(in.toLowerCase)
    case _ => None
  }

  def myFunction5(input: Option[String]): Option[String] = {
    input.map(_.toLowerCase)
  }

  def main(args: Array[String]): Unit = {
    println(myFunction1(Some("")))
    println(myFunction1(Some("Foo")))
    println(myFunction1(None))
    println
    println(myFunction2(Some("")))
    println(myFunction2(Some("Foo")))
    println(myFunction2(None))
    println
    println(myFunction3(Some("")))
    println(myFunction3(Some("Foo")))
    println(myFunction3(None))
    println
    println(myFunction4(Some("Hello World!")))
    println(myFunction4(None))
    println
    println(myFunction5(Some("Hello World!")))
    println(myFunction5(None))
  }
}