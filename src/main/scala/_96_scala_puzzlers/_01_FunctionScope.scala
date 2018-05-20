package _96_scala_puzzlers

/**
  * Puzzler 1 - Hi There!
  * What is the result of executing the following code in the REPL?
  *
  * i => println("Hi"); i + 1
  * means: for every i, print 'Hi' then do the mapping by 'i + 1'
  *
  * println("Hi"); _ + 1
  * means: print 'Hi', then for every _ (member, item) add a 1 (+ 1)
  *
  * --> Scala encourages concise code, but there is such a thing as too much conciseness.
  * When using placeholder syntax, be aware of the scope of the function that is created.
  */
object _01_FunctionScope extends App {
  println(List(1, 2).map { i => println("Hi"); i + 1 })
  println(List(1, 2).map { println("Hi"); _ + 1 })
}