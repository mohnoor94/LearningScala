package _970_scala_puzzlers

/**
  * Puzzler 6 - Arg Arrgh!
  * What is the result of executing the following code?
  *
  *
  * The error message implies that the compiler is not looking for implicit evidence of type Numeric[Double],
  * as you might expect, but for a Numeric[N]...
  *
  * Isn't N bound to Double by the use of 2.0 as the first argument, though? Yes, it is, but the key point here is
  * that this does not help the compiler. The compiler attempts to satisfy the type requirements for each parameter
  * in a parameter list individually, and is therefore not able to use information about a generic type provided by
  * other arguments in the same parameter list.
  * In this case, the fact that the generic type N is bound to a specific type, Double, is not available when the
  * compiler searches for the appropriate numericOps. This is true even though the parameter that binds N appears
  * before nextNumber in the parameter list!
  * In the curried case, on the other hand, N has been bound to Double as part of the evaluation of the previous
  * parameter list, as opposed to an earlier parameter in the same list.
  * Because the compiler knows that N is bound to Double when nextNumber is processed, it can find the appropriate
  * implicit Numeric[Double] value in scope, allowing this variant to execute successfully.
  *
  * Incidentally, this "type information propagation" is one of the reasons why so many of Scala's standard
  * functions have curried definitions.
  *
  * --> Information about a type parameter is available only to subsequent parameter lists in a curried invocation,
  * not to other parameters in the same list. When defining methods with parameters whose type constraints can only
  * be satisfied if the type bindings for earlier parameters of the same method are known, use curried method
  * definitions rather than single parameter lists.
  */
object _06_TypeInformationPropagation {
  def applyNMulti[T](n: Int)(arg: T, f: T => T): T =
    (1 to n).foldLeft(arg) { (acc, _) => f(acc) }

  def applyNCurried[T](n: Int)(arg: T)(f: T => T): T =
    (1 to n).foldLeft(arg) { (acc, _) => f(acc) }

  def nextInt(n: Int): Int = n * n + 1

  //  val nextInt: Int => Int = (n: Int) => n * n + 1

  def nextNumber[N](n: N)(implicit numericOps: Numeric[N]): N =
    numericOps.plus(numericOps.times(n, n), numericOps.one)

  def main(args: Array[String]): Unit = {
    println(applyNMulti(3)(2, nextInt))
    println(applyNCurried(3)(2)(nextInt))
//    println(applyNMulti(3)(2.0, nextNumber)) // will throw an exception
    println(applyNCurried(3)(2.0)(nextNumber))
  }
}