package _060_lazy_vals

object _07_LazyFiltering extends App {

  def lessThan30(n: Int): Boolean = {
    println(s"Is $n less than 30?")
    n < 30
  }

  def greaterThan20(n: Int): Boolean = {
    println(s"Is $n greater than 20?")
    n > 20
  }

  val numbers = List(1, 5, 50, 500, 25, 27, 17)

  println(":: Note the ordering ::\n")

  val normalFiltering: Unit = {
    println("normalFiltering:")

    val lt30 = numbers.filter(lessThan30)
    val gt20 = lt30.filter(greaterThan20)

    println(gt20)
  }

  println("=" * 20)

  val lazyFiltering: Unit = {
    println("lazyFiltering:")

    val lt30 = numbers.withFilter(lessThan30) // lazy filtering
    val gt20 = lt30.withFilter(greaterThan20)

    println(gt20) // will not fire the filtering action

    gt20.foreach(println) // filtering on need between multiple stages of filtering!
  }

  println("=" * 20)

  // note: for-comprehensions use withFilter with guards
  val forComprehensionsTranslation: Unit = {
    println("forComprehensionsTranslation:")
    val a = for {
      x <- List(1, 2, 3) if x % 2 == 0
    } yield x + 1

    // is translated to something like:
    val b = List(1, 2, 3).withFilter(_ % 2 == 0).map(_ + 1)

    println(a)
    println(b)
  }
}
