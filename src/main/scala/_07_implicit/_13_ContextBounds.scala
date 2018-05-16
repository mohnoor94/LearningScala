package _07_implicit

/**
  * Context Bounds works so that there is a type A, and it
  * requires a B[A] somewhere within the the implicit scope,
  * for example like Ordered[T], or TypeTag[T], or Numeric[T],
  * this provides a way to check that something is something
  * can be implicitly defined but gives the end user no opportunity
  * to the ability to inject a different implementation
  *
  * [T:WrappedType], is equivalent to
  * (t:T)(implicit w:WrappedType[T])
  *
  * the first make the user work easier
  * the second make the user has more control
  */
object _13_ContextBounds extends App {

  // Choose what implementation you want here!
  //  import EmployeePredef.employeeToStringFull
  import EmployeePredef.employeeToStringShort

  def myToString[A: Loggable](a: A): String = {
    implicitly[Loggable[A]].log(a)
  }

  //Allows the end user to plug their own
  def myToString2[A](a: A)(implicit conv: Loggable[A]): String = {
    conv.log(a)
  }

  println(myToString(new MyEmployee("Satya", "Nadella")))
  println(myToString2(new MyEmployee("Satya", "Nadella")))
  println(myToString2(new MyEmployee("Satya", "Nadella"))((e: MyEmployee) => s"My custom implementation: ${e.lastName}, ${e.firstName}"))
}

class MyEmployee(val firstName: String, val lastName: String)

trait Loggable[T] {
  def log(t: T): String
}

object EmployeePredef {

  import scala.language.implicitConversions

  implicit val employeeToStringFull: Loggable[MyEmployee] =
    (e: MyEmployee) => s"Employee(firstName:${e.firstName}, lastName:${e.lastName})"

  implicit val employeeToStringShort: Loggable[MyEmployee] =
    (e: MyEmployee) => s"Employee(${e.firstName}, ${e.lastName})"

  //  implicit val employeeToStringShort: Loggable[Employee] = new Loggable[Employee] {
  //    override def log(e: Employee): String =
  //      s"Employee(${e.firstName}, ${e.lastName})"
  //  }
}