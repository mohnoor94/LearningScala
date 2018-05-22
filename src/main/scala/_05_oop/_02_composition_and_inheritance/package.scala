package _05_oop

/**
  * Chapter 10 - Composition and Inheritance
  * From: Programming in Scala, Third Edition
  *
  * Composition means one class holds a reference to another, using the referenced class to help it fulfill its mission.
  * Inheritance is the superclass/subclass relationship.
  *
  * 10.1 A TWO-DIMENSIONAL LAYOUT LIBRARY
  * As a running example in this chapter, we'll create a library for building and rendering two-dimensional layout
  * elements. Each element will represent a rectangle filled with text. For convenience, the library will provide
  * factory methods named "elem" that construct new elements from passed data. For example, you'll be able to create a
  * layout element containing a string using a factory method with the following signature:
  * elem(s: String): Element
  * As you can see, elements will be modeled with a type named Element. You'll be able to call above or beside on an
  * element, passing in a second element, to get a new element that combines the two. For example, the following
  * expression would construct a larger element consisting of two columns, each with a height of two:
  * ``
  * val column1 = elem("hello") above elem("***")
  * val column2 = elem("***") above elem("world")
  * column1 beside column2
  * ``
  * Printing the result of this expression would give you:
  * hello ***
  * *** world
  *
  * Layout elements are a good example of a system in which objects can be constructed from simple parts with the aid
  * of composing operators. In this chapter, we'll define classes that enable element objects to be constructed from
  * arrays, lines, and rectangles. These basic element objects will be the simple parts. We'll also define composing
  * operators above and beside. Such composing operators are also often called combinators because they combine
  * elements of some domain into new elements.
  * Thinking in terms of combinators is generally a good way to approach library design: it pays to think about the
  * fundamental ways to construct objects in an application domain.
  * ▶ What are the simple objects?
  * ▶ In what ways can more interesting objects be constructed out of simpler ones?
  * ▶ How do combinators hang together?
  * ▶ What are the most general combinations?
  * ▶ Do they satisfy any interesting laws?
  * If you have good answers to these questions, your library design is on track.
  *
  * 10.2 ABSTRACT CLASSES, and
  * 10.3 DEFINING PARAMETERLESS METHODS
  *
  * @see Element class
  *
  *
  * 10.4 EXTENDING CLASSES,
  * 10.5 OVERRIDING METHODS AND FIELDS, and
  * 10.6 DEFINING PARAMETRIC FIELDS
  * @see ArrayElement class
  *
  *
  * 10.7 INVOKING SUPERCLASS CONSTRUCTORS, and
  * 10.8 USING OVERRIDE MODIFIERS
  * @see LineElement class
  *
  *
  * 10.9 POLYMORPHISM AND DYNAMIC BINDING
  * @see UniformElement class
  *
  *
  * 10.10 DECLARING FINAL MEMBERS
  * ▶ Sometimes when designing an inheritance hierarchy, you want to ensure that a member cannot be overridden by
  * subclasses. In Scala, as in Java, you do this by adding a final modifier to the member.
  * e.g, final override def demo() = ...
  * Given this version of demo(), an attempt to override demo in any subclass, would not compile (error: error
  * overriding method demo ... method demo cannot override final member).
  *
  * ▶ You may also at times want to ensure that an entire class not be subclassed. To do this you simply declare the
  * entire class final by adding a final modifier to the class declaration.
  * e,g. final class ArrayElement extends Element { ...
  * With this version of ArrayElement, any attempt at defining a subclass would fail to compile (error: illegal
  * inheritance from final class)
  *
  *
  * 10.11 USING COMPOSITION AND INHERITANCE
  */
package object _02_composition_and_inheritance {
}