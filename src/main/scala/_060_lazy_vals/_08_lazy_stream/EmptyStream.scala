package _060_lazy_vals._08_lazy_stream

object EmptyStream extends MyStream[Nothing] {
  override def isEmpty: Boolean = true

  override def head: Nothing = throw new NoSuchElementException("No head on empty stream!")

  override def tail: MyStream[Nothing] = throw new NoSuchElementException("No tail on empty stream!")

  override def #::[B >: Nothing](element: B): MyStream[B] = new Cons[B](element, this)

  override def ++[B >: Nothing](anotherStream: MyStream[B]): MyStream[B] = anotherStream

  override def foreach(f: Nothing => Unit): Unit = ()

  override def map[B](f: Nothing => B): MyStream[B] = this

  override def flatMap[B](f: Nothing => MyStream[B]): MyStream[B] = this

  override def filter(predicate: Nothing => Boolean): MyStream[Nothing] = this

  override def take(n: Int): MyStream[Nothing] = this

  override def takeAsList(n: Int): List[Nothing] = List.empty[Nothing]
}