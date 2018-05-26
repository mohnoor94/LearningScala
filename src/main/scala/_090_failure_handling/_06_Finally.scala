package _090_failure_handling

import java.io.FileReader
import java.net.{MalformedURLException, URL}

object _06_Finally {

  { // Example 1
    val file = new FileReader("input.txt")
    try {
      // Use the file
    } finally {
      file.close() // Be sure to close the file
    }
  }

  /**
    * As with most other Scala control structures, try-catch-finally results in a value.
    */
  def urlFor(path: String): URL =
    try {
      new URL(path)
    } catch {
      case _: MalformedURLException => new URL("http://www.scala-lang.org")
    }


  /**
    * Scala's behavior differs from Java only because Java's try-finally does not result in a value. As in Java, if a
    * finally clause includes an explicit return statement, or throws an exception, that return value or exception will
    * "overrule" any previous one that originated in the try block or one of its catch clauses. For example, given these
    * function definitions (below):
    * -> calling f() results in 2. By contrast,
    * -> calling g() results in 1.
    * Both of these functions exhibit behavior that could surprise most programmers, so it's
    * usually best to avoid returning values from finally clauses. The best way to think of finally clauses is as a way
    * to ensure some side effect happens, such as closing an open file.
    */
  //noinspection RemoveRedundantReturn
  def f(): Int = try return 1 finally return 2

  def g(): Int = try 1 finally 2
}