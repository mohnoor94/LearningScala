package _06_pattern_matching

object _11_Example_Replicate extends App {
  def replicate[A](count: Int, a: A): List[A] =
    count match {
      case 0 => Nil
      case _ => a :: replicate(count - 1, a)
    }

  println("replicate:")
  println(replicate(5, "yay"))
  println(replicate(5, 10))
  println("=============================\n")

  def replicateTailRecursive[A](count: Int, a: A): List[A] = {
    import scala.annotation.tailrec
    @tailrec
    def replHelper(c: Int, acc: List[A]): List[A] =
      c match {
        case 0 => acc
        case _ => replHelper(c - 1, a :: acc)
      }

    replHelper(count, Nil)
  }

  println("replicateTailRecursive:")
  println(replicateTailRecursive(5, "yay"))
  println(replicateTailRecursive(5, 10))
  println("=============================\n")
}