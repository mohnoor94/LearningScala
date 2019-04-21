package _060_lazy_vals._08_lazy_stream

// IMPORTANT: tail IS A BY NAME PARAMETER!
class Cons[+A](hd: A, tl: => MyStream[A]) extends MyStream[A] {
  override def isEmpty: Boolean = false

  // it's now a val! (evaluated once)
  override val head: A = hd

  // it's now a lazy val! (call by need)
  override lazy val tail: MyStream[A] = tl

  override def #::[B >: A](element: B): MyStream[B] = new Cons[B](element, this)

  override def ++[B >: A](anotherStream: MyStream[B]): MyStream[B] = new Cons[B](head, tail ++ anotherStream)

  override def foreach(f: A => Unit): Unit = {
    f(head)
    tail foreach f
  }

  override def map[B](f: A => B): MyStream[B] = new Cons[B](f(head), tail map f)

  override def flatMap[B](f: A => MyStream[B]): MyStream[B] = f(head) ++ (tail flatMap f)

  override def filter(predicate: A => Boolean): MyStream[A] = {
    if (predicate(head)) new Cons[A](head, tail filter predicate)
    else tail filter predicate
  }

  override def take(n: Int): MyStream[A] = ??? // TODO

  override def takeAsList(n: Int): List[A] = ??? // TODO
}
