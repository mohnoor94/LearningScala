package _05_oop._04_traits

import scala.collection.mutable.ArrayBuffer

/**
  * 12.5 TRAITS AS STACKABLE MODIFICATIONS
  *
  * > You have now seen one major use of traits: turning a thin interface into a rich one.
  * > Now we'll turn to a second major use: providing stackable modifications to classes.
  * Traits let you modify the methods of a class, and they do so in a way that allows you to stack those modifications
  * with each other.
  */
object _03_TraitsAsStackableModifications {

  abstract class IntQueue {
    def get(): Int

    def put(x: Int)
  }

  /**
    * > The Doubling trait has two funny things going on:
    * - The first is that it declares a superclass, IntQueue. This declaration means that the trait can only be mixed
    * into a class that also extends IntQueue. Thus, you can mix Doubling into BasicIntQueue, but not into Rational.
    * - The second funny thing is that the trait has a super call on a method declared abstract. Such calls are illegal
    * for normal classes because they will certainly fail at run time. For a trait, however, such a call can actually
    * succeed. Since super calls in a trait are dynamically bound, the super call in trait Doubling will work so long as
    * the trait is mixed in after another trait or class that gives a concrete definition to the method.
    *
    * > This arrangement is frequently needed with traits that implement stackable modifications. To tell the compiler
    * you are doing this on purpose, you must mark such methods as abstract override. This combination of modifiers is
    * only allowed for members of traits, not classes, and it means that the trait must be mixed into some class that
    * has a concrete definition of the method in question.
    *
    * >> The order of mixins is significant. The precise rules are given in the following section, but, roughly speaking,
    * traits further to the right take effect first. When you call a method on a class with mixins, the method in the
    * trait furthest to the right is called first. If that method calls super, it invokes the method in the next trait
    * to its left, and so on. Check q1 & q2 examples below!
    */
  trait Doubling extends IntQueue {
    abstract override def put(x: Int): Unit = super.put(2 * x)
  }

  trait Incrementing extends IntQueue {
    abstract override def put(x: Int): Unit = super.put(x + 1)
  }

  trait Filtering extends IntQueue {
    abstract override def put(x: Int): Unit = if (x >= 0) super.put(x)
  }

  class BasicIntQueue extends IntQueue {
    private val buf = new ArrayBuffer[Int]

    def get(): Int = buf.remove(0)

    def put(x: Int): Unit = buf += x
  }

  /** Note that MyQueue defines no new code. It simply identifies a class and mixes in a trait. **/
  class MyQueue extends BasicIntQueue with Doubling

  def main(args: Array[String]): Unit = {
    val queue = new BasicIntQueue
    queue.put(-10)
    queue.put(20)
    println(s"queue.get(): ${queue.get()}")
    println(s"queue.get(): ${queue.get()}")
    println()

    val myQueue = new MyQueue
    myQueue.put(-10)
    myQueue.put(20)
    println(s"myQueue.get(): ${myQueue.get()}")
    println(s"myQueue.get(): ${myQueue.get()}")
    println()

    // You could supply "BasicIntQueue with Doubling" directly to new instead of defining a named class.
    val queueWithDoubling = new BasicIntQueue with Doubling
    queueWithDoubling.put(-10)
    queueWithDoubling.put(20)
    println(s"queueWithDoubling.get(): ${queueWithDoubling.get()}")
    println(s"queueWithDoubling.get(): ${queueWithDoubling.get()}")
    println()


    // ORDER MATTERS examples:
    // You can now pick and choose which traits you want for a particular queue.
    val q1 = new BasicIntQueue with Incrementing with Filtering
    q1.put(-1)
    q1.put(0)
    q1.put(1)
    println(s"q1.get(): ${q1.get()}")
    println(s"q1.get(): ${q1.get()}")
    //    println(s"q1.get(): ${q1.get()}") // will give an error
    println()

    val q2 = new BasicIntQueue with Filtering with Incrementing
    q2.put(-1)
    q2.put(0)
    q2.put(1)
    println(s"q2.get(): ${q2.get()}")
    println(s"q2.get(): ${q2.get()}")
    println(s"q2.get(): ${q2.get()}")
    println()
  }
}