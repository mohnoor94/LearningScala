package _011_writing_new_control_structures

/**
  * Implement an assertion construct called myAssert. The myAssert function will take a function value as input and
  * consult a flag to decide what to do. If the flag is set, myAssert will invoke the passed function and verify that
  * it returns true. If the flag is turned off, myAssert will quietly do nothing at all.
  */
object _03_MyAssertAndByNameParams {
  var assertionsEnabled = true

  /**
    * Without using by-name parameters, you could write myAssert like this:
    * ...
    * The definition is fine, but using it is a little bit awkward.
    * ...
    * You would really prefer to leave out the empty parameter list and => symbol in the function literal and write the
    * code like this:
    * myAssert(5 > 3) // Won't work, because missing () =>
    * ...
    */
  def myAssert(predicate: () => Boolean): Unit =
    if (assertionsEnabled && !predicate())
      throw new AssertionError

  /**
    * By-name parameters exist precisely so that you can do this. To make a by-name parameter, you give the parameter a
    * type starting with => instead of () =>. For example, you could change myAssert's predicate parameter into a by-name
    * parameter by changing its type, "() => Boolean", into "=> Boolean".
    * ...
    * Now you can leave out the empty parameter in the property you want to assert. The result is that using byNameAssert
    * looks exactly like using a built-in control structure:
    * ...
    * A by-name type, in which the empty parameter list, (), is left out, is only allowed for parameters. There is no
    * such thing as a by-name variable or a by-name field.
    */
  def byNameAssert(predicate: => Boolean): Unit =
    if (assertionsEnabled && !predicate)
      throw new AssertionError

  /**
    * Now, you may be wondering why you couldn't simply write myAssert using a plain old Boolean for the type of its
    * parameter, like this method.
    * ...
    * This formulation is also legal, of course, and the code using this version of boolAssert would still look exactly
    * as before.
    * ...
    * Nevertheless, one difference exists between these two approaches that is important to note. Because the type of
    * boolAssert's parameter is Boolean, the expression inside the parentheses in boolAssert(5 > 3) is evaluated before
    * the call to boolAssert. The expression 5 > 3 yields true, which is passed to boolAssert. By contrast, because the
    * type of byNameAssert's predicate parameter is => Boolean, the expression inside the parentheses in
    * byNameAssert(5 > 3) is not evaluated before the call to byNameAssert. Instead a function value will be created
    * whose apply method will evaluate 5 > 3, and this function value will be passed to byNameAssert.
    *
    * The difference between the two approaches, therefore, is that if assertions are disabled, you'll see any side
    * effects that the expression inside the parentheses may have in boolAssert, but not in byNameAssert. For example,
    * if assertions are disabled, attempting to assert on "x / 0 == 0" will yield an exception in boolAssert's case:
    * (java.lang.ArithmeticException: / by zero), But attempting to assert on the same code in byNameAssert's case will
    * not yield an exception.
    */
  def boolAssert(predicate: Boolean): Unit =
    if (assertionsEnabled && !predicate)
      throw new AssertionError

  def main(args: Array[String]): Unit = {
    myAssert(() => 5 > 3)

    byNameAssert(5 > 3)

    boolAssert(5 > 3)

    assertionsEnabled = false
    byNameAssert(5 / 0 == 0)
  }
}