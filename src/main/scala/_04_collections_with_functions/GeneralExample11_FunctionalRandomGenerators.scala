package _04_collections_with_functions

trait Generator[+T] {
  self => // an alias for 'this'
  def generate: T

  def map[S](f: T => S): Generator[S] = new Generator[S] {
    override def generate: S = f(self.generate)
  }

  def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
    override def generate: S = f(self.generate).generate
  }
}

object GeneralExample11_FunctionalRandomGenerators {
  val integers: Generator[Int] = new Generator[Int] {
    val rand = new java.util.Random

    def generate: Int = rand.nextInt()
  }

  val booleans: Generator[Boolean] = new Generator[Boolean] {
    def generate: Boolean = integers.generate > 0
  }

  // we have to add 'map' to 'Generator' so we can do this!
  val booleansUsingFor: Generator[Boolean] = for (x <- integers) yield x > 0

  // booleansUsingFor will be expanded (by the compiler) to:
  val expandedBooleansUsingFor: Generator[Boolean] = integers map (_ > 0)

  val integerPairs: Generator[(Int, Int)] = new Generator[(Int, Int)] {
    def generate: (Int, Int) = (integers.generate, integers.generate)
  }

  // we have to add 'map' and 'flatMap' to 'Generator'
  // so we can do this!
  def pairs[T, U](t: Generator[T], u: Generator[U]): Generator[(T, U)] = for {
    x <- t
    y <- u
  } yield (x, y)

  // pairs will be expanded (by the compiler) to:
  def expandedPairs[T, U](t: Generator[T], u: Generator[U]): Generator[(T, U)] =
    t flatMap (x => u map (y => (x, y)))


  // other generators...
  def single[T](x: T): Generator[T] = new Generator[T] {
    override def generate: T = x
  }

  def choose(low: Int, high: Int): Generator[Int] =
    for (x <- integers) yield low + math.abs(x) % (high - low)

  def oneOf[T](xs: T*): Generator[T] =
    for (idx <- choose(0, xs.length)) yield xs(idx)


  // A List Generator

  def lists: Generator[List[Int]] = for {
    isEmpty <- booleans
    list <- if (isEmpty) emptyLists else nonEmptyLists
  } yield list

  def emptyLists: Generator[Nil.type] = single(Nil)

  def nonEmptyLists: Generator[List[Int]] = for {
    head <- integers
    tail <- lists
  } yield head :: tail


  // A Tree Generator
  trait Tree

  case class Inner(left: Tree, right: Tree) extends Tree

  case class Leaf(x: Int) extends Tree

  def trees: Generator[Tree] = for {
    isLeaf <- booleans
    tree <- if (isLeaf) leafs else inners
  } yield tree

  def leafs: Generator[Leaf] = for {
    x <- integers
  } yield Leaf(x)

  def inners: Generator[Inner] = for {
    l <- trees
    r <- trees
  } yield Inner(l, r)


  // Test Generator!
  // A more advance version of this is implemented in ScalaCheck
  def test[T](r: Generator[T], numOfTimes: Int = 100)(test: T => Boolean): Unit = {
    for (_ <- 0 until numOfTimes) {
      val value = r.generate
      assert(test(value), "Test failed for: " + value)
    }
    println(s"Test passed: $numOfTimes times")
  }

  def main(args: Array[String]): Unit = {
    println("integers")
    println(integers.generate)
    println(integers.generate)
    println(integers.generate)
    println
    println("booleans")
    println(booleans.generate)
    println(booleans.generate)
    println(booleans.generate)
    println
    println("integerPairs")
    println(integerPairs.generate)
    println(integerPairs.generate)
    println(integerPairs.generate)
    println
    println("booleansUsingFor")
    println(booleansUsingFor.generate)
    println(booleansUsingFor.generate)
    println(booleansUsingFor.generate)
    println
    println("expandedBooleansUsingFor")
    println(expandedBooleansUsingFor.generate)
    println(expandedBooleansUsingFor.generate)
    println(expandedBooleansUsingFor.generate)
    println
    println("pairs(integers, booleans)")
    println(pairs(integers, booleans).generate)
    println(pairs(integers, booleans).generate)
    println(pairs(integers, booleans).generate)
    println
    println("expandedPairs(integers, booleans)")
    println(expandedPairs(integers, booleans).generate)
    println(expandedPairs(integers, booleans).generate)
    println(expandedPairs(integers, booleans).generate)
    println
    println("single(10)")
    println(single(10).generate)
    println(single(10).generate)
    println(single(10).generate)
    println
    println("choose(-500, 500)")
    println(choose(-500, 500).generate)
    println(choose(-500, 500).generate)
    println(choose(-500, 500).generate)
    println
    println("oneOf(\"Red\", \"Green\", \"Blue\")")
    println(oneOf("Red", "Green", "Blue").generate)
    println(oneOf("Red", "Green", "Blue").generate)
    println(oneOf("Red", "Green", "Blue").generate)
    println
    println("lists")
    println(lists.generate)
    println(lists.generate)
    println(lists.generate)
    println
    println("trees.generate")
    println(trees.generate)
    println(trees.generate)
    println(trees.generate)
    println
    println
    println
    println("test(pairs(lists, lists))")
    //    test(pairs(lists, lists)) {
    //      case (xs, ys) => (xs ++ ys).length > xs.length
    //    } // will fail with exception
  }
}
