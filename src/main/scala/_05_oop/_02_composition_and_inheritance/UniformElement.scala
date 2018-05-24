package _05_oop._02_composition_and_inheritance

/**
  * 10.9 POLYMORPHISM AND DYNAMIC BINDING
  * >> You saw in Section 10.4 that a variable of type Element could refer to an object of type ArrayElement. The name
  * for this phenomenon is polymorphism, which means "many shapes" or "many forms." In this case, Element objects can
  * have many forms.
  *
  * >> As a result of the inheritance hierarchy for class Element, Scala will accept all of the following assignments,
  * because the type of the assigning expression conforms to the type of the defined variable:
  * - val e1: Element = new ArrayElement(Array("hello", "world"))
  * - val ae: ArrayElement = new LineElement("hello")
  * - val e2: Element = ae
  * - val e3: Element = new UniformElement('x', 2, 3)
  *
  * ▶ The other half of the story, however, is that method invocations on variables and expressions are dynamically bound.
  * This means that the actual method implementation invoked is determined at run time based on the class of the object,
  * not the type of the variable or expression.
  *
  *
  * >>!!>> The implementation moved to Element object in section (10.13 DEFINING A FACTORY OBJECT)
  */
//class UniformElement(ch: Char, override val width: Int, override val height: Int) extends Element {
//  private val line = ch.toString * width
//  override def contents: Array[String] = Array.fill(height)(line)
//}