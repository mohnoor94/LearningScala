package _03_collections

/**
  * There are also mutable collections.
  * Though much of the Scala programmers like to generally use immutable collections,
  * at times you may want to use mutable collections for efficiency though it
  * is generally good form to lock collections immutably when returning
  * from a method. Here is a ArrayBuffer which allows you to create a
  * mutable Array changing what you need.
  *
  * Note the API differences with immutable.
  */
object _10_MutableCollections extends App {
  def process(): List[Int] = {
    import scala.collection.mutable.ArrayBuffer
    val ab = ArrayBuffer[Int](10, 20)
    ab += 30
    ab += 40
    ab.prepend(5)
    ab.toList //return immutable
  }

  println(process())
}