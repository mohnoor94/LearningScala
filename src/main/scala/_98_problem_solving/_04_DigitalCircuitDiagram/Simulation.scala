package _98_problem_solving._04_DigitalCircuitDiagram

abstract class Simulation {
  type Action = () => Unit

  case class Event(time: Int, action: Action)

  private var curtime = 0

  def currentTime: Int = curtime

  private var agenda: List[Event] = List()

  private def insert(agenda: List[Event], item: Event): List[Event] = agenda match {
    case first :: rest if first.time <= item.time => first :: insert(rest, item)
    case _ => item :: agenda
  }

  def afterDelay(delay: Int)(block: => Unit): Unit = {
    val item = Event(currentTime + delay, () => block)
    agenda = insert(agenda, item)
  }


  def run(): Unit = {
    afterDelay(0) {
      println(s"*** Simulation Started, time= $currentTime ***")
    }
    loop()
  }


  private def loop(): Unit = agenda match {
    case first :: rest =>
      agenda = rest
      curtime = first.time
      first.action()
      loop()
    case Nil =>
  }
}