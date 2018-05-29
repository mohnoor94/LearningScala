package _020_collections

import scala.collection.immutable.TreeSet
import scala.collection.mutable

/**
  * I put the type intentionally here to illustrate the conversions.
  */
object _12_ConvertBetweenMutableAndImmutable {
  val colors: List[String] = List("blue", "yellow", "red", "green")

  val treeSet: TreeSet[String] = TreeSet[String]() ++ colors
  val list: List[String] = treeSet.toList
  val array: Array[String] = treeSet.toArray

  val mutableSet: mutable.Set[String] = mutable.Set.empty ++= treeSet
  val immutableSet: Set[String] = Set.empty ++ mutableSet

  val mutableMap: mutable.Map[String, Int] = mutable.Map("i" -> 1, "ii" -> 2)
  val immutableMap: Map[String, Int] = Map.empty ++ mutableMap
}