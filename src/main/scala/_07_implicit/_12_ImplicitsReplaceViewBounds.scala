package _07_implicit

/**
  * View Bounds are used to ensure that there is a particular
  * recipe for a certain type (to convert type to another)
  *
  * Uses <% inside of a parameterized type declaration to determine
  * if there is a conversion available then within you can treat
  * an object as an object of that type. It is unorthodox,
  * and has since been deprecated
  */
object _12_ImplicitsReplaceViewBounds {

  import scala.language.implicitConversions

  implicit def str2Employee(s: String): MyEmployee = {
    val tokens = s.split(" ")
    new MyEmployee(tokens.head, tokens.last)
  }

  //noinspection DeprecatedViewBound
  def hireEmployee[A <% MyEmployee](a: A): String = {
    s"Hired this employee named ${a.firstName} ${a.lastName}"
  }

  //Another take, but preferred
  def hireEmployee2[A](a: A)(implicit ev: A => MyEmployee): String = {
    val employee: MyEmployee = ev(a)
    s"Hired this employee named ${employee.firstName} ${employee.lastName}"
  }

  def main(args: Array[String]): Unit = {
    println(hireEmployee("Mohammad Noor"))
    println(hireEmployee2("Mohammad Noor"))
  }
}

class Employee(val firstName: String, val lastName: String)