package _980_problem_solving._04_DigitalCircuitDiagram

object Test extends App {

  object simulator extends Circuits with Parameters

  import simulator._

  val in1, in2, sum, carry = new Wire

  halfAdder(in1, in2, sum, carry)

  probe("sum", sum)
  probe("carry", carry)

  in1 setSignal true
  println("\nFirst Run:")
  run()

  in2 setSignal true
  println("\nSecond Run:")
  run()

  in1 setSignal false
  println("\nThird Run:")
  run()
}