package _05_oop._02_composition_and_inheritance

/**
  * 10.2 ABSTRACT CLASSES
  * Our first task is to define type Element, which represents layout elements. Since elements are two dimensional
  * rectangles of characters, it makes sense to include a member, contents, that refers to the contents of a layout
  * element. The contents can be represented as an array of strings, where each string represents a line. Hence,
  * the type of the result returned by contents will be Array[String].
  *
  * >> you cannot instantiate an abstract class.
  * >> Note that the contents method in class Element does not carry an abstract modifier. A method is abstract if it
  * does not have an implementation (i.e., no equals sign or body). Unlike Java, no abstract modifier is necessary
  * (or allowed) on method declarations. Methods that have an implementation are called concrete.
  * >> Another bit of terminology distinguishes between declarations and definitions. Class Element declares the
  * abstract method contents, but currently defines no concrete methods.
  *
  *
  * 10.3 DEFINING PARAMETERLESS METHODS
  * >> Note that none of Element's three methods has a parameter list, not even an empty one. For example, instead of:
  * def width(): Int
  * the method is defined without parentheses:
  * def width: Int
  *
  * >> Such parameterless methods are quite common in Scala. By contrast, methods defined with empty parentheses, such
  * as def height(): Int, are called empty-paren methods. The recommended convention is to use a parameterless method
  * whenever there are no parameters and the method accesses mutable state only by reading fields of the containing
  * object (in particular, it does not change mutable state). This convention supports the uniform access principle,
  * which says that client code should not be affected by a decision to implement an attribute as a field or method.
  *
  * For instance, we could implement width and height as fields, instead of methods, simply by changing the def in each
  * definition to a val.
  *
  * >> The two pairs of definitions are completely equivalent from a client's point of view. The only difference is that
  * field accesses might be slightly faster than method invocations because the field values are pre-computed when the
  * class is initialized, instead of being computed on each method call. On the other hand, the fields require extra
  * memory space in each Element object. So it depends on the usage profile of a class whether an attribute is better
  * represented as a field or method, and that usage profile might change over time. The point is that clients of the
  * Element class should not be affected when its internal implementation changes.
  * In particular, a client of class Element should not need to be rewritten if a field of that class gets changed into
  * an access function, so long as the access function is pure (i.e., it does not have any side effects and does not
  * depend on mutable state). The client should not need to care either way.
  *
  * >> To bridge that gap, Scala is very liberal when it comes to mixing parameterless and empty-paren methods. In
  * particular, you can override a parameterless method with an empty-paren method, and vice versa. You can also leave
  * off the empty parentheses on an invocation of any function that takes no arguments.
  *
  * ▶ it is encouraged in Scala to define methods that take no parameters and have no side effects as parameterless
  * methods (i.e., leaving off the empty parentheses).
  * ▶ On the other hand, you should never define a method that has side-effects without parentheses, because invocations
  * of that method would then look like a field selection. So your clients might be surprised to see the side effects.
  * ▶ Similarly, whenever you invoke a function that has side effects, be sure to include the empty parentheses when you
  * write the invocation.
  *
  * ▶▶ Another way to think about this is if the function you're calling performs an operation, use the parentheses.
  * But if it merely provides access to a property, leave the parentheses off.
  */
abstract class Element {
  def contents: Array[String]
  //  def height: Int = contents.length
  val height: Int = contents.length
  //  def width: Int = if (height == 0) 0 else contents(0).length
  val width: Int = if (height == 0) 0 else contents(0).length
}