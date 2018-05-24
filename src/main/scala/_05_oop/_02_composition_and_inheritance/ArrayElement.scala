package _05_oop._02_composition_and_inheritance

/**
  * 10.4 EXTENDING CLASSES
  * >> Inheritance means that all members of the superclass are also members of the subclass, with two exceptions.
  * First, private members of the superclass are not inherited in a subclass. Second, a member of a superclass is not
  * inherited if a member with the same name and parameters is already implemented in the subclass. In that case we say
  * the member of the subclass overrides the member of the superclass. If the member in the subclass is concrete and the
  * member of the superclass is abstract, we also say that the concrete member implements the abstract one.
  *
  * >> Subtyping means that a value of the subclass can be used wherever a value of the superclass is required.
  * e.g, val e: Element = new ArrayElement(Array("hello"))
  *
  * >> Composition relationship that exists between ArrayElement and Array[String]. This relationship is called
  * composition because class ArrayElement is "composed" out of class Array[String], in that the Scala compiler will
  * place into the binary class it generates for ArrayElement a field that holds a reference to the passed 'contents'
  * array.
  *
  *
  * 10.5 OVERRIDING METHODS AND FIELDS
  * >> The uniform access principle is just one aspect where Scala treats fields and methods more uniformly than Java.
  * Another difference is that in Scala, fields and methods belong to the same namespace. This makes it possible for a
  * field to override a parameterless method. For instance, you could change the implementation of contents in class
  * ArrayElement from a method to a field without having to modify the abstract method definition of contents in class
  * 'Element'.
  *
  * ▶ In Scala it is forbidden to define a field and method with the same name in the same class, whereas this is
  * allowed in Java.
  *
  * ▶ Generally, Scala has just two namespaces for definitions in place of Java's four.
  * 	• Java's four namespaces are fields, methods, types, and packages.
  * By contrast, Scala's two namespaces are:
  * 	• values (fields, methods, packages, and singleton objects)
  * 	• types (class and trait names)
  * The reason Scala places fields and methods into the same namespace is precisely so you can override a parameterless
  * method with a val, something you can't do with Java.
  *
  *
  * 10.6 DEFINING PARAMETRIC FIELDS
  * ▶ Parametric Field (like val contents below) is a shorthand that defines at the same time a parameter and field
  * with the same name.
  * >> You can also prefix a class parameter with var, in which case the corresponding field would be reassignable.
  * >> It is possible to add modifiers, such as private, protected or override to these parametric fields.
  * e.g,
  * ``
  * class Cat {
  * val dangerous = false
  * }
  * class Tiger (override val dangerous: Boolean, private var age: Int) extends Cat
  * ``
  *
  *
  * >>!!>> The implementation moved to Element object in section (10.13 DEFINING A FACTORY OBJECT)
  */
//class ArrayElement (override val contents: Array[String]) extends Element {
//}