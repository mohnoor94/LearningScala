package _02_functions

/**
  * This function 'addMore' adds "more" to its argument, but what is more? From the point of view of this function,
  * more is a free variable because the function literal does not itself give a meaning to it. The x variable, by
  * contrast, is a bound variable because it does have a meaning in the context of the function: it is defined as the
  * function's lone parameter, an Int.
  *
  * The function value (the object) that's created at runtime from this function literal is called a closure. The name
  * arises from the act of "closing" the function literal by "capturing" the bindings of its free variables. A function
  * literal with no free variables, such as (x: Int) => x + 1, is called a closed term, where a term is a bit of source
  * code.
  * Thus a function value created at runtime from this function literal is not a closure in the strictest sense, because
  * (x: Int) => x + 1 is already closed as written. But any function literal with free variables, such as
  * (x: Int) => x + more, is an open term. Therefore, any function value created at runtime from (x: Int) => x + more
  * will, by definition, require that a binding for its free variable, more, be captured. The resulting function value,
  * which will contain a reference to the captured more variable, is called a closure because the function value is the
  * end product of the act of closing the open term, (x: Int) => x + more.
  *
  *
  * What if a closure accesses some variable that has several different copies as the program runs?For example, what if
  * a closure uses a local variable of some function,and the function is invoked many times?  Which instance of that
  * variable gets used at each access?
  * Only one answer is consistent with the rest of the language: the instance used is the one that was active at the
  * time the closure was created.  For example, here is a function that creates and returns "increase" closures: (see
  * 'makeIncreaser' example below). Each time this function is called it will create a new closure. Each closure will
  * access the more variable that was active when the closure was created.
  * When you call makeIncreaser(1), a closure is created and returned that captures the value 1 as the binding for more.
  * Similarly, when you call makeIncreaser(9999), a closure that captures the value 9999 for more is returned. When you
  * apply these closures to arguments (in this case, there's just one argument, x, which must be passed in), the result
  * that comes back depends on how more was defined when the closure was created.
  *
  * @see '_96_scala_puzzlers' -> '_07_CaughtUpInClosures'
  */
object _07_Closures extends App {
  println("Example 1\n===============")
  var more = 1
  val addMore = (x: Int) => x + more
  println(s"addMore(5): ${addMore(5)}")
  more = 10
  println(s"addMore(5): ${addMore(5)}")


  println("Example 2\n===============")
  println(s"more: $more")

  def makeIncreaser(more: Int) = (x: Int) => x + more

  val inc1 = makeIncreaser(1)
  val inc9999 = makeIncreaser(9999)
  println(s"inc1(10): ${inc1(10)}")
  println(s"inc1(100): ${inc1(100)}")
  println(s"inc9999(10): ${inc9999(10)}")
  println(s"inc9999(100): ${inc9999(100)}")
  println()
  println(s"makeIncreaser(10)(20): ${makeIncreaser(10)(20)}")
}