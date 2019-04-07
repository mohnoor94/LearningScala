package _010_functions

object _05_03_PartialFunctionsUtils extends App {

  val aPartialFunction: PartialFunction[Int, Int] = {
    case 1 => 10
    case 2 => 50
    case n if n < 10 => 100
  }

  println(s"aPartialFunction.isDefinedAt(1): ${aPartialFunction.isDefinedAt(1)}")
  println(s"aPartialFunction.isDefinedAt(100): ${aPartialFunction.isDefinedAt(100)}")

  println("*" * 10)

  println("we can lift the partial function to a full function:")

  val lifted: Int => Option[Int] = aPartialFunction.lift // Int => Int ===> Int => Option[Int]
  println(s"lifted(5): ${lifted(5)}")
  println(s"lifted(50): ${lifted(50)}")

  println("*" * 10)
  println("wanna do a chain of partial functions?")

  val chain1 = aPartialFunction.orElse[Int, Int] {
    case n if n < 100 => 1000
  }

  val anotherPF: PartialFunction[Int, Int] = {
    case n if n < 100 => 1000
  }

  val chain2 = aPartialFunction orElse anotherPF

  println(s"chain1(5): ${chain1(5)}")
  println(s"chain1(20): ${chain1(20)}")

  println(s"chain2(5): ${chain2(5)}")
  println(s"chain2(30): ${chain2(30)}")
}
