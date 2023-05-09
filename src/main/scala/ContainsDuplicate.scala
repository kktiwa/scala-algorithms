object ContainsDuplicate extends App {

  print(containsDuplicate(Array(1, 2, 3)))

  def containsDuplicate(nums: Array[Int]): Boolean = {
    var set = Set[Int]().empty
    for (n <- nums) {
      set += n
    }
    set.size != nums.length
  }

}
