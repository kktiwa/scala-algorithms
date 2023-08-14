package algorithms

import scala.annotation.tailrec

object MinSteps extends App {
  //Operation 1: multiply by 2
  //Operation 2: divide by 3
  @tailrec
  def minOperations(num: Int, steps: Int = 0): Int = {
    num match {
      //even
      case x if x % 2 == 0 =>
        minOperations(num = x / 2, steps + 1)
      //odd
      case y if y % 3 == 0 =>
        minOperations(num = y * 3, steps + 1)
      case _ => 1
    }
  }

  print(s"Steps: ${minOperations(10)}")
}
