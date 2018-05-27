package _034_packages_and_imports

import java.util.regex.Pattern

/**
  * 13.3 IMPORTS
  * > In Scala, packages and their members can be imported using import clauses. Imported items can then be accessed by
  * a simple name like File, as opposed to requiring a qualified name like java.io.File.
  *
  * > An import clause makes members of a package or object available by their names alone without needing to prefix
  * them by the package or object name.
  * Examples:
  * - import bobsdelights.Fruit     :: This corresponds to Java's single type import (import 1 class)
  * - import bobsdelights._         :: This corresponds to Java's on-demand import (import everything in package)
  * - import bobsdelights.Fruits._  :: This corresponds to Java's import of static class fields (call the member without
  * it's parent, like Date, not java.util.Date)
  *
  *
  * > SCALA'S FLEXIBLE IMPORTS
  * Scala's import clauses are quite a bit more flexible than Java's. There are three principal differences. In Scala,
  * imports:
  * ▶ may appear anywhere
  * ▶ may refer to objects (singleton or regular) in addition to packages
  * ▶ let you rename and hide some of the imported members
  *
  * ▶ Another way Scala's imports are flexible is that they can import packages themselves, not just their non-package
  * members. This is only natural if you think of nested packages being contained in their surrounding package.
  * > look at example 1 below.
  *
  *
  * > Imports in Scala can also rename or hide members. This is done with an import selector clause enclosed in braces,
  * which follows the object from which members are imported. Here are some examples:
  * - import Fruits.{Apple, Orange}
  *     This imports just members Apple and Orange from object Fruits.
  * - import Fruits.{Apple => McIntosh, Orange}
  *     This imports the two members Apple and Orange from object Fruits. However, the Apple object is renamed to
  *     McIntosh, so this object can be accessed with either Fruits.Apple or McIntosh.
  *     A renaming clause is always of the form "<original-name> => <new-name>".
  * - import java.sql.{Date => SDate}
  *     This imports the SQL date class as SDate, so that you can simultaneously import the normal Java date class as
  *     simply Date.
  * - import java.{sql => S}
  *     This imports the java.sql package as S, so that you can write things like S.Date.
  * - import Fruits.{_}
  *     This imports all members from object Fruits. It means the same thing as import Fruits._.
  * - import Fruits.{Apple => McIntosh, _}
  *     This imports all members from object Fruits but renames Apple to McIntosh.
  * - import Fruits.{Pear => _, _}
  *     This imports all members of Fruits except Pear. A clause of the form "<original-name> => _" excludes
  *     <original-name> from the names that are imported. In a sense, renaming something to '_' means hiding it
  *     altogether. This is useful to avoid ambiguities.
  * --> Say you have two packages, Fruits and Notebooks, which both define a class Apple. If you want to get just the
  * notebook named Apple, and not the fruit, you could still use two imports on demand like this:
  * ``
  * import Notebooks._
  * import Fruits.{Apple => _, _}
  * ``
  * This would import all Notebooks and all Fruits, except for Apple.
  *
  * > In summary, an import selector can consist of the following:
  * ▶ A simple name x. This includes x in the set of imported names.
  * ▶ A renaming clause x => y. This makes the member named x visible under the name y.
  * ▶ A hiding clause x => _. This excludes x from the set of imported names.
  * ▶ A catch-all '_'. This imports all members except those members mentioned in a preceding clause. If a catch-all is
  * given, it must come last in the list of import selectors.
  *
  * > The simpler import clauses shown at the beginning of this section can be seen as special abbreviations of import
  * clauses with a selector clause. For example, "import p._" is equivalent to "import p.{_}" and "import p.n" is
  * equivalent to "import p.{n}".
  **/
object _02_imports {
  /**
    *  Example 1 -
    *  For example, the package java.util.regex is imported. This makes regex usable as a simple name. To access the
    *  Pattern singleton object from the java.util.regex package, you can just say, regex.Pattern:
    */
  {
    import java.util.regex

    class AStarB {
      // Accesses java.util.regex.Pattern
      val pat: Pattern = regex.Pattern.compile("a*b")
    }
  }
}