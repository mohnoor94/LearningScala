/**
  * Chapter 14 - Assertions and Tests
  * From: Programming in Scala, Third Edition
  *
  * > Assertions and tests are two important ways you can check that the software you write behaves as you expect.
  *
  *
  * 14.1 ASSERTIONS
  * @see _01_Assertions
  * @see _02_Ensuring
  *
  *
  * 14.2 TESTING IN SCALA
  * 14.3 INFORMATIVE FAILURE REPORTS
  * You have many options for testing in Scala, from established Java tools, such as JUnit and TestNG,
  * to tools written in Scala, such as ScalaTest, specs2, and ScalaCheck.
  * @see _03_ScalaTest
  * @see Test_Fun_03_ScalaTest (under test root)
  *
  *
  * 14.4 TESTS AS SPECIFICATIONS
  * > In the behavior-driven development (BDD) testing style, the emphasis is on writing human-readable specifications
  * of the expected behavior of code and accompanying tests that verify the code has the specified behavior.
  * > ScalaTest includes several traits that facilitate this style of testing.
  *
  * @see Test_Flat_03_ScalaTest (under test root)
  * @see 'specs2 testing framework' from the book
  *
  * > One of the big ideas of BDD is that tests can be used to facilitate communication between the people who decide
  * what a software system should do, the people who implement the software, and the people who determine whether the
  * software is finished and working.
  * >> Although any of ScalaTest's or specs2's styles can be used in this manner, ScalaTest's FeatureSpec in particular
  * is designed for it (feature/scenario/Given/When/Then/...).
  * > FeatureSpec is designed to guide conversations about software requirements:
  * >> You must identify specific features, then specify those features in terms of scenarios.
  * >> The Given, When, and Then methods (provided by trait GivenWhenThen) can help focus the conversation on the
  * specifics of individual scenarios.
  * ... this is a big topic that I won't continue studying now...
  *
  *
  * 14.5 PROPERTY-BASED TESTING
  * @see the book.
  */
package object _100_assertions_and_tests {
}