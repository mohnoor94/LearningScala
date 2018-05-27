package _034_packages_and_imports._04_scope_of_protection.launch


object Vehicle {

  import _034_packages_and_imports._04_scope_of_protection.navigation._

  private[launch] val guide = new Navigator
}