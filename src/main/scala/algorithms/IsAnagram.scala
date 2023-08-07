package algorithms

object IsAnagram extends App {

  print(isAnagram("Abc", "cba"))

  def isAnagram(s: String, t: String): Boolean = {
    val first = s.toCharArray.sorted.mkString
    val second = t.toCharArray.sorted.mkString
    first equalsIgnoreCase second
  }

}
