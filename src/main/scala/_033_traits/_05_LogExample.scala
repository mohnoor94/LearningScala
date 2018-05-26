package _033_traits

object Log extends App {
  val c = new Child(40, 10)
  c.log("Created Child")
  println(c.list)
  c.log("Another item")
  println(c.list)

  //... and
  val o = new Object with Log
  o.log("Cool, an object mixed with a trait!")

  println(o.list)
}

trait Log {
  var list: List[String] = List[String]()

  def log(x: String): Unit = {
    list = list :+ x
  }
}

class Super(val x: Int)

class Child(x: Int, val y: Int) extends Super(x) with Log