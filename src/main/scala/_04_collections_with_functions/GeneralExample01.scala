package _04_collections_with_functions

object GeneralExample01 extends App {
  val groceries = List("Apples", "Milk", "Naan", "Egg", "Orange", "Almonds", "Peanut Butter")

  //  println(groceries)
  //  println(groceries.zipWithIndex)
  //  println(groceries.zipWithIndex.map(t => (t._1, t._2 + 1)))
  //  println(groceries.zipWithIndex.map(t => (t._1, t._2 + 1)).map(_.swap))
  //  println(groceries.zipWithIndex.map(t => (t._1, t._2 + 1)).map(_.swap).map(t => s"${t._1}. ${t._2}"))
  //  println(groceries.zipWithIndex.map(t => (t._1, t._2 + 1)).map(_.swap).map(t => s"${t._1}. ${t._2}").mkString("\n"))
  //  // view: make everything lazy until we do a reduction
//  println(groceries.view.zipWithIndex.map(t => (t._1, t._2 + 1)).map(_.swap).map(t => s"${t._1}. ${t._2}").mkString("\n"))
  println(groceries.view.sorted.zipWithIndex.map(t => (t._1, t._2 + 1)).map(_.swap).map(t => s"${t._1}. ${t._2}").mkString("\n"))
}