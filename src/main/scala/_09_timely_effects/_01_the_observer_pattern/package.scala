package _09_timely_effects

/**
  * The Observer Pattern is widely used when views need to react to changes
  * in a model.
  * Some variants are also called publish/subscribe, model/view/(controller).
  *
  *
  * Observer Pattern, The Good:
  * ▶ Decouples views from state
  * ▶ Allows to have a varying number of views of a given state
  * ▶ Simple to set up
  *
  *
  * Observer Pattern, The Bad
  * ▶ Forces imperative style, since handlers are Unit-typed
  * ▶ Many moving parts that need to be co-ordinated
  * ▶ Concurrency makes things more complicated
  * ▶ Views are still tightly bound to one state; view update happens
  * immediately.
  * To quantify (Adobe presentation from 2008):
  * ▶ 1/3rd of the code in Adobe’s desktop applications is devoted to event
  * handling.
  * ▶ 1/2 of the bugs are found in this code.
  *
  *
  * How to Improve?
  * ▶ Functional Reactive Programming.
  * ▶ Abstracting over events and eventstreams with Futures and Observables.
  * ▶ Handling concurrency with Actors.
  */
package object _01_the_observer_pattern {

}
