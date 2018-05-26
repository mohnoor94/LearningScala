package _031_composition_and_inheritance

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
  *
  *
  * ..............................................
  *
  * 10.12 IMPLEMENTING ABOVE, BESIDE, AND TOSTRING
  * >> above: Putting one element above another means concatenating the two contents values of the elements. In fact,
  * the code shown is not quite sufficient because it does not let you put elements of different widths on top of each
  * other. To keep things simple in this section, however, we'll leave this as is and only pass elements of the same
  * length to above.
  *
  * >> beside: To put two elements beside each other, we'll create a new element in which every line results from
  * concatenating corresponding lines of the two elements. As before, to keep things simple, we'll start by assuming the
  * two elements have the same height. This leads to the following design of method beside (below).
  * >> The 'besideImperative' method first allocates a new array, contents, and fills it with the concatenation of the
  * corresponding array elements in this.contents and that.contents. It finally produces a new ArrayElement containing
  * the new contents.
  * >> Although this implementation of beside works, it is in an imperative style, the telltale sign of which is the
  * loop in which we index through arrays. Alternatively, the method could be abbreviated to one expression (beside).
  * Here, the two arrays, this.contents and that.contents, are transformed into an array of pairs (as Tuple2s are called)
  * using the zip operator. The zip operator picks corresponding elements in its two operands and forms an array of pairs.
  *
  * >> toString: You still need a way to display elements. As usual, this is done by defining a toString method that
  * returns an element formatted as a string. Note that toString does not carry an empty parameter list. This follows
  * the recommendations for the uniform access principle, because toString is a pure method that does not take any
  * parameters.
  *
  *
  * 10.13 DEFINING A FACTORY OBJECT (Continue, see the Element object below at first)
  * With the advent of these factory methods, it makes sense to change the implementation of class Element so that it
  * goes through our factory methods rather than creating new ArrayElement instances explicitly.
  * >>>> go back to Element object.
  *
  *
  * 10.14 HEIGHTEN AND WIDEN
  * >> We need one last enhancement. The current version of Element is not quite sufficient because it does not allow
  * clients to place elements of different widths on top of each other, or place elements of different heights beside
  * each other.
  * >> For example, evaluating the following expression won't work correctly, because the second line in the combined
  * element is longer than the first:
  * ``
  * new ArrayElement(Array("hello")) above
  * new ArrayElement(Array("world!"))
  * ``
  * >> Similarly, evaluating the following expression would not work properly, because the first ArrayElement has a
  * height of two and the second a height of only one:
  * ``
  * new ArrayElement(Array("one", "two")) beside
  * new ArrayElement(Array("one"))
  * ``
  * >> We will add a private helper method, widen, which takes a width and returns an Element of that width. The result
  * contains the contents of this Element, centered, padded to the left and right by any spaces needed to achieve the
  * required width.
  * >> We will also add a similar method, heighten, which performs the same function in the vertical direction.
  * >> The widen method is invoked by above to ensure that Elements placed above each other have the same width.
  * >> Similarly, the heighten method is invoked by beside to ensure that elements placed beside each other have the
  * same height.
  *
  * With these changes, the layout library is ready for use.
  */
abstract class Element {
  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length

  /** Putting one element above another means concatenating the two contents values of the elements. */
  //  def above(that: Element): Element = Element(this.contents ++ that.contents)
  def above(that: Element): Element = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    Element(this1.contents ++ that1.contents)
  }

  //  /** To put two elements beside each other (Imperative Solution)*/
  //  def besideImperative(that: Element): Element = {
  //    val contents = new Array[String](this.contents.length)
  //    for (i <- this.contents.indices)
  //      contents(i) = this.contents(i) + that.contents(i)
  //    new ArrayElement(contents)
  //  }

  /** To put two elements beside each other */
  //  def beside(that: Element): Element =
  //    Element(for ((line1, line2) <- this.contents zip that.contents) yield line1 + line2)
  def beside(that: Element): Element = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    Element(for ((line1, line2) <- this1.contents zip that1.contents) yield line1 + line2)
  }


  def widen(w: Int): Element =
    if (w <= width) this
    else {
      val left = Element(' ', (w - width) / 2, height)
      val right = Element(' ', w - width - left.width, height)
      left beside this beside right
    }

  def heighten(h: Int): Element =
    if (h <= height) this
    else {
      val top = Element(' ', width, (h - height) / 2)
      val bot = Element(' ', width, h - height - top.height)
      top above this above bot
    }

  override def toString: String = contents mkString "\n"
}


/**
  * 10.13 DEFINING A FACTORY OBJECT
  * >> You now have a hierarchy of classes for layout elements. This hierarchy could be presented to your clients
  * "as is," but you might also choose to hide the hierarchy behind a factory object.
  * >> A factory object contains methods that construct other objects. Clients would then use these factory methods to
  * construct objects, rather than constructing the objects directly with new. An advantage of this approach is that
  * object creation can be centralized and the details of how objects are represented with classes can be hidden. This
  * hiding will both make your library simpler for clients to understand, because less detail is exposed, and provide
  * you with more opportunities to change your library's implementation later without breaking client code.
  *
  * >> The first task in constructing a factory for layout elements is to choose where the factory methods should be
  * located. Should they be members of a singleton object or of a class? What should the containing object or class be
  * called? There are many possibilities. A straightforward solution is to create a companion object of class Element
  * and make this the factory object for layout elements. That way, you need to expose only the class/object combo of
  * Element to your clients, and you can hide the three implementation classes ArrayElement, LineElement, and
  * UniformElement.
  * >>>> go to Element class above.
  * In addition, given the factory methods, the subclasses, ArrayElement, LineElement, and UniformElement, could now be
  * private because they no longer need to be accessed directly by clients. In Scala, you can define classes and
  * singleton objects inside other classes and singleton objects. One way to make the Element subclasses private is to
  * place them inside the Element singleton object and declare them private there. The classes will still be accessible
  * to the three apply factory methods, where they are needed.
  */
object Element {

  private class ArrayElement(override val contents: Array[String]) extends Element

  private class LineElement(s: String) extends Element {
    override val contents = Array(s)
    override val width: Int = s.length
    override val height = 1
  }

  private class UniformElement(ch: Char, override val width: Int, override val height: Int) extends Element {
    private val line = ch.toString * width

    override def contents: Array[String] = Array.fill(height)(line)
  }

  def apply(contents: Array[String]): Element = new ArrayElement(contents)

  def apply(chr: Char, width: Int, height: Int): Element = new UniformElement(chr, width, height)

  def apply(line: String): Element = new LineElement(line)
}