package _100_assertions_and_tests

/**
  * > Better alternative to 'assert' (?)
  * > The ensuring method can be used with any result type because of an implicit conversion.
  * > The ensuring method takes one argument, a predicate function that takes a result type and returns Boolean,
  * and passes the result to the predicate.
  * > If the predicate returns true, ensuring will return the result; otherwise, ensuring will throw an AssertionError.
  */
object _02_Ensuring {
  var balance = 0

  def deposit(amount: Int): Unit = {
    balance += amount
  } ensuring (amount > 0)

  def withdraw(amount: Int): Unit = {
    balance -= amount
  } ensuring(0 < amount, "cannot withdraw a negative amount") ensuring(amount <= balance, "insufficient balance")

  def main(args: Array[String]): Unit = {
    println(balance)
    deposit(10)
    println(balance)
    //        deposit(-10) // will fail with "java.lang.AssertionError: assertion failed"
    //        withdraw(50) // will fail with "java.lang.AssertionError: assertion failed: insufficient balance"
    //        withdraw(-50) // will fail with "java.lang.AssertionError: assertion failed: cannot withdraw a negative amount"
    withdraw(5)
    println(balance)
  }
}