package _100_assertions_and_tests

/**
  * > ScalaTest is the most flexible Scala test framework: it can be easily customized to solve different problems.
  * > ScalaTest's flexibility means teams can use whatever testing style fits their needs best.
  * > For example, for teams familiar with JUnit, the FunSuite style will feel comfortable and familiar.
  *   >> Check 'Test_03_ScalaTest' under test root.
  */
object _03_ScalaTest {
  var balance = 0

  def deposit(amount: Int): Unit = if (amount > 0) balance += amount

  def withdraw(amount: Int): Unit =
    if (0 < amount && amount <= balance) balance -= amount
    else throw new Error("insufficient funds")
}