package _033_traits

/**
  * > Comparison is another domain where a rich interface is convenient. Whenever you compare two objects that are ordered,
  * it is convenient if you use a single method call to ask about the precise comparison you want. If you want
  * "is less than," you would like to call <, and if you want "is less than or equal," you would like to call <=. With a
  * thin comparison interface, you might just have the < method, and you would sometimes have to write things like
  * "(x < y) || (x == y)". A rich interface would provide you with all of the usual comparison operators, thus allowing
  * you to directly write things like "x <= y".
  *
  * > This problem is so common that Scala provides a trait to help with it. The trait is called Ordered. To use it, you
  * replace all of the individual comparison methods with a single compare method. The Ordered trait then defines <, >,
  * <=, and >= for you in terms of this one method. Thus, trait Ordered allows you to enrich a class with comparison
  * methods by implementing only one method, compare.
  *
  * > Any time you implement a class that is ordered by some comparison, you should consider mixing in the Ordered trait.
  * If you do, you will provide the class's users with a rich set of comparison methods.
  */
object _02_OrderedTrait {

  class MiniRational(val numerator: Int, val denominator: Int) extends Ordered[MiniRational] {
    require(denominator != 0)

    override def compare(that: MiniRational): Int =
      (this.numerator * that.denominator) - (that.numerator * this.denominator)
  }

  def main(args: Array[String]): Unit = {
    val r1 = new MiniRational(5, 10)
    val r2 = new MiniRational(3, 4)
    println(s"r1 < r2: ${r1 < r2}")
    println(s"r1 > r2: ${r1 > r2}")
    println(s"r1 <= r2: ${r1 <= r2}")
    println(s"r1 >= r2: ${r1 >= r2}")
    println(s"r1 == r2: ${r1 == r2}")
    println(s"r1 != r2: ${r1 != r2}")
  }
}