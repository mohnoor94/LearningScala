package _05_oop._03_Scala_hierarchy

/**
  * Avoiding a types monoculture:
  * >> To get the most benefit from the Scala class hierarchy, try to define a new class for each domain concept, even
  * when it would be possible to reuse the same class for different purposes. Even if such a class is a so-called tiny
  * type with no methods or fields, defining the additional class is a way to help the compiler be helpful to you.
  * >> For example, suppose you are writing some code to generate HTML. In HTML, a style name is represented as a string.
  * So are anchor identifiers. HTML itself is also a string, so if you wanted, you could define helper code using strings
  * to represent all of these things, like this: (simpleTitle, below).
  * >> That type signature has four strings in it! Such stringly typed code is technically strongly typed, but since
  * everything in sight is of type String, the compiler cannot help you detect the use of one when you meant to write
  * the other. For example, it won't stop you from this travesty: (title1, below).
  * >> his HTML is mangled. The intended display text "Value Classes" is being used as a style class, and the text being
  * displayed is "chap.vcls," which was supposed to be an anchor. To top it off, the actual anchor identifier is "bold,"
  * which is supposed to be a style class. Despite this comedy of errors, the compiler utters not a peep.
  *
  * >> The compiler can be more helpful if you define a tiny type for each domain concept. For example, you could define
  * a small class for styles, anchor identifiers, display text, and HTML. Since these classes have one parameter and no
  * members, they can be defined as value classes: (below).
  * >> Given these classes, it is possible to write a version of title that has a less trivial type signature: (title,
  * below).
  */
object _04_2_DefiningYourOwnValueClasses {
  class Anchor(val value: String) extends AnyVal
  class Style(val value: String) extends AnyVal
  class Text(val value: String) extends AnyVal
  class Html(val value: String) extends AnyVal {
    override def toString: String = value
  }

  def simpleTitle(text: String, anchor: String, style: String): String =
    s"<a id='$anchor'><h1 class='$style'>$text</h1></a>"

  def title(text: Text, anchor: Anchor, style: Style): Html =
    new Html(
      s"<a id='${anchor.value}'>" +
        s"<h1 class='${style.value}'>" +
        text.value +
        "</h1></a>"
    )

  def main(args: Array[String]): Unit = {
    val title1 = simpleTitle("chap:vcls", "bold", "Value Classes")
    val htmlTitle = title(new Text("Hello World"), new Anchor("hello"),
      new Style("bold"))

    //    // If you try to use this version with the arguments in the wrong order, the compiler can now detect the error.
    //    val wrongHtmlTitle = title(new Anchor("chap:vcls"), new Style("bold"),
    //      new Text("Value Classes"))

    println(s"title1: $title1")
    println(s"htmlTitle: $htmlTitle")
  }
}