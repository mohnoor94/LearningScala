package _011_writing_new_control_structures

import java.io.{File, PrintWriter}

/**
  * Any time you find a control pattern repeated in multiple parts of your code, you should think about implementing it
  * as a new control structure.
  *
  * Consider now a widely used coding pattern: open a resource, operate on it, and then close the resource. You can
  * capture this in a control abstraction using a method like the following:
  */
object _02_WithPrintWriter {
  /**
    * The advantage of using this method is that it's withPrintWriter, not user code, that assures the file is closed
    * at the end. So it's impossible to forget to close the file. This technique is called the loan pattern, because a
    * control-abstraction function, such as withPrintWriter, opens a resource and "loans" it to a function. For instance,
    * withPrintWriter in the previous example loans a PrintWriter to the function, op. When the function completes, it
    * signals that it no longer needs the "borrowed" resource. The resource is then closed in a finally block, to ensure
    * it is indeed closed, regardless of whether the function completes by returning normally or throwing an exception.
    */
  def withPrintWriter_oldSyntax(file: File, op: PrintWriter => Unit): Unit = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  /**
    * One way in which you can make the client code look a bit more like a built-in control structure is to use curly
    * braces instead of parentheses to surround the argument list. In any method invocation in Scala in which you're
    * passing in exactly one argument, you can opt to use curly braces to surround the argument instead of parentheses.
    *
    * The purpose of this ability to substitute curly braces for parentheses for passing in one argument is to enable
    * client programmers to write function literals between curly braces. This can make a method call feel more like a
    * control abstraction. Take the withPrintWriter method defined previously as an example. In its most recent form,
    * withPrintWriter takes two arguments, so you can't use curly braces. Nevertheless, because the function passed to
    * withPrintWriter is the last argument in the list, you can use currying to pull the first argument, the File, into
    * a separate argument list. This will leave the function as the lone parameter of the second argument list.
    * this method shows how you'd need to redefine withPrintWriter.
    */
  def withPrintWriter(file: File)(op: PrintWriter => Unit): Unit = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  def main(args: Array[String]): Unit = {
    // old syntax
    withPrintWriter_oldSyntax(
      new File("date.txt"),
      writer => writer.println(new java.util.Date)
    )

    // new syntax
    val file = new File("date.txt")
    withPrintWriter(file) {
      writer => writer.println(new java.util.Date)
    }
  }
}