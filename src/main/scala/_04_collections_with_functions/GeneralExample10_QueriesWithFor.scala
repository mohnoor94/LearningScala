package _04_collections_with_functions

case class Book(title: String, authors: List[String])

object GeneralExample10_QueriesWithFor {
  val books: Set[Book] = Set(
    Book(title = "Structure and Interpretation of Computer Programs",
      authors = List("Abelson, Harald", "Sussman, Gerald J.")),
    Book(title = "Introduction to Functional Programming",
      authors = List("Bird, Richard", "Wadler, Phil")),
    Book(title = "Effective Java",
      authors = List("Bloch, Joshua")),
    Book(title = "Effective Java 2",
      authors = List("Bloch, Joshua")),
    Book(title = "Java Puzzlers",
      authors = List("Bloch, Joshua", "Gafter, Neal")),
    Book(title = "Programming in Scala",
      authors = List("Odersky, Martin", "Spoon, Lex", "Venners, Bill")))


  def main(args: Array[String]): Unit = {
    // To find the titles of books whose author’s name is “Bird”:
    val birdsBooks = for (b <- books; a <- b.authors if a startsWith "Bird,")
      yield b.title

    // To find all the books which have the word “Program” in the title:
    val programBooks = for (b <- books if b.title contains "Program")
      yield b.title

    // To find the names of all authors who have written at least two
    // books present in the database:
    val authorsWithAtLeast2Books = {
      for {
        b1 <- books
        b2 <- books
        if b1.title < b2.title
        a1 <- b1.authors
        a2 <- b2.authors
        if a1 == a2
      } yield a1
    } //.distinct // 'distinct' will remove repeated values (if we use List instead of Set
    // for books!! WoW! (but Set is more suitable for a database example).


    println(birdsBooks)
    println(programBooks)
    println(authorsWithAtLeast2Books)
  }
}
