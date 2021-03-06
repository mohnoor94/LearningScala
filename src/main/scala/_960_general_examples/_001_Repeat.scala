package _960_general_examples

object _001_Repeat {
  /**
    * It should execute command one or more times, until condition is true
    */
  def REPEAT(command: => Unit)(condition: => Boolean): Unit = {
    command
    if (condition) ()
    else REPEAT(command)(condition)
  }

  def main(args: Array[String]): Unit = {
    var v1 = 1
    val v2 = 10

    REPEAT {
      println(s"$v1 x $v2 = ${v1 * v2}")
      v1 += 1
    }(v1 > v2)
  }
}