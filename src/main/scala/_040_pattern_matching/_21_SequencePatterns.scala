package _040_pattern_matching

// variable patterns, you do not how many variables you want to return from your pattern
object _21_SequencePatterns {

  abstract class MyList[+A] {
    def head: A = ???

    def tail: MyList[A] = ???
  }

  case object Empty extends MyList[Nothing]

  case class Cons[+A](override val head: A, override val tail: MyList[A]) extends MyList[A]

  object MyList {
    def unapplySeq[A](list: MyList[A]): Option[Seq[A]] = { // return Option of Seq
      if (list == Empty) Some(Seq.empty)
      else unapplySeq(list.tail).map(list.head +: _)
    }
  }

  def main(args: Array[String]): Unit = {

    val decompose: MyList[Int] => String = {
      case MyList(1, 2, _*) => "starting with 1, 2"
      case MyList(1, _*) => "starting with 1"
      case _ => "something else"
    }

    println(decompose(Cons(1, Cons(2, Cons(3, Empty)))))
    println(decompose(Cons(1, Cons(5, Cons(9, Empty)))))
    println(decompose(Cons(7, Cons(5, Cons(9, Empty)))))
  }
}
