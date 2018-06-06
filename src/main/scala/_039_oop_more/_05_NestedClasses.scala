package _039_oop_more

object _05_NestedClasses {

  class Outer {
    class Inner
  }

  def main(args: Array[String]): Unit = {
    val o1 = new Outer
    val o2 = new Outer

    val i11 = new o1.Inner
    val i12 = new o1.Inner
    val i21 = new o2.Inner
    val i22 = new o2.Inner

    println(o1)
    println(o2)
    println(i11)
    println(i12)
    println(i21)
    println(i22)
  }
}