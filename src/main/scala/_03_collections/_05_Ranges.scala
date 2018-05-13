package _03_collections

object _05_Ranges extends App {
  val r = 1 to 10 // include 10
  val r2 = 1 until 10 // exclude 10

  println(s"r ==> $r")
  println(s"r2 ==> $r2")

  println(s"r.head: ${r.head}")
  println(s"r2.head: ${r2.head}")

  println(s"r.tail ==> ${r.tail}")
  println(s"r2.tail ==> ${r2.tail}")

  println(s"r.last: ${r.last}")
  println(s"r2.last: ${r2.last}")

  println("=====================")
  val r3 = 2 to 10 by 2
  println(s"r3 ==> $r3")

  print("r3.foreach(e => print(s\"$e, \")) ==> ")
  r3.foreach(e => print(s"$e, "))
  println

  println("=====================")

  val r4 = 10 to 2 by -2
  println(s"r4 ==> $r4")
  print("r4.foreach(e => print(s\"$e, \")) ==> ")
  r4.foreach(e => print(s"$e, "))
  println

  println("=====================")

  val r5 = 'a' to 'z'
  println(s"r5 ==> $r5")
  print("r5.foreach(e => print(s\"$e, \")) ==> ")
  r5.foreach(e => print(s"$e, "))
  println

  println("=====================")

  val r6 = 'a' to 'z' by 2
  println(s"r6 ==> $r6")
  print("r6.foreach(e => print(s\"$e, \")) ==> ")
  r6.foreach(e => print(s"$e, "))
  println

  println("=====================")

  val r7 = ('a' to 'z') ++ ('A' to 'Z')
  println(s"r7 ==> $r7")
  print("r7.foreach(e => print(s\"$e, \")) ==> ")
  r7.foreach(e => print(s"$e, "))
  println

  println("=====================")

  val r8 = Range(1, 10)
  println(s"r8 ==> $r8")
  print(s"r8.toList ==> ${r8.toList}")
  println

  val r9 = Range(1, 10, 2)
  println(s"r9 ==> $r9")
  print(s"r9.toList ==> ${r9.toList}")
  println

  val r10 = Range.inclusive(1, 10)
  println(s"r10 ==> $r10")
  print(s"r10.toList ==> ${r10.toList}")
  println

  val r11 = Range.inclusive(1, 10, 2)
  println(s"r11 ==> $r11")
  print(s"r11.toList ==> ${r11.toList}")
  println

  val r12 = Range.inclusive(2, 10, 2)
  println(s"r12 ==> $r12")
  print(s"r12.toList ==> ${r12.toList}")
  println

  println("=====================")

  for (i <- 1 to 10) print(s"$i ")
  println

  println("=====================")

  for (i <- 1 to 10 by 2) print(s"$i ")
  println
}