package strings

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object ReverseVowels extends App {

  println(reverseVowels("leetcode"))

  def reverseVowels(word: String): String = {
    val vowels = Set('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    val charsToCheck = word.toCharArray

    val seen = new mutable.Stack[Char]()
    val indexes = new ArrayBuffer[Int]()

    for (idx <- charsToCheck.indices) {
      charsToCheck(idx) match {
        case c if vowels(c) =>
          seen.push(c)
          indexes.addOne(idx)
        case _ =>
      }
    }

    indexes.foreach(charsToCheck(_) = seen.pop())

    new String(charsToCheck)
  }

}
