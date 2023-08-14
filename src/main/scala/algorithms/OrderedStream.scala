package algorithms

/**
 * Input
 * ["OrderedStream", "insert", "insert", "insert", "insert", "insert"]
 * [[5], [3, "ccccc"], [1, "aaaaa"], [2, "bbbbb"], [5, "eeeee"], [4, "ddddd"]]
 *
 * Output
 * [null, [], ["aaaaa"], ["bbbbb", "ccccc"], [], ["ddddd", "eeeee"]]
 *
 */
object OrderedStream extends App {

  val stream = new OrderedStream(5)
  println(stream.insert(3, "ccccc"))
  println(stream.insert(1, "aaaaa"))
  println(stream.insert(2, "bbbbb"))
  println(stream.insert(5, "eeeee"))
  println(stream.insert(4, "ddddd"))

  class OrderedStream(numberOfItems: Int) {
    val stream = Array.ofDim[String](numberOfItems + 1)
    var offset = 0

    def insert(id: Int, value: String): List[String] = {
      stream(id - 1) = value
      //Finds index of the first element where value is null
      val lastCommit = stream.indexWhere(_ == null)
      val start = offset
      offset = lastCommit
      //return an sliced list from the incoming index to the first index
      //where there is no insertion till yet.
      stream.slice(start, lastCommit).toList
    }
  }

}
