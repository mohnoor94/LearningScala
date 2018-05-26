package _070_timely_effects._01_the_observer_pattern.example

object Test extends App {
  val a, b = new BankAccount
  val c = new Consolidator(List(a, b))

  println("Initial total balance: " + c.totalBalance)
  a deposit 20
  println("After (a deposit 20): " + c.totalBalance)
  b deposit 30
  println("After (b deposit 30): " + c.totalBalance)
  b withdraw 5
  println("After (b withdraw 5): " + c.totalBalance)
}