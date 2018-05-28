package _100_assertions_and_tests

// BDD
import _100_assertions_and_tests._03_ScalaTest._
import org.scalatest.{FlatSpec, Matchers}

/**
  * > In a FlatSpec, you write tests as specifier clauses.
  * > You start by writing a name for the subject under test as a string.
  * >> then should (or must or can), then a string that specifies a bit of behavior required of the subject,
  * >> then 'in'
  * >> In the curly braces following 'in', you write code that tests the specified behavior.
  * >> In subsequent clauses you can write it to refer to the most recently given subject.
  * > When a FlatSpec is executed, it will run each specifier clause as a ScalaTest test.
  * > FlatSpec (and ScalaTest's other specification traits) generate output that reads like a specification when run.
  *
  *
  * > Also we have, ScalaTest's matchers domain-specific language (DSL).
  * > By mixing in trait Matchers, you can write assertions that read more like natural language.
  * >> ScalaTest provides many matchers in its DSL, and also
  * >> enables you to define new matchers with custom failure messages.
  * > The matchers shown below include the "should be" and "an [ ...] should be thrownBy { ...} " syntax.
  * >> You can alternatively mix in MustMatchers if you prefer must to should (like the third and fourth examples).
  */
class Test_Flat_03_ScalaTest extends FlatSpec with Matchers {

  "The account" should "approve deposit of a positive amount" in {
    val currentBalance = balance
    val amount = 20
    deposit(amount)
    balance should be(currentBalance + amount)
  }

  it should "approve withdraw of positive amount if amount is sufficient" in {
    balance = 20
    val currentBalance = balance
    val amount = 10
    withdraw(amount)
    balance should be(currentBalance - amount)
  }

  it must "decline negative amount in withdraw" in {
    balance = 20
    val currentBalance = balance
    val amount = -20
    an[Error] must be thrownBy {
      withdraw(amount)
      balance = currentBalance - amount
    }
  }

  it must "decline withdraw if amount > balance" in {
    balance = 20
    val currentBalance = balance
    val amount = 100
    an[Error] must be thrownBy {
      withdraw(amount)
      balance = currentBalance - amount
    }
  }
}