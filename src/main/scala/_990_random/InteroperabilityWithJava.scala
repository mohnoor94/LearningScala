package _990_random

import java.time.ZoneId

import scala.collection.JavaConverters._

/**
  * All of these conversions are done using implicits
  */
object InteroperabilityWithJava extends App {
  val javaToScalaList: List[String] = ZoneId.getAvailableZoneIds.asScala.toList
  val javaToScalaSet: Set[String] = ZoneId.getAvailableZoneIds.asScala.toSet
  val scalaToJavaList: java.util.List[Int] = List(1, 2, 3).asJava
  val scalaToJavaCollectionList: java.util.Collection[Int] = List(1, 2, 3).asJavaCollection
  val scalaToJavaSet: java.util.Set[Int] = Set(1, 2, 3, 4).asJava
  val scalaToJavaCollectionSet: java.util.Collection[Int] = Set(1, 2, 3, 4).asJavaCollection

  def printTypeAndContent(value: Any): Unit = println(value.getClass.getSimpleName + " ==> " + value)

  printTypeAndContent(javaToScalaList)
  printTypeAndContent(javaToScalaSet)
  printTypeAndContent(scalaToJavaList)
  printTypeAndContent(scalaToJavaCollectionList)
  printTypeAndContent(scalaToJavaSet)
  printTypeAndContent(scalaToJavaCollectionSet)
}