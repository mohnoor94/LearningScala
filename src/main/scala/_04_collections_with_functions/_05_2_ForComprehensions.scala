package _04_collections_with_functions

object _05_2_ForComprehensions extends App {
  val names = List("Rami ", "   Sami", "Ali  ", " Emad", "Mohaammad", "Noor", "Saed")

  // trimmedName is a val (only with the val keyword left out.)
  for {
    name <- names
    trimmedName = name.trim
    if trimmedName.endsWith("d")
  } println(trimmedName)
}