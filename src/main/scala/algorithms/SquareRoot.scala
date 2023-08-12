package algorithms

import scala.annotation.tailrec

object SquareRoot extends App {

  print(findSquareRoot(4))

  def findSquareRoot(num: Int): Int = {
    require(num >= 0, "Negative number found")

    @tailrec
    def recur(low: Int, high: Int): Int =
      if (low > high) high
      else (low + high) / 2 match {
        case mid if mid * mid == num => mid
        case mid if mid > num / mid => recur(low, mid - 1)
        case mid => recur(mid + 1, high)
      }

    if (num < 2) num else recur(low = 2, high = num / 2)

  }
}
