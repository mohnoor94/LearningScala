package _09_timely_effects

/**
  * What is FRP?
  * Imperative reactive programming is about reacting to sequences of events
  * that happen in time.
  * Functional view: Aggregate an event sequence into a signal.
  * ▶ A signal is a value that changes over time.
  * ▶ It is represented as a function from time to the value domain.
  * ▶ Instead of propagating updates to mutable state, we define new
  * signals in terms of existing ones.
  *
  *
  * Origins of FRP
  * FRP started in 1997 with the paper Functional Reactive Animation by
  * Conal Elliott and Paul Hudak and the Fran library.
  * There have been many FRP systems since, both standalone languages and
  * embedded libraries.
  * Some examples are: Flapjax, Elm, Bacon.js, React4J.
  * Event streaming dataflow programming systems such as Rx,
  * are related but the term FRP is not commonly used for them.
  * We will introduce FRP by means of of a minimal class, frp.Signal whose
  * implementation is explained at the end of this module.
  * frp.Signal is modelled after Scala.react, which is described in the paper
  * Deprecating the Observer Pattern.
  *
  *
  * Fundamental Signal Operations
  * 1. Obtain the value of the signal at the current time.
  * In our library this is expressed by () application.
  * 2. Define a signal in terms of other signals.
  * In our library, this is expressed by the Signal constructor.
  *
  * Constant Signals
  * The Signal(...) syntax can also be used to define a signal that has
  * always the same value:
  * val sig = Signal(3) // the signal that is always 3.
  *
  * Time-Varying Signals
  * How do we define a signal that varies in time?
  * ▶ We can use externally defined signals, and map over them.
  * ▶ Or we can use a Var (a class we will define).
  *
  * Variable Signals
  * Values of type Signal are immutable.
  * But our library also defines a subclass Var of Signal for signals that can be
  * changed.
  * Var provides an “update” operation, which allows to redefine the value of
  * a signal from the current time on.
  * val sig = Var(3)
  * sig.update(5) // From now on, sig returns 5 instead of 3.
  * or sig() = 5 // look at _99_random.UpdateMethod
  *
  * Signals and Variables
  * Signals of type Var look a bit like mutable variables, where
  * sig() is dereferencing, and
  * sig() = newValue is update.
  * But there’s a crucial difference:
  * We can map over signals, which gives us a relation between two signals
  * that is maintained automatically, at all future points in time.
  * No such mechanism exists for mutable variables; we have to propagate all
  * updates manually.
  * Example:
  * var a = 2
  * var b = 2 * a // b = 4
  * a = 3 // b is still 4
  * but with our Var():
  * val a() = 2
  * val b() = 2 * a()
  * a() = 3 // b() will be automatically to 6
  *
  *
  *
  *
  * Implementation Idea
  * Each signal maintains
  * ▶ its current value,
  * ▶ the current expression that defines the signal value,
  * ▶ a set of observers: the other signals that depend on its value.
  * Then, if the signal changes, all observers need to be re-evaluated.
  */
package object _02_functional_reactive_programming {

}