package _05_random

object ByNameParameters extends App {
  {
    println(
      """What happens if I have a function as the last group in a
        |multi parameter list and that function has no parameters?""".stripMargin)

    def timer[A](expectedThreshold: Long)(f: () => A): (Long, Long, A) = {
      val start = System.currentTimeMillis()
      val result = f()
      val end = System.currentTimeMillis() - start
      (end, end - expectedThreshold, result)
    }

    val (time, offset, result) = timer(3000) { () =>
      Thread.sleep(3000)
      "Hello"
    }

    println(time)
    println(offset)
    println(result)
  }

  {
    println(
      """The above was ugly, so let's clean it up with
        |a by-name parameter!""".stripMargin)

    def timer[A](expectedThreshold: Long)(f: => A): (Long, Long, A) = {
      val start = System.currentTimeMillis()
      val result = f
      val end = System.currentTimeMillis() - start
      (end, end - expectedThreshold, result)
    }

    val (time, offset, result) = timer(3000) {
      Thread.sleep(3000)
      "Hello"
    }

    println(time)
    println(offset)
    println(result)
  }
}
