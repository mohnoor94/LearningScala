package _96_scala_puzzlers

/**
  * Puzzler 5 - The Missing List
  * What is the result of executing the following code?
  *
  * To understand what is going on, you need to recall another feature of the Scala
  * collections library: its operations generally preserve the input collection type!
  * That's mean, with the second expression, each of the 2 internal members will results
  * in 2, and since the outer collection is a set, it will eliminate the repeated members,
  * so it will keep only one of the two 2s. and the sum in this case will be 2.
  *
  * --> Pay close attention to the possible input types to your methods that operate on collections.
  * If you do not need to preserve the input type, consider constructing your own intermediate
  * types with known characteristics.
  */
object _05_TheMissingList {
  def sumSizes(collections: Iterable[Iterable[_]]): Int =
    collections.map(_.size).sum

  def main(args: Array[String]): Unit = {
    println(sumSizes(List(Set(1, 2), List(3, 4))))
    println(sumSizes(Set(List(1, 2), Set(3, 4))))
    println("\n===== Convert Outer Collection Solution =====\n")
    println(ConvertOuterCollectionSolution.sumSizes(List(Set(1, 2), List(3, 4))))
    println(ConvertOuterCollectionSolution.sumSizes(Set(List(1, 2), Set(3, 4))))
    println("\n===== Fold Solution =====\n")
    println(FoldSolution.sumSizes(List(Set(1, 2), List(3, 4))))
    println(FoldSolution.sumSizes(Set(List(1, 2), Set(3, 4))))
  }

  object ConvertOuterCollectionSolution {
    def sumSizes(collections: Iterable[Iterable[_]]): Int =
      collections.toSeq.map(_.size).sum
  }

  object FoldSolution {
    def sumSizes(collections: Iterable[Iterable[_]]): Int =
      collections.foldLeft(0) {
        (sumOfSizes, collection) => sumOfSizes + collection.size
      }
  }
}