package _03_collections

import scala.collection.immutable.Queue

/**
  * Whereas a List is a LIFO, a Queue is a FIFO just like a
  * line at a grocery store. The queue internally has two sections,
  * an in collection and an out collection. When out runs out, out
  * becomes an in.reverse and out replaced with Nil. This is called a
  * pivot
  */
object _09_Queues extends App {
  val queue = Queue(1, 2, 3, 4)

  println(s"queue ==> $queue")
  println(s"queue.enqueue(5) ==> ${queue.enqueue(5)}")
  println(s"queue.dequeue ==> ${queue.dequeue}")
}