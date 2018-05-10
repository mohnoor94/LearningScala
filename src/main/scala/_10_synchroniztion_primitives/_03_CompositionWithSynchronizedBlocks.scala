package _10_synchroniztion_primitives

object _03_CompositionWithSynchronizedBlocks extends App {
  val a = new Account(50)
  val b = new Account(70)

  println(a.amount)
  println(b.amount)
  println

  // thread T1
  a.transfer(b, 10)
  println(a.amount)
  println(b.amount)
  println

  // thread T2
  b.transfer(a, 20)
  println(a.amount)
  println(b.amount)
}

class Account(var amount: Int = 0) {
  private val x = new AnyRef
  private var uidCount = 0L

  private val uid: Long = getUniqueUid

  private def lockAndTransfer(target: Account, n: Int): Unit =
    this.synchronized {
      target.synchronized {
        this.amount -= n
        target.amount += n
      }
    }

  def transfer(target: Account, n: Int): Unit =
    if (this.uid < target.uid) this.lockAndTransfer(target, n)
    else target.lockAndTransfer(this, -n)


  def getUniqueUid: Long = x.synchronized {
    uidCount = uidCount + 1
    uidCount
  }
}