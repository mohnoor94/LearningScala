/**
  *           Iterable
  * _____________|______________
  * |            |             |
  * Seq          Set           Map
  * ______________|_____________
  * |             |            |
  * List        Vector       Range
  *
  * String and Array support the same operations as Seq and can
  * implicitly be converted to sequences where needed,
  * but they cannot be subclasses of Seq because they come from Java.
  *
  * @see https://docs.scala-lang.org/tutorials/FAQ/collections.html
  * for full details
  *
  * For performance characteristics of each of the Scala collections, see:
  * https://docs.scala-lang.org/overviews/collections/performance-characteristics.html
  */
package object _03_collections {
}