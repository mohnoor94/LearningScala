package _10_jvm_parallel_programming

/**
  * The synchronized block is used to achieve atomicity. Code block after a
  * synchronized call on an object x is never executed by two threads at the
  * same time
  */
object _02_SynchronizedBlock {
  private val x = new AnyRef
  private var uidCount = 0L

  /**
    * Different threads use the synchronized block to agree on unique values.
    * The synchronized block is an example of a synchronization primitive.
    */
  def getUniqueId: Long = x.synchronized {
    uidCount = uidCount + 1
    uidCount
  }

  def startThread(): Unit = {
    val t = new Thread {
      override def run(): Unit = {
        val uids = for (i <- 0 until 10) yield getUniqueId
        println(uids)
      }
    }
    t.start()
  }

  def main(args: Array[String]): Unit = {
    startThread()
    startThread()
  }
}