package _96_scala_puzzlers

import scala.collection.mutable

/**
  * Puzzler 7 - Caught Up in Closures
  * What is the result of executing the following code?
  *
  * variables data, i, and j are no longer in scope when the functions are invoked.
  * Before examining which differences between i and j result in the observed behavior, it is helpful to look at how
  * Scala enables the function body to access these variables at all.
  * Scala allows the body of a function to reference variables that are not explicit function parameters, but are in
  * scope at the moment the function is constructed. To access these free variables when the function is invoked in
  * a different scope, Scala "closes over" them to create a closure.
  * Closing over a free variable is not taking a "snapshot" of the variable's value when it is used. Instead, a field
  * referencing the captured variable is added to the function object. Crucially for this case, while captured vals are
  * simply represented by the value, capturing a var results in a reference to the var itself.
  *
  * From here, the explanation for the observed behavior is straightforward: when each accessors1 function is created,
  * it captures the current value of i, and so prints the expected results when invoked. The accessors2 functions, on
  * the other hand, each capture a reference to a mutable IntRef object containing the value of j, which can change
  * over time.
  * By the time the first accessors2 function is invoked, the value of j is already 3. Since data only has three
  * elements, invoking data(j) triggers an IndexOutOfBoundsException.
  *
  * Solutions:
  * The most robust way to prevent this problem is to avoid vars, which is also better Scala style.
  * If you can't avoid a var, but you still want a closure to capture its value at the time the closure is created,
  * you can "freeze" the var by assigning its value to a temporary val. look for this 'Solution' below.
  *
  * --> Avoid capturing free variables in your closures that refer to anything mutable—vars or mutable objects. If you
  * need to close over anything mutable, extract a stable value and assign it to a val, then use that val in your function.
  */
object _07_CaughtUpInClosures {
  val accessors1: mutable.Buffer[() => Int] = mutable.Buffer.empty[() => Int]
  val accessors2: mutable.Buffer[() => Int] = mutable.Buffer.empty[() => Int]

  val data = Seq(100, 110, 120)
  var j = 0
  for (i <- data.indices) {
    accessors1 += (() => data(i))
    accessors2 += (() => data(j))
    j += 1
  }

  def main(args: Array[String]): Unit = {
    accessors1.foreach(a1 => println(a1()))
    //    accessors2.foreach(a2 => println(a2())) // throws java.lang.IndexOutOfBoundsException: 3
    println("\n===== Solution =====\n")
    Solution.accessors1.foreach(a1 => println(a1()))
    Solution.accessors2.foreach(a2 => println(a2()))
  }

  object Solution {
    val accessors1: mutable.Buffer[() => Int] = mutable.Buffer.empty[() => Int]
    val accessors2: mutable.Buffer[() => Int] = mutable.Buffer.empty[() => Int]

    val data = Seq(100, 110, 120)
    var j = 0
    for (i <- data.indices) {
      val currentJ = j
      accessors1 += (() => data(i))
      accessors2 += (() => data(currentJ))
      j += 1
    }
  }

}