package _039_oop_more

object _03_UsingTypeAliasing {

  trait Foo[A] {
    def bar: A
  }

  //  case class Foo1Impl(bar: String) extends Foo[String]
  case class Foo1Impl(bar: String) extends StringedFoo

  //  case class Foo2Impl(bar: Int) extends Foo[Int]
  case class Foo2Impl(bar: Int) extends IntFoo

  //  case class Foo3Impl(bar: Long) extends Foo[Long]
  case class Foo3Impl(bar: Long) extends LongFoo
}