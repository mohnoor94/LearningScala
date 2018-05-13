package _03_collections

import scala.collection.LinearSeq

/**
  * If you have tried Scala, you have definitely encountered a Seq.
  * A Seq is a base trait for sequences which are iterables with order.
  * There are two subtraits of a Seq:
  *      - IndexedSeq : fast random access, fast length
  *      - LinearSeq : fast head, fast tail, fast empty operations
  * The current default Seq when instantiated is a List
  * The current default IndexedSeq is a Vector
  * The current default LinearSeq is a List
  */
object _08_Seq extends App {
  println(s"Seq(30,50,100) ==> ${Seq(30, 50, 100)}")
  println(s"IndexedSeq(30,50,100) ==> ${IndexedSeq(30, 50, 100)}")
  println(s"LinearSeq(30,50,100) ==> ${LinearSeq(30, 50, 100)}")
}