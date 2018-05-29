package _020_collections

/**
  * > There are also mutable collections.
  * > Though much of the Scala programmers like to generally use immutable collections,
  * >> at times you may want to use mutable collections for efficiency though it is generally good form to lock
  * collections immutably when returning from a method.
  *
  * List buffers
  * > Class List provides fast access to the head of the list, but not the end.
  * >> Thus, when you need to build a list by appending to the end, consider building the list backwards by prepending
  * elements to the front. Then when you're done, call reverse to get the elements in the order you need.
  * > Another alternative, which avoids the reverse operation, is to use a ListBuffer.
  * >> A ListBuffer is a mutable object (contained in package scala.collection.mutable), which can help you build lists
  * more efficiently when you need to append.
  * >> ListBuffer provides constant time append and prepend operations.
  * >> You append elements with the += operator, and prepend them with the +=: operator.
  * >> When you're done building, you can obtain a List by invoking toList on the ListBuffer.
  * > Another reason to use ListBuffer instead of List is to prevent the potential for stack overflow.
  * >> If you can build a list in the desired order by prepending, but the recursive algorithm that would be required is
  * not tail recursive, you can use a for expression or while loop and a ListBuffer instead.
  *
  *
  * Array buffers
  * > An ArrayBuffer is like an array, except that you can additionally add and remove elements from the beginning and
  * end of the sequence.
  * > All Array operations are available, though they are a little slower due to a layer of wrapping in the
  * implementation.
  * > The new addition and removal operations are constant time on average, but occasionally require linear time due to
  * the implementation needing to allocate a new array to hold the buffer's contents.
  *
  *
  * > Note the API differences with immutable.
  */
object _10_MutableCollections {
  def main(args: Array[String]): Unit = {
    println("===== List buffers =====")
    listBufferExample()
    println()

    println("===== Array buffers =====")
    println(arrayBufferExample())
    println()

    println("===== Mutable Sets =====")
    mutableSetExample()
    println()

    println("===== Mutable Maps =====")
    mutableMapExample()
  }

  private def mutableMapExample(): Unit = {
    import scala.collection.mutable
    val map = mutable.Map.empty[String, Int]
    println(map)
    map("hello") = 1
    map("there") = 2
    println(map)
    println(map("hello"))
    println("======")
    val nums = mutable.Map("i" -> 1, "ii" -> 2)
    println(nums)
    nums += ("vi" -> 6)
    println(nums)
    nums -= "ii"
    println(nums)
    nums ++= List("iii" -> 3, "v" -> 5)
    println(nums)
    nums --= List("i", "ii")
    println(nums)
    println("=====")
    println(s"nums.size: ${nums.size}")
    print("nums.contains(\"ii\"): ")
    println(nums.contains("ii"))
    print("nums(\"iii\"): ")
    println(nums("iii"))
    println(s"nums.keys ==> ${nums.keys}")
    println(s"nums.keySet ==> ${nums.keySet}")
    println(s"nums.values ==> ${nums.values}")
    println(s"nums.isEmpty: ${nums.isEmpty}")
  }

  def arrayBufferExample(): List[Int] = {
    import scala.collection.mutable.ArrayBuffer
    val ab = ArrayBuffer[Int](10, 20)
    ab += 30
    ab += 40
    ab.prepend(5)
    ab.toList //return immutable
  }

  private def listBufferExample(): Unit = {
    import scala.collection.mutable.ListBuffer
    val listBuffer = new ListBuffer[Int]
    listBuffer += 1
    listBuffer += 2
    println(listBuffer)
    3 +=: listBuffer
    println(listBuffer)
    val list = listBuffer.toList
    println(list)
  }

  private def mutableSetExample(): Unit = {
    import scala.collection.mutable
    val emptySet = mutable.Set.empty[Int]
    println(emptySet)
    val nums = mutable.Set(1, 2, 3)
    println(nums)
    nums += 5
    println(nums)
    nums -= 3
    println(nums)
    nums ++= List(5, 6)
    println(nums)
    nums --= List(1, 2)
    println(nums)
    println(nums & Set(1, 3, 5, 7)) // intersection of two sets
    nums.clear()
    println(nums)
  }
}