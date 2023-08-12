package arrays

object IntersectionOfArrays extends App {

  val result = intersection(Array(1, 2, 5, 6, 3), Array(2, 5, 7))
  result.foreach(println)

  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    nums1.intersect(nums2).distinct
  }

}
