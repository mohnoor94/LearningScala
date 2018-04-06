object Tests extends App {
  //  try {
  //    val employee = new Employee("Ali", "", "")
  //    println(employee)
  //    println(employee)
  //    println(employee.title)
  //  } catch {
  //    case iae: IllegalArgumentException => println(iae.getMessage)
  //  } finally {
  //    println("Continue...")
  //  }
  //
  //
  //  try {
  //    val employee = new Employee("Ali", "Mohammad", "Senior Programmer")
  //    println(employee)
  //  } catch {
  //    case iae: IllegalArgumentException => println(iae.getMessage)
  //  } finally {
  //    println("Continue...")
  //  }


  val mathDept = Department("Math")
  val alan: Manager = new Manager("Alan", "Turing", "Mathematician", mathDept)
  println(alan.department)

  val alanEmployee: Employee = alan
  println(alan.firstName)
  println(alanEmployee.firstName)
  println(alan.department)
  println(alan.department.name)
  //  println(alanEmployee.department)


  def extractFirstName(e: Employee) = e.firstName

  println(extractFirstName(alan))
  println(extractFirstName(alanEmployee))

  println()
  println()

  println(Department("Toys").name)

  val name = mathDept match {
    case Department(n) => n
    case _ => "Unknown"
  }

  println(name)


  // ...also pattern matching..!
  val Department(thatName) = mathDept
  println(thatName)

  val x = Some("data")
  val y = None

  def getValue(option: Option[String]) = {
    option match {
      case Some(data) => data
      case None => "No data"
    }
  }

  println()
  println()
  println()

  println(getValue(x))
  println(getValue(y))


  println(x.getOrElse("No data"))
  println(y.getOrElse("No data"))
}
