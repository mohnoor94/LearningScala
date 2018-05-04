package _06_pattern_matching

object _03_Lists extends App {
  def printList(list: List[Int]): Unit = list match {
    case Nil => println("Nil/Empty list")
    case List() => println("Nil/Empty list")
    case 1 :: 2 :: xs => println(s"list start with 1,2... and then: $xs")
    case _ :: Nil => println("list of length = 1")
    case List(_) => println("list of length = 1")
    case p :: ps => println(s"list with a head of $p and a tail of $ps")
  }

  printList(List())
  printList(Nil)
  printList(List(1, 2, 3, 4, 5))
  printList(List(1))
  printList(1 :: Nil)
  printList(1 :: 2 :: Nil)
  printList(List(3, 4, 5, 6, 7))
}