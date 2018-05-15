/**
  * we can also use a package object to store some of these implicits
  */
package object _07_implicit {
  // for example
  implicit val tuple2ToList: ((Int, String)) => List[String] = t => List.fill(t._1)(t._2)
}