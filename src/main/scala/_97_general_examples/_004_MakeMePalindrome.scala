package _97_general_examples

/**
  * You have a string. And you have to add any number of letters to the string,
  * to the right or left, such that finally you get a palindrome.
  */
object _004_MakeMePalindrome {
  def makeMePalindrome(text: String): String =
    if (text == text.reverse) text
    else {
      // TODO complete this
      ???
    }

  def main(args: Array[String]): Unit = {
    println(makeMePalindrome("ab"))
    println(makeMePalindrome("abc"))
    println(makeMePalindrome("abbc"))
    println(makeMePalindrome("aacb"))
    println(makeMePalindrome("a"))
    println(makeMePalindrome("aa"))
    println(makeMePalindrome("ab"))
    println(makeMePalindrome("aba"))
    println(makeMePalindrome("abaa"))
    println(makeMePalindrome("bba"))
  }
}