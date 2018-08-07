package _960_general_examples

object _006_ReverseWords {
  //    def reverseWords(sentence: String): String = sentence.trim.split("\\s+").map(_.reverse).mkString(" ")
  val reverseWords: String => String = (sentence: String) => sentence.trim.split("\\s+").map(_.reverse).mkString(" ")

  def main(args: Array[String]): Unit = {
    println(reverseWords("  Hello my    world!    "))
  }
}