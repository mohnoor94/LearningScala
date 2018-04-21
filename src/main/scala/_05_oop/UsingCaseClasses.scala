package _05_oop

/**
  * Here, there are no need to use case classes and pattern matching for
  * such a simple example! we can use normal classes and everything will
  * work ok, except for the case if we have a null value, but we don't
  * like nulls and do not use them in Scala.
  */
object UsingCaseClasses {

  case class User(name: String, email: String)

  def myFunction(user: User): String = user match {
    case User(name, email) => s"$name <$email>"
    case _ => "Undefined"
  }

  class User2(val name: String, val email: String)

  def myFunction2(user: User2): String = {
    s"${user.name} <${user.email}>"
  }

  def main(args: Array[String]): Unit = {
    println(myFunction(User("Foo", "foo@bar.com")))
    println(myFunction2(new User2("Foo", "foo@bar.com")))
  }
}