package _960_general_examples

/**
  * Recognize visually similar sentences
  * Visually similar characters are those look similar
  * Visually similar characters to consider:
  * O 0 Q
  * I 1
  * S 5
  * The input are assumed to contain capital letters only.
  */
object _008_VisuallySimilar {
  private val replacements: Map[Char, Char] = Map('Q' -> 'O', '0' -> 'O', '1' -> 'I', 'S' -> '5')
  private val transformer: Char => Char = (ch: Char) => replacements.getOrElse(ch, ch)

  def isVisuallySimilar(firstSentence: String, secondSentence: String): Boolean =
    firstSentence.map(transformer) equals secondSentence.map(transformer)

  def main(args: Array[String]): Unit = {
    println(isVisuallySimilar("HELLO", "HELLQ"))
    println(isVisuallySimilar("HELLO", "HELLQ World"))
    println(isVisuallySimilar("HI FIVE", "H1 F1VE"))
  }
}