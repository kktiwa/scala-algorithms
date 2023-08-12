package strings

import scala.collection.mutable

/**
 * A pangram is a sentence where every letter of the English alphabet appears at least once.
 * Given a string sentence containing English letters (lower or upper-case), return true if sentence is a pangram, or false otherwise.
 * Note: The given sentence might contain other characters like digits or spaces, your solution should handle these too.
 */
object Pangram extends App {

  println(isPangram("TheQuickBrownFoxJumpsOverTheLazyDog"))
  println(isPangram("This is not a pangram"))
  println(isPangram("abcdef ghijkl mnopqr stuvwxyz"))
  println(isPangram("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"))

  def isPangram(sentence: String): Boolean = {
    val characterTracker = mutable.Map[Char, Int]().empty
    val sanitised = sentence.strip().replaceAll(" ", "").toLowerCase
    sanitised.toCharArray.map { char =>
      characterTracker += (char -> 1)
    }
    characterTracker.size == 26
  }
}
