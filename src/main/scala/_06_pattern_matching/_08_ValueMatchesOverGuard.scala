package _06_pattern_matching

/**
  * Use pattern matching over values as much as you can
  * ... unless you need to use a guard :)
  */
object _08_ValueMatchesOverGuard {

  case class Foo(field1: Int, field2: String)

  def myFunction1(input: Foo): Boolean = input match {
    // This is a general guard
    case Foo(f1, f2) if f1 == 0 && f2 == "" => true
    case _ => false
  }

  def myFunction2(input: Foo): Boolean = input match {
    case Foo(0, "") => true
    case _ => false
  }

  def myFunction3(input: Foo): Boolean = input match {
    // f2 using a guard, because we want to play with it =)
    case Foo(0, f2) if f2.trim.isEmpty => true
    case _ => false
  }

  def myFunction4(input: Foo): Boolean = input match {
    // first parameter has to be 0 or 2
    case Foo(0 | 2, "") => true
    case _ => false
  }

  val acceptableWords = List("", "undefined", "null", "blank")
  def myFunction5(input: Foo): Boolean = input match {
    case Foo(0, f2) if acceptableWords.contains(f2) => true
    case _ => false
  }

  def main(args: Array[String]): Unit = {
    println(myFunction1(Foo(0, "")))
    println
    println(myFunction2(Foo(0, "")))
    println(myFunction2(Foo(0, "             ")))
    println
    println(myFunction3(Foo(0, "")))
    println(myFunction3(Foo(0, "             ")))
    println
    println(myFunction4(Foo(0, "")))
    println(myFunction4(Foo(2, "")))
    println
    println(myFunction5(Foo(0, "")))
    println(myFunction5(Foo(0, "blank")))
    println(myFunction5(Foo(0, "other")))
  }
}