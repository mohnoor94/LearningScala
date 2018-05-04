package _98_problem_solving

import scala.collection.immutable

/**
  * Problem Description:
  * https://en.wikipedia.org/wiki/Water_pouring_puzzle
  *
  * General Solution
  */
object _01_TheWaterPouringProblem extends App {
  val problem = new Pouring(Vector(405, 805, 5, 1000))
  //  println(problem.moves)
  //  println(problem.pathSets.take(3).toList)

  println(problem.solution(320))

}

class Pouring(capacity: Vector[Int]) {
  // States
  type State = Vector[Int]

  // initial state, all glasses have zero amount of water
  val initialState: State = capacity map (_ => 0)


  // Moves
  trait Move {
    def change(state: State): State
  }

  case class Empty(glass: Int) extends Move {
    override def change(state: State): State = state updated(glass, 0)
  }

  case class Fill(glass: Int) extends Move {
    override def change(state: State): State = state updated(glass, capacity(glass))
  }

  case class Pour(from: Int, to: Int) extends Move {
    override def change(state: State): State = {
      val amount = state(from) min capacity(to) - state(to)
      state updated(from, state(from) - amount) updated(to, state(to) + amount)
    }
  }


  // Possible Moves
  val glasses: Range = capacity.indices // == 0 until capacity.length

  val moves: immutable.IndexedSeq[Move] =
    (for (g <- glasses) yield Empty(g)) ++
      (for (g <- glasses) yield Fill(g)) ++
      (for (from <- glasses; to <- glasses if from != to) yield Pour(from, to))

  // Paths
  // last move is the first on the list
  class Path(history: List[Move], val endState: State) {
    //    def endState: State = (history foldRight initialState) (_ change _)

    def extend(move: Move) = new Path(move :: history, move change endState)

    override def toString: String = (history.reverse mkString " ") + " --> " + endState

    //    def endState: State = trackState(history)
    //    private def trackState(xs: List[Move]): State = xs match {
    //      case Nil => initialState
    //      case move :: xs1 => move change trackState(xs1)
  }

  val initialPath: Path = new Path(Nil, initialState)

  def from(paths: Set[Path], explored: Set[State]): Stream[Set[Path]] =
    if (paths.isEmpty) Stream.empty
    else {
      val more = for {
        path <- paths
        next <- moves map path.extend
        if !(explored contains next.endState)
      } yield next
      paths #:: from(more, explored ++ (more map (_.endState)))
    }

  val pathSets: Stream[Set[Path]] = from(Set(initialPath), Set(initialState))

  def solution(target: Int): Stream[Path] =
    for {
      pathSet <- pathSets
      path <- pathSet
      if path.endState contains target
    } yield path
}