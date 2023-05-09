object Sorted2Sum extends App {
  val result = sorted2Sum(Array(1, 3, 7, 9, 11), 10)
  result.foreach(println)

  def sorted2Sum(input: Array[Int], goal: Int) = {
    //Key(Element) -> Value(Index)
    val inputMap = input.zipWithIndex.toMap
    val solution = input.zipWithIndex.flatMap { case (item, itemIndex) =>
      inputMap.get(goal - item).map { restIndex =>
        //for unification same num pairs like (1, 4) and (4, 1) - so it will give always (1 - minIndex, 4 - maxIndex)
        val minIndex = Math.min(itemIndex, restIndex)
        val maxIndex = Math.max(itemIndex, restIndex)
        //tuple of the index pairs
        minIndex -> maxIndex
      }
    }.toSet
    solution
  }

}
