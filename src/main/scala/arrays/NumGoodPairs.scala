package arrays

object NumGoodPairs extends App {
  println(numIdenticalPairs(Array(1, 2, 3, 1, 1, 3)))

  def numIdenticalPairs(nums: Array[Int]): Int = {
    import scala.collection.mutable
    val seen = new mutable.HashMap[Int, Int]()
    var result = 0
    for (n <- nums) {
      result += seen.getOrElse(n, 0)
      seen.updateWith(n) {
        case Some(value) => Some(value + 1)
        case None => Some(1)
      }
    }
    result
  }

}
