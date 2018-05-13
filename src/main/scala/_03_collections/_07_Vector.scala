package _03_collections

/**
  * For most purposes a Vector is preferable (over list), fast random access,
  * append, prepend, and updates. Lucky for us the methods
  * are very much the same
  */
object _07_Vector extends App {
  val vector = Vector(10, 11, 19)
  val vector2 = vector :+ 40
  val vector3 = 9 +: vector2

  println(s"vector ==> $vector")
  println(s"vector2 (vector :+ 40) ==> $vector2")
  println(s"vector3 (9 +: vector2) ==> $vector3")
}
