package _05_oop

object Traits_03_Example03_DiamondOfDeath extends App {
  var list = List[String]()

  trait T1 {
    list = list :+ "Instantiated T1"
  }

  trait T2 extends T1 {
    list = list :+ "Instantiated T2"
  }

  trait T3 extends T1 {
    list = list :+ "Instantiated T3"
  }

  trait T4 extends T1 {
    list = list :+ "Instantiated T4"
  }

  class C1 extends T2 with T3 with T4 {
    list = list :+ "Instantiated C1"
  }

  list = list :+ "Creating C1"
  new C1
  list = list :+ "Created C1"

  println(list)
}
