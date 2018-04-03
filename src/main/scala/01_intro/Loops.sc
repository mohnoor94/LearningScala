//val r1 = (1 to 100).reverse.mkString(", ")
//val r2 = (100 to 1 by -1).mkString(", ")
//
//
//println(r1)
//println(r2)


//var r1 = ""
//for (a <- 1 to 100) {
//  r1 += a
//  if (a < 100) r1 += ", "
//}
//println(r1)


val xs = List(1, 2, 3, 4, 5)
var r2 = List[Int]()

for (a <- xs) {
  r2 = r2 :+ (a + 1)
}
println(r2)

val r3 = for (a <- xs) yield a + 1
println(r3)