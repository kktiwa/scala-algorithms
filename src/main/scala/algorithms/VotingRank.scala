package algorithms

object VotingRank {

  def rankTeams(votes: Array[String]): String = {
    val teams = votes.headOption.getOrElse("")
    val rankings = Iterator
      //the iterator producing values `start, start + 1, ..., end - 1`
      .range(0, teams.length)
      .map(
        position =>
          //The .view syntax creates a structure that mirrors another structure,
          //until "forced" by an eager operation like .toList, .foreach, .forall, .count.
          votes.view.map(_.charAt(position))
            //key of the map is each character itself
            .groupMapReduce(identity)
            //for each key the mapping is a count of 1
            (_ => 1)
            //reduce operation is basically adding the counts
            (_ + _).withDefaultValue(0))
      .toSeq

    //List(Map(W -> 1, X -> 1), Map(X -> 1, Y -> 1), Map(Y -> 1, Z -> 1), Map(W -> 1, Z -> 1))
    //List(Map(A -> 5), Map(B -> 2, C -> 3), Map(B -> 3, C -> 2))
    //Sorts the characters of this string according to an Ordering.
    teams.sorted {
      rankings.foldRight[Ordering[Char]](Ordering.Char) {
        case (ranking, ordering) =>
          //def compare(x:T, y:T) = Ordering[S].compare(f(x), f(y))
          Ordering.by[Char, Int](-ranking(_)).orElse(ordering)
      }
    }
  }

}
