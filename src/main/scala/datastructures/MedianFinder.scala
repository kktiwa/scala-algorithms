package datastructures

import scala.collection.mutable

object MedianFinder extends App {

  private val small = mutable.PriorityQueue[Int]()
  private val large = mutable.PriorityQueue[Int]()(Ordering.Int.reverse)

  def addNum(num: Int) {
    require(num >= 1, "Negatives not allowed")

    if (small.isEmpty || num <= small.head) {
      small.enqueue(num)
      //adjust heaps by moving biggest element from `small` into `large`
      if (small.size > large.size + 1) large.enqueue(small.dequeue())
    } else {
      large.enqueue(num)
      //adjust heaps by moving smallest element from `large` into `small`
      if (large.size > small.size) small.enqueue(large.dequeue())
    }
  }

  def findMedian(): Double = {
    //head: Returns the element with the highest priority in the queue
    if (small.size == large.size) (small.head + large.head) / 2.0
    else small.head
  }

  MedianFinder.addNum(1) // arr = [1]
  MedianFinder.addNum(2) // arr = [1, 2]
  println(MedianFinder.findMedian()) // return 1.5 (i.e., (1 + 2) / 2)
  MedianFinder.addNum(3) // arr[1, 2, 3]
  println(MedianFinder.findMedian()) // return 2.0

}
