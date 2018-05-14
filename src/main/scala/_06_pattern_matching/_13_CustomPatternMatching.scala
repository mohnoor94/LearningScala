package _06_pattern_matching

import scala.util.matching.Regex

/**
  * Companion objects will generally have the unapply or unapplySeq for classes, this also means
  * that case classes create unapply automatically, but you can create or override your own
  * particular rules!
  */

object Even {
  def unapply(arg: Int): Option[Int] = arg match {
    case arg: Int if arg % 2 == 0 => Some(arg)
    case _ => None
  }
}

object Odd {
  def unapply(arg: Int): Option[Int] = arg match {
    case arg: Int if arg % 2 != 0 => Some(arg)
    case _ => None
  }
}

class Genre private(val name: String)

object Genre {
  //factory methods (apply), unapply, utilities,
  def apply(name: String) = new Genre(name)

  def unapply(arg: Genre): Option[String] = Some(arg.name) // detuppling
}

class Movie private(val title: String, val year: Int, val genre: Genre)

object Movie {
  def apply(title: String, year: Int, genre: Genre) = new Movie(title, year,
    genre)

  def apply(title: String, year: Int) = new Movie(title, year, Genre("N/A"))

  def unapply(arg: Movie): Option[(String, Int, Genre)] = Some(arg.title,
    arg.year, arg.genre)
}

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

object _13_CustomPatternMatching extends App {

  def classify(arg: Any): String = arg match {
    case Even(x) => s"'$x' is an even number"
    case Odd(x) => s"'$x' is an odd number"
    case x@_ => s"'$x' in not an integer"
  }

  println("Even/Odd Example:")
  println(s"classify(10): ${classify(10)}")
  println(s"classify(15): ${classify(15)}")
  println(s"classify(3.5): ${classify(3.5)}")
  print("classify(\"Hello\"): ")
  println(classify("Hello"))

  println("\n=====================\nMovie/Genre Example:")

  val movie = Movie("The Fifth Element", 1998, Genre("Science Fiction"))
  val getGenre = movie match {
    case Movie(_, _, Genre(genreName)) => s"The movie presented is of the '$genreName' genre"
  }
  println(getGenre)

  println("\n=====================\nAllInt Example:")
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
}