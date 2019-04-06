package _991_syntax_sugar

object SettersAndGetters extends App {

  class MutableThing {
    private var internal: Int = 0

    def value: Int = internal // "getter"
    def value_=(value: Int): Unit = // "setter" (same name as getter with _ at the end)
      internal = value
  }

  val thing = new MutableThing
  println(thing.value)
  thing.value = 25
  println(thing.value)
}
