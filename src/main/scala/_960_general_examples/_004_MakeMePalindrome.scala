package _960_general_examples

/**
  * You have a string. And you have to add any number of letters to the string,
  * to the right or left, such that finally you get a palindrome.
  */
object _004_MakeMePalindrome {
  def makeMePalindrome(text: String): String = {
    if (text == text.reverse) text
    else {
      def palendromizeMe(text: String): String =
        text + text.reverse.dropWhile(_ == text.last)

      val leftPalindrome = palendromizeMe(text.reverse)
      val rightPalindrome = palendromizeMe(text)
      if (leftPalindrome.length < rightPalindrome.length) leftPalindrome
      else rightPalindrome
    }
  }

  def main(args: Array[String]): Unit = {
    println(makeMePalindrome("a"))
    println(makeMePalindrome("aa"))
    println(makeMePalindrome("aba"))
    println(makeMePalindrome("abc"))
    println(makeMePalindrome("ab"))
    println(makeMePalindrome("abbc"))
    println(makeMePalindrome("aacb"))
    println(makeMePalindrome("abaa"))
    println(makeMePalindrome("bba"))
    println(makeMePalindrome("baa"))
  }
}