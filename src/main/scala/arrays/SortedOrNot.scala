package arrays

object SortedOrNot extends App {

  println(isSorted(List(1, 2, 3, 4, 6)))

  def isSorted(list: List[Int]): Boolean = {
    !list.lazyZip(list.tail).exists {
      case (x, y) => x > y
    }
  }

}
