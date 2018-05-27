/**
  * The other way you can place code into packages in Scala is more like C# namespaces. You follow a package clause by a
  * section in curly braces that contains the definitions that go into the package. This syntax is called a packaging.
  * Like this package '_034_packages'.
  * This syntax is more general in Scala.
  */
package _034_packages_and_imports {
}

/**
  * One use of the more general notation is to have different parts of a file in different packages. For example, you
  * might include a class's tests in the same file as the original code, but put the tests in a different .
  */
package bobsrockets {
  package navigation {

    // In package bobsrockets.navigation
    class Navigator

    package tests {

      // In package bobsrockets.navigation.tests
      class NavigatorSuite
    }
  }
}