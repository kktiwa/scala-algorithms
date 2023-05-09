import scala.annotation.tailrec

object ReverseArray extends App {

  val result = rotateArray(Array(1, 2, 3, 4, 5, 6, 7), 3)
  result.foreach(print)

  def rotateArray(A: Array[Int], K: Int): Array[Int] = {
    if (A.isEmpty) A
    else rotate(A.toList, K).toArray
  }

  //Prepend the last element before the remaining array
  def rotateStepwise(l: List[Int]) = {
    l.take(l.size - 1).+:(l.last)
  }

  //If you have a recursive function that calls itself as its last action, then you can reuse the stack frame of that function.
  //This is called tail recursion.
  //A tail recursive function can execute in constant stack space
  @tailrec
  def rotate(l: List[Int], K: Int): List[Int] = {
    if (K == 0) l
    else rotate(rotateStepwise(l), K - 1)
  }
}