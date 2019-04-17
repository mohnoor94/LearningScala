package _021_collections_with_functions.my_set

/**
  * This is to implement a Set using functions!
  */
object Test extends App {

  val s = MySet(1, 2, 3, 4, 5)

  println("The set:")
  s.foreach(e => print(s"$e, "))
  println()

  println("+10:")
  s + 10 foreach (e => print(s"$e, "))
  println()

  println("++ MySet(4, 5, 7):")
  s + 10 ++ MySet(4, 5, 7) foreach (e => print(s"$e, "))
  println()

  println("+5:")
  s + 10 ++ MySet(4, 5, 7) + 5 foreach (e => print(s"$e, "))
  println("\n")

  println("map:")
  s.map(10 *).foreach(e => print(s"$e, "))
  println()

  println("flatMap:")
  s.flatMap(e => MySet(e, 10 * e)).foreach(e => print(s"$e, "))
  println()

  println("filter:")
  s filter (_ % 2 == 0) foreach (e => print(s"$e, "))
  println("\n")

  println("remove:")
  s - 5 foreach (e => print(s"$e, "))
  println()
  s - 50 foreach (e => print(s"$e, "))
  println()


  val s2 = MySet(4, 5, 6, 7)
  println("diff:")
  s -- s2 foreach (e => print(s"$e, "))
  println()
  println("intersection:")
  s & s2 foreach (e => print(s"$e, "))
  println()

  //////////////////////////////////////////////////////////////////////
  println("//" * 50)
  println()

  val negative = !s // s.unary_!= all natural numbers not equal to 1,2,3, or 4
  println(negative(2))
  println(negative(20))
  println(negative(200))
  println(negative(5))
  println()

  val negativeEven = negative.filter(_ % 2 == 0)
  println(negativeEven(2))
  println(negativeEven(20))
  println(negativeEven(205))
  println(negativeEven(5))
  println()

  val negativeEvenPlus5 = negativeEven + 5
  println(negativeEvenPlus5(2))
  println(negativeEvenPlus5(20))
  println(negativeEvenPlus5(205))
  println(negativeEvenPlus5(5))
  println()

  val threes = new PropertyBasedSet[Int](_ % 3 == 0)
  println(threes(0))
  println(threes(3))
  println(threes(-6))
  println(threes(100))
  println(threes(1))
  println(threes(-2))
}
