import _039_oop_more._03_UsingTypeAliasing.Foo
// I had to add this import because I have several Foo types
// across all files on the package.

package object _039_oop_more {

  // Do not include traits and (case) classes here (in package object)!

  // Use these objects for package documentation!

  // You may add the type aliases here too,
  // see 'UsingTypeAliasing' file for usage of these aliases.

  type StringedFoo = Foo[String]
  type LongFoo = Foo[Long]
  type IntFoo = Foo[Int]
}