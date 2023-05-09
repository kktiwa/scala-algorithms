object MaxSubArray extends App {

  def maxSubArray(someArray: Array[Int]) = {
    someArray.foldLeft(0 -> 0) {
      case ((maxUpToHere, maxSoFar), n) =>
        val maxEndingHere = 0 max maxUpToHere + n
        maxEndingHere -> (maxEndingHere max maxSoFar)
    }._2
  }
}
