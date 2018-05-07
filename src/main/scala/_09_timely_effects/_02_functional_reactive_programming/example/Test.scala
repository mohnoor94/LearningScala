package _09_timely_effects._02_functional_reactive_programming.example

import _09_timely_effects._02_functional_reactive_programming.Signal

object Test extends App {
  def consolidated(accounts: List[BankAccount]): Signal[Int] =
    Signal(accounts.map(_.balance()).sum)

  val a, b = new BankAccount
  val c = consolidated(List(a, b))

  println("Initial total balance: " + c())
  a deposit 20
  println("After (a deposit 20): " + c())
  b deposit 30
  println("After (b deposit 30): " + c())
  b withdraw 5
  println("After (b withdraw 5): " + c())

  val xchange = Signal(0.71)
  val inJOD = Signal(c() * xchange())
  println(s"inJOD() => ${inJOD()}")

  b withdraw 10
  println(s"After (b withdraw 10): ${c()}, inJOD() => ${inJOD()}")
}