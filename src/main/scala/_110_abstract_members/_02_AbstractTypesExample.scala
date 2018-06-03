package _110_abstract_members

/**
  * Main Resource: Chapter 20 - Abstract Member, From Programming in Scala, Third Edition.
  * 20.6 ABSTRACT TYPES
  *
  *
  */
object _02_AbstractTypesExample {

  class Food

  abstract class Animal {
    type SuitableFood <: Food

    def eat(food: SuitableFood)
  }

  class Grass extends Food

  class Fish extends Food

  class Cow extends Animal {
    type SuitableFood = Grass

    override def eat(food: Grass): Unit = {}
  }

  def main(args: Array[String]): Unit = {
    val bessy: Animal = new Cow
    // bessy eat new Fish // error: type mismatch; found: Fish; required: bessy.SuitableFood
    // new Cow eat new Fish // error: type mismatch; found: Fish; required: bessy.SuitableFood
    new Cow eat new Grass // OK
  }
}