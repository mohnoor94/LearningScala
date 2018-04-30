package _03_collections

object _03_Maps_And_Symbols extends App {
  // all are the same!
  val m = Map.apply((1, "One"), (2, "Two"), (3, "Three"))
  val m2 = Map((1, "One"), (2, "Two"), (3, "Three"))
  val m3 = Map(1 -> "One", 2 -> "Two", 3 -> "Three")

  println(m3.get(2)) // return option <-- safe
  println(m3(2)) // return value <-- danger

  println(m3.get(5)) // None
  println(m3 get 5) // None
  //  println(m3(5)) // Exception


  println("==================")

  println(m3.toList) // list of tuples
  println(m3.toSet) // set of tuples
  println(m3.keys)
  println(m3.keySet)
  println(m3.values)
  println(m3.values.toList)

  println("==================")

  val s = new String("Co")
  val s2 = "Co"

  println(s == s2) // true
  println(s eq s2) // false

  // Symbols guaranteed to be interned
  val co = Symbol("Co")
  val co2 = 'Co

  println(co == co2) // true
  println(co eq co2) // true

  println("==================")

  val elements: Map[Symbol, String] = Map('Co -> "Cobbalt", 'H -> "Helium", 'Pb -> "Lead")
  println(elements.get('Co))

  val elementsWithDefaultValue = elements withDefaultValue "Not Found!"

  def showElement(abbreviation: Symbol): String = elements get abbreviation match {
    case Some(element) => element
    case None => "Not Found!"
  }

  println(showElement('Co))
  println(showElement('H))
  println(showElement('Hi))

  println("==================")
  println(elementsWithDefaultValue)
  println(elementsWithDefaultValue('Co))
  println(elementsWithDefaultValue('H))
  println(elementsWithDefaultValue('Hi))

}