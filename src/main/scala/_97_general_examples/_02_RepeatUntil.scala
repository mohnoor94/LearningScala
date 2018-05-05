package _97_general_examples

object _02_RepeatUntil {

  /**
    * It should execute command one or more times, until condition is true
    */

  class REPEAT(command: => Unit) {
    def UNTIL(condition: => Boolean): Unit = {
      command
      if (condition) ()
      else UNTIL(condition)
    }
  }

  object REPEAT {
    def apply(command: => Unit): REPEAT = new REPEAT(command)
  }


  def main(args: Array[String]): Unit = {
    var v1 = 5
    val v2 = 10

    REPEAT {
      println(s"$v1 x $v2 = ${v1 * v2}")
      v1 += 1
    } UNTIL (v1 > v2)
  }
}