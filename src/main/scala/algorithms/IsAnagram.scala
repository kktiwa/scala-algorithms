package algorithms

/**
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
object IsAnagram extends App {

  print(isAnagram("Abc", "cba"))

  def isAnagram(s: String, t: String): Boolean = {
    val first = s.toCharArray.sorted.mkString
    val second = t.toCharArray.sorted.mkString
    first equalsIgnoreCase second
  }

  def isAnagramNoSorting(s: String, t: String): Boolean = {
    if (s.length != t.length) {
      return false
    }
    val charsCount = Array.fill(26)(0)
    val toIdx = (_: Char) - 'a'
    for (c <- s) {
      charsCount(toIdx(c)) += 1
    }
    for (c <- t) {
      charsCount(toIdx(c)) -= 1
    }
    charsCount.forall(_ == 0)
  }

}
