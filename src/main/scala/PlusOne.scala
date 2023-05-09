import scala.annotation.tailrec

object PlusOne extends App {

  plusOne(Array(1, 2, 3)) //.foreach(print)

  def plusOne(digits: Array[Int]): Array[Int] = {
    /*
    Recursive function to calculate add 1 to a list of digits.
    However this is a tail recursive solution to avoid the
    risk of running out of memory.
    */
    @tailrec
    def recursivePlusOne(digitList: List[Int],
                         carry: Int,
                         outputList: List[Int]
                        ): List[Int] = {
      digitList match {
        case digit :: tail => print(digit, carry)
          recursivePlusOne(tail, (digit + carry) / 10, (digit + carry) % 10 :: outputList)
        //check if there is carry over left in the end to add another digit
        case Nil => if (carry == 1) 1 :: outputList else outputList
      }
    }

    recursivePlusOne(digits.reverse.toList, 1, List()).toArray
  }

}
