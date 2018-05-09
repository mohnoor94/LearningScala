package _06_pattern_matching

object _12_Example_MySecond extends App {
  def mySecond[A](xs: List[A]): Option[A] =
    xs match {
      case _ :: y :: _ => Some(y)
      case _ => None
    }

  println("mySecond:")
  println(mySecond(Nil))
  println(mySecond(List(1)))
  println(mySecond(List(1, 2)))
  println(mySecond(List(1, 2, 3)))
  println("=============================\n")


  def mySecondStream[A](xs: Stream[A]): Option[A] =
    xs match {
      case _ #:: y #:: _ => Some(y)
      case _ => None
    }

  println("mySecondStream:")
  println(mySecondStream(Stream.empty))
  println(mySecondStream(Stream.from(10)))
  println(mySecondStream(Stream.from(10, 2)))
}