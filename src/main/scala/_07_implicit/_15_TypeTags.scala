package _07_implicit

/**
  * Getting around Erasure Using TypeTags
  *
  * used to use Manifest but now uses a type tag to
  * retrieve what is erased
  *
  * Super Advanced Topic (Macros, Reflection, ...)
  */
object _15_TypeTags extends App {

  import scala.reflect.runtime.universe._

  def matchList[A](list: List[A])(implicit tt: TypeTag[A]): String = {
    tt.tpe match {
      case t if t =:= typeOf[String] => "List of String"
      case t if t =:= typeOf[Int] => "List of Int"
      case _ => "List of Something else"
    }
  }

  println(matchList(List(1, 2, 3, 4)))
  println(matchList(List(1.5, 2, 3, 4)))
  println(matchList(List("Hi", "Hello")))
  println(matchList(List("Hi", "Hello")))
}