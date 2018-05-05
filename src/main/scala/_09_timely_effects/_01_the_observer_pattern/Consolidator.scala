package _09_timely_effects._01_the_observer_pattern

class Consolidator(observed: List[BankAccount]) extends Subscriber {
  observed.foreach(_.subscribe(this))

  private var total: Int = _

  private def compute(): Unit = total = observed.map(_.currentBalance).sum
  def totalBalance: Int = total
  def handler(publisher: Publisher): Unit = compute()
}