package _03_collections

object _06_2_InfiniteStreams {

  /**
    * @return a stream of all integers starting from a given
    *         number
    */
  def from(n: Int): Stream[Int] = n #:: from(n + 1)

  /**
    * The Sieve of Eratosthenes is an ancient technique to calculate prime numbers.
    * The idea is as follows:
    * ▶ Start with all integers from 2, the first prime number.
    * ▶ Eliminate all multiples of 2.
    * ▶ The first element of the resulting list is 3, a prime number.
    * ▶ Eliminate all multiples of 3.
    * ▶ Iterate forever. At each step, the first number in the list is a
    * prime number and we eliminate all its multiples
    */
  def sieve(s: Stream[Int]): Stream[Int] =
    s.head #:: sieve(s.tail filter (_ % s.head != 0))

  def main(args: Array[String]): Unit = {
    val naturalNumbers = from(0)
    println("naturalNumbers.take(10).toList")
    println(naturalNumbers.take(10).toList)
    println


    val multiplesOf4 = naturalNumbers map (_ * 4)
    //    val multiplesOf4SecondWay = naturalNumbers filter (_ % 4 == 0)
    //    // the second way is slower.
    println("multiplesOf4.take(20).toList")
    println(multiplesOf4.take(20).toList)
    println


    val primes = sieve(from(2))
    println("(primes take 25).toList")
    println((primes take 25).toList)
    println
  }
}