package _020_collections

/**
  * One other sequence to be aware of is StringOps, which implements many sequence methods. Because Predef has an
  * implicit conversion from String to StringOps, you can treat any string like a sequence.
  */
object _11_StringOps extends App {
  /**
    * > In this example, the exists method is invoked on the string named s in the hasUpperCase method body.
    * > Because no method named "exists" is declared in class String itself, the Scala compiler will implicitly convert
    * s to StringOps, which has the method.
    * > The exists method treats the string as a sequence of characters, and will return true if any of the characters
    * are upper case.
    */
  def hasUpperCase(s: String): Boolean = s.exists(_.isUpper)

  println(hasUpperCase("Robert Frost"))
  println(hasUpperCase("e e cummings"))
}