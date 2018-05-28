package _100_assertions_and_tests

// Function Suite
import org.scalatest.FunSuite

class Test_Fun_03_ScalaTest extends FunSuite {

  import _100_assertions_and_tests._03_ScalaTest._

  test("deposit should accept positive amount") {
    val currentBalance = balance
    val amount = 20
    deposit(amount)
    assert(balance == currentBalance + amount)
  }

  test("withdraw should accept positive amount if amount is sufficient") {
    balance = 20
    val currentBalance = balance
    val amount = 10
    withdraw(amount)
    assert(balance == currentBalance - amount)
  }

  test("withdraw should decline negative amount") {
    balance = 20
    val currentBalance = balance
    val amount = -20
    assertThrows[Error] {
      withdraw(amount)
      balance = currentBalance - amount
    }
  }

  test("withdraw should decline amount > balance") {
    balance = 20
    val currentBalance = balance
    val amount = 100
    assertThrows[Error] {
      withdraw(amount)
      balance = currentBalance - amount
    }
  }

  /**
    * If you wish to inspect the expected exception further, you can use intercept instead of assertThrows.
    * The intercept method works the same as assertThrows, except if the expected exception is thrown, intercept returns it.
    */
  test("withdraw should decline amount > balance | with intercept") {
    balance = 20
    val currentBalance = balance
    val amount = 100
    val result =
      intercept[Error] {
        withdraw(amount)
        balance = currentBalance - amount
      }
    assert(result.getMessage == "insufficient funds")
  }
}