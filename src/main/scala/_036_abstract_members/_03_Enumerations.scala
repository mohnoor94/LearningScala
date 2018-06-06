package _036_abstract_members

object _03_Enumerations {

  object Color extends Enumeration {
    val Red, Green, Blue = Value
  }

  object Direction extends Enumeration {
    val North = Value("North Custom Name")
    val East = Value("East")
    val South = Value("South")
    val West = Value("West")
  }

  def main(args: Array[String]): Unit = {
    import Color._
    println(s"Red: $Red")
    println(s"Green: $Green")
    println(s"Blue: $Blue")
    println(s"Red == Red ==> ${Red == Red}")
    println(s"Red > Green ==> ${Red > Green}")
    println(s"Green < Blue ==> ${Green < Blue}")
    println(s"Red.id: ${Red.id}")
    println(s"Color(1): ${Color(1)}")
    println()
    println("> for (colour <- Color.values) print(colour + \" \"): ")
    for (colour <- Color.values) print(colour + " ")
    println()
    import Direction._
    println(North)
  }
}