package _011_writing_new_control_structures

/**
  * For example, here is the "twice" control structure, which repeats an operation two times and returns the result:
  */
object _01_TwiceControlStructure {
  def twice(op: Double => Double, x: Double) = op(op(x))

  def main(args: Array[String]): Unit = {
    println(s"twice(_ + 1, 5) ==> ${twice(_ + 1, 5)}")
    println("=" * 30)
    println(s"twice(x => x * 5, 10) ==> ${twice(x => x * 5, 10)}")
    println("=" * 30)
    println {
      twice(x => {
        println(x)
        x * 5
      }, 10)
    }
    println("=" * 30)
  }
}