package _03_collections

object Ranges extends App {
  val r = 1 to 10 // include 10
  val r2 = 1 until 10 // exclude 10

  println(r)
  println(r2)

  println(r.head)
  println(r2.head)

  println(r.tail)
  println(r2.tail)

  println(r.last)
  println(r2.last)

  val r3 = 2 to 10 by 2
  println(r3)
  r3.foreach(e => print(s"$e, "))

  println()
  println()

  val r4 = 10 to 2 by -2
  println(r4)
  r4.foreach(e => print(s"$e, "))

  println()
  println()

  val r5 = 'a' to 'z'
  println(r5)
  r5.foreach(e => print(s"$e, "))

  println()
  println()

  val r6 = 'a' to 'z' by 2
  println(r6)
  r6.foreach(e => print(s"$e, "))

  println()
  println()

  val r7 = ('a' to 'z') ++ ('A' to 'Z')
  println(r7)
  r7.foreach(e => print(s"$e, "))

  println()
  println()

  val r8 = Range(1, 10)
  println(r8)

  val r9 = Range(1, 10, 2)
  println(r9)

  val r10 = Range.inclusive(1, 10)
  println(r10)

  val r11 = Range.inclusive(1, 10, 2)
  println(r11)

  val r12 = Range.inclusive(2, 10, 2)
  println(r12)

  println()
  println()
  println("=====================")
  println()
  println()

  for (i <- 1 to 10) println(i)
  println("==========")
  for (i <- 1 to 10 by 2) println(i)

}
