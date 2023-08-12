package algorithms

object LongestPrefix extends App {

  private val inputArray = Array("camera", "camel")
  print(s"Prefix value", longestCommonPrefix(inputArray))

  def longestCommonPrefix(strs: Array[String]): String = {
    strs.foldLeft("") { (_, _) =>
      //take the smallest and longest array lengths
      (strs.min, strs.max)
        .zipped
        //compare each character and accept until they don't match
        .takeWhile(v => v._1 == v._2)
        //unzip any of the 2 zipped lists of common chars
        .unzip._1
        //convert it to strings
        .mkString
    }
  }
}
