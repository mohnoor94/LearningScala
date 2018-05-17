package _96_scala_puzzlers

/**
  * Puzzler 2 - UPSTAIRS downstairs
  * What is the result of executing the following code in the REPL?
  *
  * This will not compile since Scala uses pattern matching in the second expression.
  * And, in pattern matching, Scala treats the upper case names as stable identifiers.
  * Stable identifiers are intended for matching against constants.
  *
  * --> Use uppercase variable names only for constants.
  * Do not use var at all as much as you can. Use val.
  */
object _02_UpstairsDownstairs extends App {
  var MONTH = 12; var DAY = 24
  // // this expression will not compile
  //var (HOUR, MINUTE, SECOND) = (12, 0, 0)
  var (hour, minute, second) = (12, 0, 0)
}