package _036_abstract_members

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

  class DogFood extends Food


  class Cow extends Animal {
    type SuitableFood = Grass

    override def eat(food: Grass): Unit = {
      println(s"A cow ate a ${food.getClass.getSimpleName}")
    }
  }

  class Dog extends Animal {
    type SuitableFood = DogFood

    override def eat(food: DogFood): Unit = {
      println(s"A dog ate a ${food.getClass.getSimpleName}")
    }
  }

  def main(args: Array[String]): Unit = {
    val bessy: Animal = new Cow
    // bessy eat new Fish // error: type mismatch; found: Fish; required: bessy.SuitableFood
    // new Cow eat new Fish // error: type mismatch; found: Fish; required: bessy.SuitableFood
    new Cow eat new Grass // OK

    //...

    val sarah = new Cow
    val lassie = new Dog
    val bootsie = new Dog
    // lassie eat (new sarah.SuitableFood) // error: type mismatch;  found   : Grass;  required: DogFood
    lassie eat new DogFood
    lassie eat new lassie.SuitableFood
    lassie eat new bootsie.SuitableFood
  }
}