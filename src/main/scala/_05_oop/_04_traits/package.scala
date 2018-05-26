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
  *
  *
  * 12.5 TRAITS AS STACKABLE MODIFICATIONS
  * @see _03_TraitsAsStackableModifications
  *
  *
  * 12.6 WHY NOT MULTIPLE INHERITANCE?
  * > Traits are a way to inherit from multiple class-like constructs, but they differ in important ways from the
  * multiple inheritance present in many languages. One difference is especially important: the interpretation of super.
  * With multiple inheritance, the method called by a super call can be determined right where the call appears. With
  * traits, the method called is determined by a linearization of the classes and traits that are mixed into a class.
  * This is the difference that enables the stacking of modifications described in the previous section.
  *
  * >> Before looking at linearization, take a moment to consider how to stack modifications in a language with
  * traditional multiple inheritance. Imagine the following code, but this time interpreted as multiple inheritance
  * instead of trait mixin:
  * ``
  * val q = new BasicIntQueue with Incrementing with Doubling
  * q.put(42)  // which put would be called?
  * ``
  * > The first question is: Which put method would get invoked by this call?
  * -  Perhaps the rule would be that the last superclass wins, in which case Doubling would get called. Doubling would
  * double its argument and call super.put, and that would be it. No incrementing would happen!
  * - Likewise, if the rule were that the first superclass wins, the resulting queue would increment integers but not
  * double them. Thus neither ordering would work.
  * - You might also entertain the possibility of allowing programmers to identify exactly which superclass method they
  * want when they say super.
  * ``
  * def put(x: Int) = {
  *   Incrementing.super.put(x) // (Not real Scala)
  *   Doubling.super.put(x)
  * }
  * ``
  * > This approach would give us new problems (with the verbosity of this attempt being the least of its problems). What
  * would happen is that the base class's put method would get called twice—once with an incremented value and once with
  * a doubled value, but neither time with an incremented, doubled value.
  *
  * ▶ There is simply no good solution to this problem using multiple inheritance. You would have to back up in your
  * design and factor the code differently. By contrast, the traits solution in Scala is straightforward. You simply mix
  * in Incrementing and Doubling, and Scala's special treatment of super in traits makes it all work out. Something is
  * clearly different here from traditional multiple inheritance, but what? As hinted previously, the answer is
  * linearization. When you instantiate a class with new, Scala takes the class, and all of its inherited classes and
  * traits, and puts them in a single, linear order. Then, whenever you call super inside one of those classes, the
  * invoked method is the next one up the chain. If all of the methods but the last call super, the net result is
  * stackable behavior.
  *
  * ▶ The precise order of the linearization is described in the language specification. It is a little bit complicated,
  * but the main thing you need to know is that, in any linearization, a class is always linearized in front of all its
  * superclasses and mixed in traits. Thus, when you write a method that calls super, that method is definitely
  * modifying the behavior of the superclasses and mixed in traits, not the other way around.
  * > Example:
  * ``
  * class Animal
  * trait Furry extends Animal
  * trait HasLegs extends Animal
  * trait FourLegged extends HasLegs
  * class Cat extends Animal with Furry with FourLegged
  * ``
  * Type --------- Linearization
  * Animal ------>	Animal, AnyRef, Any
  * Furry ------->  Furry, Animal, AnyRef, Any
  * FourLegged -->  FourLegged, HasLegs, Animal, AnyRef, Any
  * HasLegs ----->  HasLegs, Animal, AnyRef, Any
  * Cat --------->  Cat, FourLegged, HasLegs, Furry, Animal, AnyRef, Any
  *
  *
  * 12.7 TO TRAIT OR NOT TO TRAIT?
  * ▶ If the behavior will not be reused, then make it a concrete class. It is not reusable behavior after all.
  * ▶ If it might be reused in multiple, unrelated classes, make it a trait. Only traits can be mixed into different
  * parts of the class hierarchy.
  * ▶ If you want to inherit from it in Java code, use an abstract class. Since traits with code do not have a close
  * Java analog, it tends to be awkward to inherit from a trait in a Java class. Inheriting from a Scala class,
  * meanwhile, is exactly like inheriting from a Java class. As one exception, a Scala trait with only abstract members
  * translates directly to a Java interface, so you should feel free to define such traits even if you expect Java code
  * to inherit from it.
  * ▶ If you plan to distribute it in compiled form, and you expect outside groups to write classes inheriting from it,
  * you might lean towards using an abstract class. The issue is that when a trait gains or loses a member, any classes
  * that inherit from it must be recompiled, even if they have not changed. If outside clients will only call into the
  * behavior, instead of inheriting from it, then using a trait is fine.
  * ▶ If you still do not know, after considering the above, then start by making it as a trait. You can always change
  * it later, and in general using a trait keeps more options open.
  *
  *
  * Conclusion and Notes
  * ▶ Now that you have seen all of these facets, it is worth stepping back and taking another look at traits as a whole.
  * Traits do not merely support the idioms described in this chapter; they are a fundamental unit of code that is
  * reusable through inheritance. As such, many experienced Scala programmers start with traits when they are at the
  * early stages of implementation. Each trait can hold less than an entire concept, a mere fragment of a concept. As
  * the design solidifies, the fragments can be combined into more complete concepts through trait mixin.
  * ▶ Once a trait is mixed into a class, you can alternatively call it a mixin.
  */
package object _04_traits {
}