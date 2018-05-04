package _98_problem_solving._02_DigitalCircuitDiagram

abstract class Gates extends Simulation {
  def InverterDelay: Int

  def AndGateDelay: Int

  def OrGateDelay: Int

  class Wire {
    private var signalVal = false
    private var actions: List[Action] = List()


    def getSignal: Boolean = signalVal

    def setSignal(s: Boolean): Unit =
      if (s != signalVal) {
        signalVal = s
        actions foreach (_ ())
      }

    def addAction(action: Action): Unit = {
      actions = action :: actions
      action()
    }
  }

  def inverter(input: Wire, output: Wire): Unit = {
    def invertAction(): Unit = {
      val inputSignal = input.getSignal
      afterDelay(InverterDelay) {
        output setSignal (!inputSignal)
      }
    }

    input addAction invertAction
  }

  def andGate(input1: Wire, input2: Wire, output: Wire): Unit = {
    def andAction(): Unit = {
      val input1Signal = input1.getSignal
      val input2Signal = input2.getSignal
      afterDelay(AndGateDelay) {
        output setSignal (input1Signal & input2Signal)
      }
    }

    input1 addAction andAction
    input2 addAction andAction
  }

  def orGate(input1: Wire, input2: Wire, output: Wire): Unit = {
    def orAction(): Unit = {
      val input1Signal = input1.getSignal
      val input2Signal = input2.getSignal
      afterDelay(AndGateDelay) {
        output setSignal (input1Signal | input2Signal)
      }
    }

    input1 addAction orAction
    input2 addAction orAction
  }

  def probe(name: String, wire: Wire): Unit = {
    def probeAction(): Unit = {
      println(s"$name $currentTime new-value = ${wire.getSignal}")
    }

    wire addAction probeAction
  }
}