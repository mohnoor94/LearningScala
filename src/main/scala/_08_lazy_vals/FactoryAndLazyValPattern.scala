package _08_lazy_vals

/**
  * When we look at lazy vals, what we really wanting is we want
  * some configurability in there along with the immutability that
  * comes from the vals.
  * So we use val that depends on some other vars!
  */
object FactoryAndLazyValPattern {

  var jdbcURLFactory: Option[() => String] = None

  var usernameFactory: Option[() => String] = None

  var passwordFactory: Option[() => String] = None

  lazy val jdbcURL: Object = jdbcURLFactory.getOrElse("jdbc:mysql://localhost:3306")

  lazy val username: String = usernameFactory.getOrElse(() => "root")()

  lazy val password: String = passwordFactory.getOrElse(() => "")()

  def main(args: Array[String]): Unit = {
    passwordFactory = Some(() => "tester")
    println(s"JDBC URL: $jdbcURL")
    println(s"Username: $username")
    println(s"Password: $password")
  }
}
