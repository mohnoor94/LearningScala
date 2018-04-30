package _04_collections_with_functions

import scala.language.postfixOps

object _01_MapFunction extends App {
  val a = (1 to 5).toList
  val f = (x: Int) => x + 1
  println(a)
  println("*******************")
  println(a.map(f))
  println(a.map((x: Int) => x + 1))
  println(a.map(x => x + 1))
  println(a.map(_ + 1))
  println(a.map(1 + _))
  println(a.map(1 +))

  println()

  println(a map (x => x * x))

  println()

  val b = Set("Brown", "Red", "Green", "purple", "Gray", "Yellow")
  println(b)
  println("********************************************")
  println(b.map(x => x.length))
  println(b.map(_.length))
  println("***************")
  println(b.map(x => (x, x.length)))
  println("***************")

  println()
  println()

  val fifaMensChamps = Map('Germany -> 4, 'Brazil -> 5, 'Italy -> 4, 'Argentina -> 2)
  println(fifaMensChamps.map(t => (Symbol("Team " + t._1.name), t._2)))

  println()
  println()

  println("Hello!".map(x => (x + 1).toChar))

  println(Some(4).map(1 +))

  println(None.asInstanceOf[Option[Int]].map(1 +))

  val age: Option[Int] = None
  println(age.map(1 +))
}