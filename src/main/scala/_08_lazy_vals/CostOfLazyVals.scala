package _08_lazy_vals

/**
  * lazy val is not just something you can throw on and say ya
  * I don't worry about threading, because all threads will be
  * blocked until the thread reading that val done with it.
  *
  * But, you may want this, to do some operation before any thread
  * start to work for example =)
  *
  * Note: Thread.sleep(...) used to illustrate execution.
  */
object CostOfLazyVals {

  def myFunction1(): Unit = {
    // lazy val will not be executed until used
    lazy val variable = {
      Thread.sleep(1000)
      "foo"
    }
    println(System.currentTimeMillis())
    println(variable)
    println(System.currentTimeMillis())
    println(variable)
    println(System.currentTimeMillis())
  }

  val threadName: ThreadLocal[String] = {
    val tn = new ThreadLocal[String]
    tn.set(Thread.currentThread().getName)
    tn
  }

  def myFunction2(): Unit = {
    lazy val variable = {
      Thread.sleep(1000)
      "foo"
    }
    println(s"${threadName.get()}: ${System.currentTimeMillis()}")
    new Thread() {
      override def run(): Unit = {
        println(s"${threadName.get()}: ${System.currentTimeMillis()}")
        println(s"${threadName.get()}: $variable")
        println(s"${threadName.get()}: ${System.currentTimeMillis()}")
      }
    }.start()
    println(s"${threadName.get()}: $variable")
    println(s"${threadName.get()}: ${System.currentTimeMillis()}")
  }

  def main(args: Array[String]): Unit = {
    myFunction1()
    separator()
    myFunction2()
  }

  def separator(): Unit = {
    for (_ <- 0 until 10) print("-")
    println()
  }
}