package _070_timely_effects._02_functional_reactive_programming.example

import _070_timely_effects._02_functional_reactive_programming.Var

class BankAccount {
  val balance = Var(0)

  def deposit(amount: Int): Unit =
    if (amount > 0) {
      val b = balance()
      balance() = b + amount
    }

  def withdraw(amount: Int): Unit =
    if (0 < amount && amount <= balance()) {
      val b = balance()
      balance() = b - amount
    } else throw new Error("insufficient funds")
}