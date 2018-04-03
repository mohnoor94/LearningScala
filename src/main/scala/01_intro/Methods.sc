import scala.annotation.tailrec

def add(x: Int, y: Int): Int = x + y

println(add(10, 20))

@tailrec
def draw(acc: String): Unit = {
  println(acc) // this is a side effect!
  if (acc != "") draw(acc.substring(0, acc.length - 1))
  else ()
}

draw("*#*#*#*#**#*#*#*#*#*")


def factorial(n: Int) = {
  @tailrec
  def fact(n: BigInt, acc: BigInt): BigInt = {
    if (n == 0 || n == 1) acc
    else fact(n - 1, acc * n)
  }

  fact(n, 1)
}

println(factorial(1))
println(factorial(5))
//println(factorial(10))
//println(factorial(100))
//println(factorial(1000))
//println(factorial(10000))
//println(factorial(100000))


def ++(x: Double, y: Double): Double = x + y

def isThisLegal_? = true

println(isThisLegal_?)

println(++(3.5, 10.6))


// Named Arguments
def processNumbers(b: Boolean, x: Int, y: Int) = if (b) x else y

println(processNumbers(true, 10, 5))
println(processNumbers(false, 10, 5))
println(processNumbers(x = 15, b = false, y = 5))
println(processNumbers(x = 5, b = false, y = 15))


// Default Arguments
def add2(x: Int, y: Int = 0) = x + y

println(add2(10))
println(add2(10, 20))

// Named and Default Arguments
def processNumbers2(b: Boolean = true, x: Int, y: Int) = if (b) x else y

println(processNumbers2(x = 5, y = 10))




println(3.isInstanceOf[Int])

val g: Any = "Ice"
println(g)
println(g.isInstanceOf[String])
println(g.asInstanceOf[String])



// Parametrized Types on Methods
def decide[T](b: Boolean, x: T, y: T): T = if (b) x else y

println(decide(true, 5, 10))
println(decide(false, 5, 10))
println(decide[Int](false, 5, 10))
println(decide[Double](false, 50, 10))
println(decide(false, 50, 1.40))