package _050_implicit

/**
  * Ordering is a typeClass
  */
object _17_CustomOrdering {

  case class Employee(firstName: String, lastName: String)

  object EmployeeOrdering {
    implicit val orderEmployeesByFirstName: Ordering[Employee] = (x: Employee, y: Employee) => {
      x.firstName.compareTo(y.firstName)
    }
    //    implicit val orderEmployeesByFirstName: Ordering[Employee] = new Ordering[Employee] {
    //      override def compare(x: Employee, y: Employee): Int = {
    //        x.firstName.compareTo(y.firstName)
    //      }
    //    }
    implicit val orderEmployeesByLastName: Ordering[Employee] = (x: Employee, y: Employee) => {
      x.lastName.compareTo(y.lastName)
    }
  }

  def main(args: Array[String]): Unit = {
    val list: List[Employee] = List(
      Employee("Adam", "Ant"),
      Employee("Samuel", "Jackson"),
      Employee("Janice", "Joplin"),
      Employee("Jimmy", "Page"),
      Employee("The", "Edge"),
      Employee("Scarlett", "Johansson"),
      Employee("Justin", "Bieber"))

    // choose any ordering you want!
    import EmployeeOrdering.orderEmployeesByFirstName
    //    import EmployeeOrdering.orderEmployeesByLastName

    println(list.sorted)

    // or just define what you want! (this is a stupid way of ordering I know :P)
    println(list.sorted((e1: Employee, e2: Employee) => e1.firstName.compareTo(e2.lastName)))
  }
}