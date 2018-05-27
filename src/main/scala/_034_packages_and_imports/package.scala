/**
  * Chapter 13 - Packages and Imports
  * From: Programming in Scala, Third Edition
  *
  * When working on a program, especially a large one, it is important to minimize coupling—the extent to which the\
  * various parts of the program rely on the other parts. Low coupling reduces the risk that a small, seemingly
  * innocuous change in one part of the program will have devastating consequences in another part. One way to minimize
  * coupling is to write in a modular style. You divide the program into a number of smaller modules, each of which has
  * an inside and an outside. When working on the inside of a module—its implementation—you need only coordinate with
  * other programmers working on that very same module. Only when you must change the outside of a module—its
  * interface—is it necessary to coordinate with developers working on other modules.
  *
  *
  * 13.1 PUTTING CODE IN PACKAGES
  * > Scala code resides in the Java platform's global hierarchy of packages.
  * > You can place code into named packages in Scala in two ways:
  *   - First, you can place the contents of an entire file into a package by putting a package clause at the top of
  *   the file, as:
  * ``
  * package bobsrockets.navigation
  * class Navigator
  * ``
  *
  * @see _01_packaging for more
  *
  *
  * > Read Chapter 13.2 CONCISE ACCESS TO RELATED CODE from the book for more details about packages, I won't go into
  * them since I simply prefer the Java like packages.
  *
  *
  * 13.3 IMPORTS
  * @see _02_imports
  *
  *
  * 13.4 IMPLICIT IMPORTS
  * > Scala adds some imports implicitly to every program. In essence, it is as if the following three import clauses
  * had been added to the top of every source file with extension ".scala":
  * -> import java.lang._ // everything in the java.lang package
  *     // The java.lang package contains standard Java classes  (like Thread ==> java.lang.Thread).
  * -> import scala._     // everything in the scala package
  *     // The scala package contains the standard Scala library (like List ==> scala.List).
  * -> import Predef._    // everything in the Predef object
  *     // The Predef object contains many definitions of types, methods, and implicit conversions that are commonly
  *     used on Scala programs. For example, because Predef is imported implicitly, you can write assert instead of
  *     Predef.assert.
  *
  * > These three import clauses are treated a bit specially in that later imports overshadow earlier ones.
  * - For instance, the StringBuilder class is defined both in package scala and, from Java version 1.5 on, also in
  * package java.lang. Because the scala import overshadows the java.lang import, the simple name StringBuilder will
  * refer to scala.StringBuilder, not java.lang.StringBuilder.
  *
  *
  * 13.5 ACCESS MODIFIERS
  * @see _03_access_modifiers
  * @see _04_scope_of_protection package
  * @see _05_visibility_and_companion_object
  *
  *
  * 13.6 PACKAGE OBJECTS
  * > We are here in the package object of this package.
  * > Any kind of definition that you can put inside a class can also be at the top level of a package.
  * > If you have some helper method you'd like to be in scope for an entire package, go ahead and put it right at the
  * top level of the package.
  * > Each package is allowed to have one package object. Any definitions placed in a package object are considered
  * members of the package itself.
  * > Any code in any package can import a method from another package just like it would import a class.
  * e.g: import a.methodName
  * > There are other uses of package objects for kinds of definitions, like to hold package-wide type aliases, and
  * implicit conversions.
  * > The top-level scala package has a package object, and its definitions are available to all Scala code.
  * > Package objects are compiled to class files named package.class that are the located in the directory of the
  * package that they augment.
  * >> It's useful to keep the same convention for source files.
  * >> So you would typically put the source file of the package object _04_scope_of_protection into a file named
  * package.scala that resides in the _04_scope_of_protection directory.
  *
  *
  * 13.7 CONCLUSION
  * > In this chapter, you saw the basic constructs for dividing a program into packages.
  * > This gives you a simple and useful kind of modularity, so that you can work with very large bodies of code without
  * different parts of the code trampling on each other.
  * > Scala's system is the same in spirit as Java's packages, but there are some differences where Scala chooses to be
  * more consistent or more general.
  * > Looking ahead, Chapter 29 describes a more flexible module system than division into packages. In addition to
  * letting you separate code into several namespaces, that approach allows modules to be parameterized and inherit
  * from each other.
  */
package object _034_packages_and_imports {
}