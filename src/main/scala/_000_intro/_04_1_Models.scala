class Employee(val firstName: String,
               val lastName: String,
               val title: String = "None") {

  require(firstName.nonEmpty, "First Name cannot be empty")
  require(lastName.nonEmpty, "Last Name cannot be empty")
  require(title.nonEmpty, "Title cannot be empty")

  // Or... But WHY?!
  if (title.contains("Senior") || title.contains("Junior"))
    throw new IllegalArgumentException("Title cannot contain Junior or Senior")

  override def toString: String = {
    s"Employee(firstName=$firstName, lastName=$lastName, title=$title)"
  }

  def copy(firstName: String = this.firstName, lastName: String = this.lastName, title: String = this.title) =
    new Employee(firstName, lastName, title)


  def canEqual(other: Any): Boolean = other.isInstanceOf[Employee]

  override def equals(other: Any): Boolean = other match {
    case that: Employee =>
      (that canEqual this) &&
        firstName == that.firstName &&
        lastName == that.lastName &&
        title == that.title
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(firstName, lastName, title)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}


case class Department(name: String) {
  // default: toString, equals (==), hashCode, copy
  // you can override any of them
  // no new keyword
  // no val or var
  // .... WOW
}

class Manager(firstName: String, lastName: String, title: String, val department: Department)
  extends Employee(firstName, lastName, title) {
}