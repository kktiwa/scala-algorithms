object MissingNumber extends App {

  print(missingNumber(Array(0, 1)))

  def missingNumber(nums: Array[Int]): Int = {
    val range = (0 to nums.max).toArray
    val missing = range.toSet diff nums.toSet
    missing.foreach(print)
    missing.head
  }

}
