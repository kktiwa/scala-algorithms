package arrays

object MergeSortedLists extends App {

  val i = List(1, 4, 7, 9)
  val j = List(3, 4, 5, 11, 12, 14)
  val result = merge(i, j)
  print(result)

  def merge(list1: List[Int], list2: List[Int]): List[Int] = {
    (list1, list2) match {
      case (Nil, Nil) => Nil
      case (x :: xs, Nil) => list1
      case (Nil, y :: ys) => list2
      case (x :: xs, y :: ys) =>
        if (x <= y) {
          //Adds `x` at the beginning of this list
          x :: merge(list1.tail, list2)
        } else
        //Adds `y` at the beginning of this list
          y :: merge(list1, list2.tail)
    }
  }

}
