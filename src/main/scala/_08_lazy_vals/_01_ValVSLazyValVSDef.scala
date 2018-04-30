package _08_lazy_vals

/**
  * def : evaluated each time we call it
  * val : evaluated once when declared
  * lazy val: evaluated once when needed
  */
object _01_ValVSLazyValVSDef extends App {
  def expr: Int = {
    val x = {
      print("x"); 1
    }
    lazy val y = {
      print("y"); 2
    }

    def z: Int = {
      print("z"); 3
    }

    z + y + x + z + y + x
  }

  expr
}
