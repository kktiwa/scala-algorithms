package arrays

object NumGoodPairs extends App {
  println(numIdenticalPairs(Array(1, 2, 3, 1, 1, 3)))

  def numIdenticalPairs(nums: Array[Int]): Int = {
    import scala.collection.mutable
    val seen = new mutable.HashMap[Int, Int]()
    var result = 0
    //Result: 0 Num: 1 Count: 0
    //Result: 0 Num: 2 Count: 0
    //Result: 0 Num: 3 Count: 0
    //Result: 1 Num: 1 Count: 1
    //Result: 3 Num: 1 Count: 2
    //Result: 4 Num: 3 Count: 1
    for (n <- nums) {
      result += seen.getOrElse(n, 0)
      println(s"Result: $result Num: $n Count: ${seen.getOrElse(n, 0)}")
      seen.updateWith(n) {
        case Some(value) => Some(value + 1)
        case None => Some(1)
      }
    }
    result
  }

}
