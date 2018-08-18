package _980_problem_solving

object ReverseWords {
  //    def reverseWords(sentence: String): String = sentence.trim.split("\\s+").map(_.reverse).mkString(" ")
  val reverseWords: String => String = (sentence: String) => sentence.trim.split("\\s+").map(_.reverse).mkString(" ")

  def main(args: Array[String]): Unit = {
    println(reverseWords("  Hello my    world!    "))
  }
}
