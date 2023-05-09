object SingleNumber extends App {

  print(singleNumber1(Array(4, 1, 2, 1, 2)))

  def singleNumber(nums: Array[Int]): Int = {
    var res = 0
    for (n <- nums) {
      //bitwise logical and assignment operator
      res ^= n
      println(s"res value $res")
    }
    res
  }

  def singleNumber1(nums: Array[Int]): Int = {
    var distinct = Set.empty[Int]
    for (i <- nums) {
      //if an element is duplicate, it will end up being completely removed
      if (distinct.contains(i)) {
        distinct -= i
      }
      //the only unique element will remain in the set in the end
      else {
        distinct += i
      }
    }
    distinct.head
  }

}
