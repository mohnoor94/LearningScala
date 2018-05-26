package _070_timely_effects

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
  * * observers: all the other signals that depends on the value of the current signal.
  *
  *
  *
  * Dependency Maintenance
  * How do we record dependencies in observers?
  * ▶ When evaluating a signal-valued expression, need to know which
  * signal caller gets defined or updated by the expression.
  * ▶ If we know that, then executing a sig() means adding caller to the
  * observers of sig.
  * ▶ When signal sig’s value changes, all previously observing signals are
  * re-evaluated and the set sig.observers is cleared.
  * ▶ Re-evaluation will re-enter a calling signal caller in sig.observers, as
  * long as caller’s value still depends on sig.
  *
  *
  * Who’s Calling?
  * How do we find out on whose behalf a signal expression is evaluated?
  * One simple (simplistic?) way to do this is to maintain a global data
  * structure referring to the current caller. (We will discuss and refine this
  * later).
  * That data structure is accessed in a stack-like fashion because one
  * evaluation of a signal might trigger others.
  *
  *
  *
  *
  * ------------------------------------------------------------------------
  * Discussion
  * Our implementation of FRP is quite stunning in its simplicity.
  * But you might argue that it is too simplistic.
  * In particular, it makes use of the worst kind of state: global state.
  * object Signal {
  * val caller = new StackableVariable[Signal[_]](NoSignal)
  * ...
  * }
  * One immediate problem is: What happens if we try to evaluate several
  * signal expressions in parallel?
  * ▶ The caller signal will become “garbled” by concurrent updates.
  *
  * Suggested Solutions:
  * (1) Synchronization
  * One way to get around the problem of concurrent accesses to global state
  * is to use synchronization.
  * But this blocks threads, can be slow, and can lead to deadlocks.
  *
  * (2) Thread-Local State
  * Another solution is to replace global state by thread-local state.
  * ▶ Thread-local state means that each thread accesses a separate copy
  * of a variable.
  * ▶ It is supported in Scala through class scala.util.DynamicVariable.
  *
  * The API of DynamicVariable matches the one of StackableVriable
  * So we can simply swap it into our Signal implementation:
  * object Signal {
  * val caller = new DynamicVariable[Signal[_]](NoSignal)
  * ...
  * }
  *
  * (3) Implicit Parameters
  * Thread-local state still comes with a number of disadvantages:
  * ▶ Its imperative nature often produces hidden dependencies which are hard to manage.
  * ▶ Its implementation on the JDK involves a global hash table lookup,
  * which can be a performance problem.
  * ▶ It does not play well in situations where threads are multiplexed
  * between several tasks.
  *
  * A cleaner solution involves implicit parameters.
  * ▶ Instead of maintaining a thread-local variable, pass its current value
  * into a signal expression as an implicit parameter.
  * ▶ This is purely functional.
  * ▶ In current Scala it requires more boilerplate than the thread-local
  * solution.
  * ▶ Future versions of Scala might solve that problem (Scala 3 did that)).
  *
  *
  *
  *
  * ------------------------------------------------------------------------
  * Summary
  * We have given a quick tour through functional reactive programming, with
  * some usage examples and an implementation.
  * This is just a taster, there’s much more to be discovered in the field.
  * In particular, we only covered one particular style of FRP: Discrete signals
  * changed by events.
  * Some variants of FRP also treat continuous signals.
  * Values in these systems are often computed by sampling instead of event
  * propagation.
  */
package object _02_functional_reactive_programming {

}