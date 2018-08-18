package _980_problem_solving

/**
  * Problem: Print the numbers 1 - 100, but if the number is:
  *  - divisible by 3 -> print 'Fizz'
  *  - divisible by 5 -> print 'Buzz'
  *  - divisible by 3 and 5 -> print 'FizzBuzz'
  * instead of the number.
  */
object FizzBuzz {

  def fizzBuzz0(range: Range): Unit = {
    range.foreach(i => {
      if (i % 3 == 0 && i % 5 == 0)
        println("FizzBuzz")
      else if (i % 3 == 0)
        println("Fizz")
      else if (i % 5 == 0)
        println("Buzz")
      else
        println(i)
    })
  }

  def fizzBuzz1(range: Range): Unit = {
    for (i <- range) {
      println {
        if (i % 15 == 0) "FizzBuzz"
        else if (i % 3 == 0) "Fizz"
        else if (i % 5 == 0) "Buzz"
        else i
      }
    }
  }

  def fizzBuzz2(range: Range): Unit = {
    range.foreach(i => println((i % 3, i % 5) match {
      case (0, 0) => "FizzBuzz"
      case (0, _) => "Fizz"
      case (_, 0) => "Buzz"
      case _ => i
    }))
  }

  def fizzBuzz3(range: Range): Unit = {
    def isDivisibleBy(divisor: Int, result: Int => String): PartialFunction[Int, String] = {
      case i if i % divisor == 0 => result(i)
    }

    val f3 = isDivisibleBy(3, _ => "Fizz")
    val f5 = isDivisibleBy(5, _ => "Buzz")
    val f15 = isDivisibleBy(15, x => f3(x) + f5(x))
    val id = isDivisibleBy(1, _.toString)

    val fizzBuzz = f15 orElse f3 orElse f5 orElse id
    range.map(fizzBuzz andThen println)
  }

  def fizzBuzz4(i: Int): String = {
    if (i % 15 == 0) "FizzBuzz"
    else if (i % 3 == 0) "Fizz"
    else if (i % 5 == 0) "Buzz"
    else s"$i"
  }

  def main(args: Array[String]): Unit = {
    //    fizzBuzz0(1 to 100)
    //    fizzBuzz1(1 to 100)
    //    fizzBuzz2(1 to 100)
    //    fizzBuzz3(1 to 100)
    (1 to 100).foreach(i => println(fizzBuzz4(i)))
  }
}
