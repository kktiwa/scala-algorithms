package algorithms

object LongestPrefix extends App {

  private val inputArray = Array("cap", "camera", "camel", "cambodia")
  print(s"Prefix value", longestCommonPrefix(inputArray))

  /**
   * lazyZip allows strict operations to be performed on the lazily evaluated pairs or
   * chained calls. Implicit conversion to Iterable[(A, B)] is also supported.
   *
   * @param strs
   * @return
   */
  def longestCommonPrefix(strs: Array[String]): String = {
    strs.foldLeft("") { (_, _) =>
      //take the shortest string and longest string
      strs.min.lazyZip(strs.max)
        //compare each character and accept until they don't match
        .takeWhile(v => v._1 == v._2)
        //unzip any of the 2 zipped lists of common chars
        .unzip._1
        //convert it to strings
        .mkString
    }
  }
}
