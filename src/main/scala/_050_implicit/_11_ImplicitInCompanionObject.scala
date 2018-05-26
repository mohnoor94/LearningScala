package _050_implicit

class Artist(val firstName: String, val lastName: String)

object Artist {
  import scala.language.implicitConversions
  implicit def tupleToArtist(x: (String, String)): Artist = new Artist(x._1, x._2)
}

/**
  * we can also use a companion object to store any implicit recipes
  * TBH, this is an ugly example, but you got the idea!
  */
object _11_ImplicitInCompanionObject extends App {
  def playPerformer(artist: Artist) = s"Now playing: ${artist.firstName} ${artist.lastName}"

  println(playPerformer(new Artist("Elvis", "Presley")))
  println(playPerformer("Suzanne" -> "Vega"))
  println(playPerformer("Elvis", "Presley"))
}