package arrays

object ThreeSumProblem extends App {

  print(threeSum1(Array(1, 2, 3, -5, 2)))

  def threeSum(nums: Array[Int]): List[List[Int]] = {
    nums
      .combinations(3)
      .collect { case Array(a, b, c) if (a + b + c) == 0 => List(a, b, c) }
      .toList
  }

  def threeSum1(nums: Array[Int]) = {
    val sortedNums = nums.sorted
    var triplets: Set[List[Int]] = Set.empty
    for (index <- 0 until nums.length - 2) {

      if (!(index > 0 && sortedNums(index) == sortedNums(index - 1))) {
        var (left: Int, right: Int) = (index + 1, nums.length - 1)

        while (left < right) {
          val sum = sortedNums(index) + sortedNums(left) + sortedNums(right)
          //shift right index if sum > 0
          if (sum > 0) {
            right -= 1
          }
          //move left index if sum < 0
          else if (sum < 0) {
            left += 1
          }
          else {
            triplets += List(sortedNums(index), sortedNums(left), sortedNums(right))
            //to skip the duplicate number
            if (left < right && sortedNums(left) == sortedNums(left + 1)) {
              left += 1
            }
            //to skip the duplicate number
            if (left < right && sortedNums(right) == sortedNums(right - 1)) {
              right -= 1
            }
            left += 1
            right -= 1
          }
        }
      }
    }

    triplets.toList
  }

}
