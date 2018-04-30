package _08_lazy_vals

object _03_CommonUsagesOfLazyVal {

  case class Foo(input: List[String]) {
    val lengths: List[Int] = {
      Thread.sleep(1000)
      input.map(_.length)
    }
    /**
      * We may have some cases that we do not want to
      * compute this val.
      * Maybe it has a whole bunch of memory requirement
      * that we don't need to take cost of unless we need to.
      */
    lazy val lowered: List[String] = {
      Thread.sleep(1000)
      input.map(_.toLowerCase())
    }
  }

  lazy val fileContents1: String = {
    val f = io.Source.fromURL(ClassLoader.getSystemResource("foo.txt"))
    f.getLines().mkString("\n")
  }


  /**
    * Here we may change something on the fly before we
    * evaluate this value!
    */
  var lineSeparator = "\n"
  lazy val fileContents2: String = {
    val f = io.Source.fromURL(ClassLoader.getSystemResource("foo.txt"))
    f.getLines().mkString(lineSeparator)
  }

  def myFunction(foo: Foo): Unit = {
    println(foo.lengths)
    separator()
    println(foo.lowered)
  }

  def main(args: Array[String]): Unit = {
    separator()
    myFunction(Foo(List("Foo", "Bar", "Sha", "Baz")))
    separator()
    println(fileContents1)
    separator()
    lineSeparator = "&"
    println(fileContents2)
  }

  def separator(): Unit = {
    for (_ <- 0 until 10) print("-")
    println()
  }
}
