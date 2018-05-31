package _035_mutable_objects

/**
  * From Chapter 18 - Mutable Objects
  * > 18.2 REASSIGNABLE VARIABLES AND PROPERTIES
  * Programming in Scala, Third Edition
  *
  *
  */
object _02_ReassignableVarsAndProperties {

  // var hour generates a getter, "hour", and setter, "hour_=", in addition to a reassignable field.
  // The field is always marked private[this], which means it can be accessed only from the object that contains it.
  // The getter and setter, on the other hand, get the same visibility as the original var.
  class Time1 {
    var hour = 12
    var minute = 0
  }

  // is equivalent to
  class Time2 {

    private[this] var h = 12
    private[this] var m = 0

    def hour: Int = h

    def hour_=(x: Int): Unit = h = x

    def minute: Int = m

    def minute_=(x: Int): Unit = m = x
  }

  class Time3 {

    private[this] var h = 12
    private[this] var m = 0

    def hour: Int = h

    def hour_=(x: Int): Unit = {
      require(0 <= x && x < 24)
      h = x
    }

    def minute: Int = m

    def minute_=(x: Int): Unit = {
      require(0 <= x && x < 60)
      m = x
    }
  }

  def main(args: Array[String]): Unit = {
    val time1 = new Time1
    val time2 = new Time2
    val time3 = new Time3

    time1.hour = 10
    time2.hour = 10
    time3.hour = 10 // here we have a check in setter method

    println(time1.hour)
    println(time2.hour)
    println(time3.hour)
  }
}