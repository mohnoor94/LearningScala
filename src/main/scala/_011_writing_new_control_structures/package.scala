/**
  * Chapter 9 - Control Abstraction
  * From: Programming in Scala, Third Edition
  *
  * 9.4 WRITING NEW CONTROL STRUCTURES
  * In languages with first-class functions, you can effectively make new control structures even though the syntax of
  * the language is fixed. All you need to do is create methods that take functions as arguments.
  *
  * Study the examples (01 & 02).
  *
  * 9.5 BY-NAME PARAMETERS
  * The withPrintWriter method shown in the previous section differs from built-in control structures of the language,
  * such as if and while, in that the code between the curly braces takes an argument. The function passed to
  * withPrintWriter requires one argument of type PrintWriter. This argument shows up as the "writer =>".
  * But what if you want to implement something more like if or while, where there is no value to pass into the code
  * between the curly braces? To help with such situations, Scala provides by-name parameters.
  *
  * Study example (03).
  */
package object _011_writing_new_control_structures {
}