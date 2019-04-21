package _060_lazy_vals

// in conjunction with byName
object _06_CallByNeed extends App {

  // this is called "Call by need"
  def byNameMethod(n: => Int): Int = {
    lazy val t = n
    t + t + t + 1
  }

  def stupidByNameMethod(n: => Int): Int = {
    n + n + n + 1
  }

  def retrieveMagicValue: Int = {
    println("Waiting...")
    Thread.sleep(1000)
    50
  }

  println(stupidByNameMethod(retrieveMagicValue))
  println("=" * 20)


  // with call by need!
  println(byNameMethod(retrieveMagicValue))
}
