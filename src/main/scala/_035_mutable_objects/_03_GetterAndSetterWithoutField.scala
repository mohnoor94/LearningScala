package _035_mutable_objects

/**
  * > It's also possible, and sometimes useful, to define a getter and a setter without an associated field.
  * >> For example, the Thermometer class below, which encapsulates a temperature variable that can be read and updated.
  * >> Temperatures can be expressed in Celsius or Fahrenheit degrees.
  * >> This class allows you to get and set the temperature in either measure.
  */
object _03_GetterAndSetterWithoutField {

  class Thermometer {

    /**
      * > Note that you cannot simply leave off the "= _" initializer in Scala.
      * > If you did that, this would declare an abstract variable, not an uninitialized one.
      */
    var celsius: Float = _ // default value (0.0)

    def fahrenheit: Float = celsius * 9 / 5 + 32

    def fahrenheit_=(f: Float): Unit = {
      celsius = (f - 32) * 5 / 9
    }

    override def toString: String = fahrenheit + "F/" + celsius + "C"
  }

  def main(args: Array[String]): Unit = {
    val thermometer = new Thermometer
    println(thermometer)
    thermometer.fahrenheit = 100
    println(thermometer)
    thermometer.celsius = 100
    println(thermometer)
  }
}