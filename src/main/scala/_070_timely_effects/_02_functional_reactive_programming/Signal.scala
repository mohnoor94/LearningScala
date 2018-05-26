package _070_timely_effects._02_functional_reactive_programming

import scala.util.DynamicVariable

class Signal[T](expr: => T) {

  import Signal._

  private var myExpr: () => T = _
  private var myValue: T = _
  private var observers: Set[Signal[_]] = Set()
  update(expr)

  protected def update(expr: => T): Unit = {
    myExpr = () => expr
    computeValue()
  }

  def computeValue(): Unit = {
    val newValue = caller.withValue(this)(myExpr())
    if (myValue != newValue) {
      myValue = newValue
      val obs = observers
      observers = Set()
      obs.foreach(_.computeValue())
    }
  }

  def apply(): T = {
    observers += caller.value
    assert(!caller.value.observers.contains(this), "Cyclic signal definition")
    myValue
  }
}

object NoSignal extends Signal[Nothing](???){
  override def computeValue(): Unit = ()
}

object Signal {
//  val caller = new StackableVariable[Signal[_]](NoSignal)
  val caller = new DynamicVariable[Signal[_]](NoSignal)

  def apply[T](expr: => T) = new Signal(expr)
}