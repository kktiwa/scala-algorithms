package arrays

object RemoveDuplicatesInPlace extends App {

  print(removeDuplicatesInPlace(Array(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)))

  def removeDuplicates(nums: Array[Int]): Int = {
    val nonDups = nums.toSet
    nonDups.size
  }

  def removeDuplicatesInPlace(nums: Array[Int]): Int = {
    // Length of the updated array
    var count = 0
    // Loop for all the elements in the array
    for (i <- nums.indices) {
      // If the current element is equal to the next element, we skip
      if (i < nums.length - 1 && nums(i) == nums(i + 1)) {
        ()
      } else {
        // We will update the array in place
        nums(count) = nums(i)
        count += 1
      }
    }
    count
  }

}
