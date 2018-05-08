package _97_general_examples

/**
  * Find the number of words that can be made by permuting the letters of a given string
  *
  * My Solution:
  * I'm using the formula of:
  * P(n,r)= n!/(n−r)!
  * n: number of distinct letter in the given text
  * r: word length (I'm taking word length from 1 up to n and add the results)
  */
object _005_PossibleWordsOfStringPermutations {
  def countPossibleWords(text: String): BigInt = {
//    val factorial = (number: Int) => (2 to number).product
    def factorial(number: BigInt, result: BigInt = 1): BigInt =
      if (number == 0) result
      else factorial(number - 1, result * number)

    val length = text.toLowerCase.length
    val nFactorial = factorial(length)
    (for (i <- 1 to length) yield nFactorial / factorial(length - i)).sum
  }

  def main(args: Array[String]): Unit = {
    println(countPossibleWords("a"))
    println(countPossibleWords("ab"))
    println(countPossibleWords("abb"))
    println(countPossibleWords("abbc"))
    println(countPossibleWords("abCDc"))
    println(countPossibleWords("abcr"))
    println(countPossibleWords("abcsafgr"))
    println(countPossibleWords("agebcsafgr"))
    println(countPossibleWords("agehgsrjwbcsafgr"))
    println(countPossibleWords("abcdefghijklmnopqrstuvwxyz"))
    println(countPossibleWords("abcdefghijklmnopqrstuvwxyzABCX"))
  }
}