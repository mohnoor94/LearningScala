package _06_pattern_matching

import scala.util.matching.Regex


class AllInt(val f: (Int, Int) => Int) {
  private val regex: Regex = """\d+""".r

  def unapply(s: String): Option[Int] = {
    val items = regex.findAllIn(s)
    if (items.isEmpty) None else {
      Some(items.map(_.toInt).toList.reduce(f))
    }
  }
}

object WordNumbers {
  def unapplySeq(x: String): Option[Seq[String]] = {
    val regex = """\d+""".r
    val items = regex.findAllIn(x)
    if (items.isEmpty) None else Some(items.toSeq)
  }
}

object _14_RegularExpressionPatternMatching extends App {
  println("AllInt Example:")
  /* can also extract from an instance just in case it is the instance that contains logic
  * to extract information, this is the technique used to for regex grouping
  */
  val s = "What is the total of 100, 200, 300, 400?"
  val f = (total: Int, next: Int) => total + next
  val allIntSum = new AllInt(f)
  val sumResult = s match {
    case allIntSum(z) => s"Captured: $z"
    case _ => s"Didn't work"
  }
  println(sumResult)

  println("\n=====================\nWordNumbers Example:")
  /*
  * Custom pattern matching with unapplySeq
  * better than the previous one, I think!
  */
  val WordNumbers(n1) = "That person is 44 years old"
  println(s"n1: $n1")

  val WordNumbers(o1, o2) = "The score in yesterdays game was 100 to 33, it was a blowout!"
  println(s"o1: $o1, o2: $o2")

  val WordNumbers(m1, m2, rest@_*) = "The lottery numbers were 100, 33, 12, 19, 10, 6 it was a blowout!"
  println(s"m1: $m1, m2: $m2, rest: $rest")

  val string = "The lucky numbers are 100, 56, 44, 33, and 220"
  val wordNumberMatchResult = string match {
    case WordNumbers() => "No numbers"
    case WordNumbers(n) => "One number $n"
    case WordNumbers(n1, n2) => "Two numbers: $n1 and $n2"
    case WordNumbers(n1, n2, n3) => "Three numbers: $n1, $n2, $n3"
    case WordNumbers(n1, n2, n3, rest@_*) =>
      s"First three numbers: $n1, $n2, $n3, and the rest is ${rest.mkString(",")}"
  }
  println(wordNumberMatchResult)

  println("\n=====================\nA Regular Pattern Expression Example:")

  val AmericanTelephoneNumberRegex: Regex =
    """1?\s*\((\d{3})\)\s*(\d{3})-(\d{4})""".r
  val UKTelephoneNumberRegex: Regex =
    """\+44\s*(d{2})\s*(d{4})\s*(d{4})""".r

  val telephoneResult = "1(505) 240-3023" match {
    case AmericanTelephoneNumberRegex(ac, pre, suf) =>
      s"American(ac: $ac, pre: $pre, suf: $suf)"
    case UKTelephoneNumberRegex(ac, pre, suf) =>
      s"UK(ac: $ac, pre: $pre, suf: $suf)"
  }

  println(s"telephoneResult ==> $telephoneResult")
}