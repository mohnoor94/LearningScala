package _05_oop._02_composition_and_inheritance

/**
  * 10.7 INVOKING SUPERCLASS CONSTRUCTORS
  * You now have a complete system consisting of two classes: an abstract class Element, which is extended by a concrete
  * class ArrayElement. You might also envision other ways to express an element. For example, clients might want to
  * create a layout element consisting of a single line given by a string. Object-oriented programming makes it easy to
  * extend a system with new data-variants. You can simply add subclasses.
  *
  * >> Since LineElement extends ArrayElement, and ArrayElement's constructor takes a parameter (an Array[String]),
  * LineElement needs to pass an argument to the primary constructor of its superclass.
  *
  *
  * 10.8 USING OVERRIDE MODIFIERS
  * ▶ Scala requires such a modifier for all members that override a concrete member in a parent class. The modifier is
  * optional if a member implements an abstract member with the same name. The modifier is forbidden if a member does not
  * override or implement some other member in a base class. Since height and width in class LineElement override concrete
  * definitions in class Element, override is required.
  *
  * >> The override convention is even more important when it comes to system evolution. Say you defined a library of 2D
  * drawing methods. You made it publicly available, and it is widely used. In the next version of the library you want
  * to add to your base class Shape a new method with this signature:
  * def hidden(): Boolean
  * Your new method will be used by various drawing methods to determine whether a shape needs to be drawn. This could
  * lead to a significant speedup, but you cannot do this without the risk of breaking client code. After all, a client
  * could have defined a subclass of Shape with a different implementation of hidden. Perhaps the client's method
  * actually makes the receiver object disappear instead of testing whether the object is hidden. Because the two
  * versions of hidden override each other, your drawing methods would end up making objects disappear, which is
  * certainly not what you want!
  * >> These "accidental overrides" are the most common manifestation of what is called the "fragile base class" problem.
  * The problem is that if you add new members to base classes (which we usually call superclasses) in a class hierarchy,
  * you risk breaking client code. Scala cannot completely solve the fragile base class problem, but it improves on the
  * situation compared to Java. If the drawing library and its clients were written in Scala, then the client's original
  * implementation of hidden could not have had an override modifier, because at the time there was no other method with
  * that name. Once you add the hidden method to the second version of your shape class, a recompile of the client would
  * give an error like the following: (error: error overriding method ... method hidden needs 'override' modifier). That
  * is, instead of wrong behavior your client would get a compile-time error, which is usually much preferable.
  */
class LineElement(line: String) extends ArrayElement(Array(line)) {
  override val height: Int = line.length
  override val width: Int = 1
}