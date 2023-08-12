package arrays

object MergeIntervals extends App {

  val result = merge(Array(Array(1, 3), Array(2, 6), Array(8, 10), Array(15, 18)))
  result.foreach(x => println(x(0), x(1)))

  def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
    intervals
      //sort arrays by the element at index `0`
      .sortInPlaceBy(_(0))
      .foldLeft(collection.mutable.ArrayBuffer[Array[Int]]())((buf, next) =>
        buf.lastOption match {
          //[previous = [1,3], next = [2,6]]
          case Some(previous) if previous(1) >= next(0) =>
            previous(1) = previous(1) max next(1)
            buf
          case _ => buf.append(next)
        }
      ).toArray
  }
}
