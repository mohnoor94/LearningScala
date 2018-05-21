package _05_oop._05_Rational_Example

import scala.language.postfixOps

/**
  * IMMUTABLE OBJECT TRADE-OFFS
  * Immutable objects offer several advantages over mutable objects, and one potential disadvantage.
  * First, immutable objects are often easier to reason about than mutable ones, because they do not have complex state
  * spaces that change over time.
  * Second, you can pass immutable objects around quite freely, whereas you may need to make defensive copies of mutable
  * objects before passing them to other code.
  * Third, there is no way for two threads concurrently accessing an immutable to corrupt its state once it has been
  * properly constructed, because no thread can change the state of an immutable.
  * Fourth, immutable objects make safe hash table keys. If a mutable object is mutated after it is placed into a
  * HashSet, for example, that object may not be found the next time you look into the HashSet.
  *
  * The main disadvantage of immutable objects is that they sometimes require that a large object graph be copied,
  * whereas an update could be done in its place. In some cases this can be awkward to express and might also cause a
  * performance bottleneck. As a result, it is not uncommon for libraries to provide mutable alternatives to immutable
  * classes. For example, class StringBuilder is a mutable alternative to the immutable String.
  *
  * OPERATORS
  * An operator identifier consists of one or more operator characters. Operator characters are printable ASCII
  * characters such as +, :, ?, ~ or #.[7] Here are some examples of operator identifiers: +  ++  :::  <?>  :->
  * The Scala compiler will internally "mangle" operator identifiers to turn them into legal Java identifiers with
  * embedded $ characters. For instance, the identifier :-> would be represented internally as $colon$minus$greater.
  * If you ever wanted to access this identifier from Java code, you'd need to use this internal representation.
  *
  * LITERAL IDENTIFIERS
  * A literal identifier is an arbitrary string enclosed in back ticks (` ...`). Some examples of literal identifiers are:
  * `x`  `<clinit>`  `yield`
  * The idea is that you can put any string that's accepted by the runtime as an identifier between back ticks. The
  * result is always a Scala identifier. This works even if the name contained in the back ticks would be a Scala
  * reserved word. A typical use case is accessing the static yield method in Java's Thread class. You cannot write
  * Thread.yield() because yield is a reserved word in Scala. However, you can still name the method in back ticks,
  * e.g., Thread.`yield`().
  */
class Rational(val numerator: Int, val denominator: Int) {
  require(denominator != 0)

  private val g = gcd(numerator abs, denominator abs)
  private val n = numerator / g
  private val d = denominator / g

  def this(n: Int) = this(n, 1) // auxiliary constructor

  override def toString: String = n + "/" + d

  def +(that: Rational): Rational = new Rational(n * that.d + that.n * d, d * that.d)

  def +(i: Int): Rational = new Rational(n + i * d, d)

  def -(that: Rational): Rational = new Rational(n * that.d - that.n * d, d * that.d)

  def -(i: Int): Rational = new Rational(n - i * d, d)

  def *(that: Rational): Rational = new Rational(n * that.n, d * that.d)

  def *(i: Int): Rational = new Rational(n * i, d)

  def /(that: Rational): Rational = new Rational(n * that.d, d * that.n)

  def /(i: Int): Rational = new Rational(n, d * i)

  def <(that: Rational): Boolean = this.n * that.d < that.n * this.d

  def <=(that: Rational): Boolean = this.n * that.d <= that.n * this.d

  def >(that: Rational): Boolean = this.n * that.d > that.n * this.d

  def >=(that: Rational): Boolean = this.n * that.d >= that.n * this.d

  def ==(that: Rational): Boolean = this.n * that.d == that.n * this.d

  def !=(that: Rational): Boolean = this.n * that.d != that.n * this.d

  def max(that: Rational): Rational = if (this.<(that)) that else this

  def min(that: Rational): Rational = if (this.>(that)) that else this

  def abs: Rational = if (this < 0) this * -1 else this

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}

object Rational {
  implicit val intToRational: Int => Rational = (x: Int) => new Rational(x)
}