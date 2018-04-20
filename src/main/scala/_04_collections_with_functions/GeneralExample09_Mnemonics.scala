package _04_collections_with_functions

import scala.io.Source
import scala.language.postfixOps

/**
  * Phone keys have mnemonics assigned to them.
  * '2' -> "ABC",
  * '3' -> "DEF",
  * '4' -> "GHI",
  * '5' -> "JKL",
  * '6' -> "MNO",
  * '7' -> "PQRS",
  * '8' -> "TUV",
  * '9' -> "WXYZ"
  *
  * Assume you are given a dictionary words as a list of words.
  * Design a method translate such that:
  * translate(phoneNumber)
  * produces all phrases of words that can serve as mnemonics
  * for the phone number.
  *
  * Example:
  * The phone number "7225247386" should have the mnemonic
  * 'Scala is fun' as one element of solution phrases.
  *
  * This example was taken from:
  * Lutz Prechelt: An Empirical Comparison of Seven Programming
  * Languages. IEEE Computer 33(10): 23-29 (2000)
  *
  * Tested with Tcl, Python, Perl, Rexx, Java, C++, C.
  *
  * Code size medians:
  * 100 LoC (Line of Code) for scripting languages
  * 200-300 LoC for the others
  *
  * Let's try Scala =)
  */
object GeneralExample09_Mnemonics extends App {
  val in = Source.fromURL("https://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt/")
  // toList, so we can use our functions on it.
  // filter (...) to include only all-letters words.
  val words = in.getLines.toList filter (word => word forall (chr => chr.isLetter))

  val mnemonics = Map(
    '2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
    '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ"
  )

  /**
    * Inverts the mnemonics map to give a map from chars 'A'..'Z' to '2'..'9'
    */
  val charCode: Map[Char, Char] =
    for ((digit, str) <- mnemonics;
         ltr <- str) yield ltr -> digit

  /**
    * Maps a word to the digit string it can represent, e.g. "Java" -> "5282"
    */
  def wordCode(word: String): String = word.toUpperCase map charCode

  /**
    * A map from digit strings to the words that represent them,
    * e.g. "5282" -> List("Java", "Kata", "Lava", ...)
    * Note: A missing number should map to the empty set,
    * e.g. "1111" -> List()
    */
  val wordsForNum: Map[String, Seq[String]] =
    words groupBy wordCode withDefaultValue Seq()

  /**
    * Returns all ways to encode a number as a list of words
    */
  def encode(number: String): Set[List[String]] =
    if (number.isEmpty) Set(List())
    else {
      for {
        split <- 1 to number.length
        word <- wordsForNum(number take split)
        rest <- encode(number drop split)
      } yield word :: rest
    }.toSet

  def translate(number: String): Set[String] =
    encode(number) map (_ mkString " ")

  // testing
  println(translate("7225247386"))
  println(translate("72252"))
  println(translate("783364"))
}