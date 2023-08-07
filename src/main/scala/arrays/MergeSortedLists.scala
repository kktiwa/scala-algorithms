package arrays

object MergeSortedLists extends App {

  val i = List(1, 4, 7, 9)
  val j = List(3, 4, 5, 11, 12, 14)
  merge(i, j).foreach(print)

  def merge(i: List[Int], j: List[Int]): List[Int] = {
    (i, j) match {
      case (Nil, Nil) => Nil
      case (x :: xs, Nil) => i
      case (Nil, y :: ys) => j
      case (x :: xs, y :: ys) =>
        if (x <= y)
          x :: merge(i.tail, j)
        else
          y :: merge(i, j.tail)
    }
  }

}
