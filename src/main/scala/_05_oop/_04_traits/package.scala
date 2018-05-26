package _05_oop

/**
  * Chapter 12 - Traits
  * From: Programming in Scala, Third Edition
  *
  * Traits are a fundamental unit of code reuse in Scala. A trait encapsulates method and field definitions, which can
  * then be reused by mixing them into classes. Unlike class inheritance, in which each class must inherit from just one
  * superclass, a class can mix in any number of traits. This chapter shows you how traits work and shows two of the
  * most common ways they are useful: widening thin interfaces to rich ones, and defining stackable modifications. It
  * also shows how to use the Ordered trait and compares traits to the multiple inheritance of other languages.
  *
  *
  * 12.1 HOW TRAITS WORK
  * @see _01_HowTraitsWork
  *
  *
  * 12.2 THIN VERSUS RICH INTERFACES
  * > Thin versus rich interfaces represents a commonly faced trade-off in object-oriented design. The trade-off is
  * between the implementers and the clients of an interface.
  * > A rich interface has many methods, which make it convenient for the caller. Clients can pick a method that exactly
  * matches the functionality they need.
  * > A thin interface, on the other hand, has fewer methods, and thus is easier on the implementers. Clients calling
  * into a thin interface, however, have to write more code. Given the smaller selection of methods to call, they may
  * have to choose a less than perfect match for their needs and write extra code to use it.
  * > Java's interfaces are more often thin than rich.
  * > Adding a concrete method to a trait tilts the thin-rich trade-off heavily towards rich interfaces.
  * > Unlike in Java, adding a concrete method to a Scala trait is a one-time effort. You only need to implement the
  * method once, in the trait itself, instead of needing to reimplement it for every class that mixes in the trait.
  * Thus, rich interfaces are less work to provide in Scala than in a language without traits.
  *
  *
  * 12.4 THE ORDERED TRAIT
  * @see _02_OrderedTrait
  */
package object _04_traits {
}