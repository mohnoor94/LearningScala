package _020_collections

/**
  * A Map is a collection of pairs, also known as Tuple2
  */
object _03_Maps_And_Symbols extends App {
  // all are the same!
  val m = Map.apply((1, "One"), (2, "Two"), (3, "Three"))
  val m2 = Map((1, "One"), (2, "Two"), (3, "Three"))
  val m3 = Map(1 -> "One", 2 -> "Two", 3 -> "Three")

  println(s"m3.get(2): ${m3.get(2)}") // return option <-- safe
  println(s"m3(2): ${m3(2)}") // return value <-- danger

  println(s"m3.get(5): ${m3.get(5)}") // None
  println(s"m3 get 5: ${m3 get 5}") // None
  //  println(m3(5)) // Exception


  println("==================")

  println(s"m3.toList ==> ${m3.toList}") // list of tuples
  println(s"m3.toSet ==> ${m3.toSet}") // set of tuples
  println(s"m3.keys ==> ${m3.keys}")
  println(s"m3.keySet ==> ${m3.keySet}")
  println(s"m3.values ==> ${m3.values}")
  println(s"m3.values.toList ==> ${m3.values.toList}")

  println("==================")

  val map = Map(1 -> "One", 2 -> "Two", 3 -> "Three")
  println(s"map ==> $map")
  print("map + (4 -> \"Four\") ==> ")
  println(map + (4 -> "Four"))

  println("==================")

  val s = new String("Co")
  val s2 = "Co"

  println(s"s == s2 ==> ${s == s2}") // true
  println(s"s eq s2 ==> ${s eq s2}") // false

  // Symbols guaranteed to be interned (to use same location in memory)
  val co = Symbol("Co")
  val co2 = 'Co

  println(s"co == co2 ==> ${co == co2}") // true
  println(s"co eq co2 ==> ${co eq co2}") // true

  println("==================")

  val elements: Map[Symbol, String] = Map('Co -> "Cobbalt", 'H -> "Helium", 'Pb -> "Lead")
  println(s"elements.get('Co): ${elements.get('Co)}")

  val elementsWithDefaultValue = elements withDefaultValue "Not Found!"

  def showElement(abbreviation: Symbol): String = elements get abbreviation match {
    case Some(element) => element
    case None => "Not Found!"
  }

  println(s"showElement('Co): ${showElement('Co)}")
  println(s"showElement('H): ${showElement('H)}")
  println(s"showElement('Hi): ${showElement('Hi)}")

  println("==================")
  println(s"elementsWithDefaultValue ==> $elementsWithDefaultValue")
  println(s"elementsWithDefaultValue('Co): ${elementsWithDefaultValue('Co)}")
  println(s"elementsWithDefaultValue('H): ${elementsWithDefaultValue('H)}")
  println(s"elementsWithDefaultValue('Hi): ${elementsWithDefaultValue('Hi)}")
}