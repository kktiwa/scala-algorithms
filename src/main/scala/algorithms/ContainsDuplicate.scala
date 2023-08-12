package algorithms

object ContainsDuplicate extends App {

  print(containsDuplicate(Array(1, 2, 3, 5, 7, 8, 4)))

  def containsDuplicate(nums: Array[Int]): Boolean = {
    var set = Set[Int]().empty
    for (n <- nums) {
      if (set.contains(n)) {
        return true
      } else {
        set += n
      }
    }
    false
  }

}
