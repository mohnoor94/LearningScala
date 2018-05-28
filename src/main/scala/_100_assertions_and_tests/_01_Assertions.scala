package _100_assertions_and_tests

/**
  * 14.1 ASSERTIONS
  * > Assertions in Scala are written as calls of a predefined method assert (predefined in Predef object).
  * > The expression assert(condition) throws an AssertionError if condition does not hold.
  * > There's also a two-argument version of assert: The expression assert(condition, explanation) tests condition and,
  * if it does not hold, throws an AssertionError that contains the given explanation.
  * >> The type of explanation is Any, so you can pass any object as the explanation.
  * >> The assert method will call toString on it to get a string explanation to place inside the AssertionError.
  */
object _01_Assertions {
  var balance = 0

  def deposit(amount: Int): Unit = {
    assert(amount > 0)
    balance += amount
  }

  def withdraw(amount: Int): Unit = {
    assert(0 < amount, "cannot withdraw a negative amount")
    assert(amount <= balance, "insufficient balance")
    balance -= amount
  }

  def main(args: Array[String]): Unit = {
    println(balance)
    deposit(10)
    println(balance)
    //    deposit(-10) // will fail with "java.lang.AssertionError: assertion failed"
    //    withdraw(50) // will fail with "java.lang.AssertionError: assertion failed: insufficient balance"
    //    withdraw(-50) // will fail with "assertion failed: cannot withdraw a negative amount"
    withdraw(5)
    println(balance)
  }
}