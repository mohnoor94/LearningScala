package _05_oop

/**
  * Chapter 11 - Scala's Hierarchy
  * From: Programming in Scala, Third Edition
  *
  * In Scala, every class inherits from a common superclass named Any. Because every class is a subclass of Any, the
  * methods defined in Any are "universal" methods: they may be invoked on any object. Scala also defines some
  * interesting classes at the bottom of the hierarchy, Null and Nothing, which essentially act as common subclasses.
  * For example, just as Any is a superclass of every other class, Nothing is a subclass of every other class.
  *
  *
  * 11.1 SCALA'S CLASS HIERARCHY
  * At the top of the hierarchy is class Any, which defines methods that include the following:
  * -> final def ==(that: Any): Boolean
  * -> final def !(that: Any): Boolean
  * -> def equals(that: Any): Boolean
  * -> def ##: Int
  * -> def hashCode: Int
  * -> def toString: String
  * Because every class inherits from Any, every object in a Scala program can be compared using ==, !=, or equals;
  * hashed using ## or hashCode; and formatted using toString. The equality and inequality methods, == and !=, are
  * declared final in class Any, so they cannot be overridden in subclasses. The == method is essentially the same as
  * equals and != is always the negation of equals. So individual classes can tailor what == or != means by overriding
  * the equals method.
  * @see https://docs.scala-lang.org/tour/unified-types.html
  *
  * >> The root class Any has two subclasses: AnyVal and AnyRef. AnyVal is the parent class of value classes in Scala.
  * While you can define your own value classes, there are nine value classes built into Scala: Byte, Short, Char, Int,
  * Long, Float, Double, Boolean, and Unit. The first eight of these correspond to Java's primitive types, and their
  * values are represented at run time as Java's primitive values. The instances of these classes are all written as
  * literals in Scala. For example, 42 is an instance of Int, 'x' is an instance of Char, and false an instance of
  * Boolean. You cannot create instances of these classes using new. This is enforced by the "trick" that value classes
  * are all defined to be both abstract and final.
  * >> The other value class, Unit, corresponds roughly to Java's void type; it is used as the result type of a method
  * that does not otherwise return an interesting result. Unit has a single instance value, which is written ().
  *
  * @see '_01_AnyValExamples' object for more.
  *
  * >> The other subclass of the root class Any is class AnyRef. This is the base class of all reference classes in Scala.
  * As mentioned previously, on the Java platform AnyRef is in fact just an alias for class java.lang.Object. So classes
  * written in Java, as well as classes written in Scala, all inherit from AnyRef. One way to think of java.lang.Object,
  * therefore, is as the way AnyRef is implemented on the Java platform. Thus, although you can use Object and AnyRef
  * interchangeably in Scala programs on the Java platform, the recommended style is to use AnyRef everywhere.
  *
  *
  * 11.2 HOW PRIMITIVES ARE IMPLEMENTED
  * >> How is all this implemented? In fact, Scala stores integers in the same way as Java—as 32-bit words. This is
  * important for efficiency on the JVM and also for interoperability with Java libraries. Standard operations like
  * addition or multiplication are implemented as primitive operations. However, Scala uses the "backup" class
  * java.lang.Integer whenever an integer needs to be seen as a (Java) object. This happens for instance when invoking
  * the toString method on an integer number or when assigning an integer to a variable of type Any. Integers of type
  * Int are converted transparently to "boxed integers" of type java.lang.Integer whenever necessary.
  *
  * @see '_02_AnyRefExamples' object
  *
  *
  * 11.3 BOTTOM TYPES
  * @see '_03_NullAndNothing'
  *
  *
  * 11.4 DEFINING YOUR OWN VALUE CLASSES
  * @see '_04_1_DefiningYourOwnValueClasses' and '_04_2_DefiningYourOwnValueClasses'
  *
  *
  * Notes:
  * ▶ The only case where == does not directly call equals is for Java's boxed numeric classes, such as Integer or Long.
  * In Java, a new Integer(1) does not equal a new Long(1) even though for primitive values 1 == 1L. Since Scala is a
  * more regular language than Java, it was necessary to correct this discrepancy by special-casing the == method for
  * these classes. Likewise, the ## method provides a Scala version of hashing that is the same as Java's hashCode,
  * except for boxed numeric types, where it works consistently with ==. For instance new Integer(1) and new Long(1)
  * hash the same with ## even though their Java hashCodes are different.
  *
  * ▶ The reason AnyRef alias exists, instead of just using the name java.lang.Object, is because Scala was originally
  * designed to work on both the Java and .NET platforms. On .NET, AnyRef was an alias for System.Object.
  */
package object _03_scala_hierarchy {
}