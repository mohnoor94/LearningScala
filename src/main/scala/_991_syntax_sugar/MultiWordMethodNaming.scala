package _991_syntax_sugar

object MultiWordMethodNaming extends App {

  // helps in make your code more like natural languages
  // rarely used in practice

  case class TeenGirl(name: String) {
    def `and then said`(gossip: String): Unit = println(s"$name said $gossip")
  }

  val lilly = TeenGirl("Lilly")
  lilly `and then said` "Scala is so sweet!"
}
