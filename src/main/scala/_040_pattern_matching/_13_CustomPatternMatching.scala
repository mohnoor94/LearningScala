package _040_pattern_matching

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
}