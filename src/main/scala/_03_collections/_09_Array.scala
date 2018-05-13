package _03_collections

/**
  * An array is a java based array with a Scala wrapper
  * around it to perform the functionality
  */
object _09_Array extends App {
  val arr = Array(1, 2, 3, 4, 5)

  // I'm using the toList only to show the members of the array
  println(s"arr.toList: ${arr.toList}")
  println(s"arr.reverse.toList: ${arr.reverse.toList}")
  println(s"arr.getClass.getSimpleName: ${arr.getClass.getSimpleName}")
}