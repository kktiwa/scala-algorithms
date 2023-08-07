package algorithms

import scala.annotation.tailrec

object RomanNumeral {
  def romanToInt(s: String): Int = {
    /* Map to lookup the value of the roman literal.
       Contains the cases where subtraction is used
    */
    val r2i = Map(
      "I" -> 1,
      "V" -> 5,
      "X" -> 10,
      "L" -> 50,
      "C" -> 100,
      "D" -> 500,
      "M" -> 1000,
      "IV" -> 4,
      "IX" -> 9,
      "XL" -> 40,
      "XC" -> 90,
      "CD" -> 400,
      "CM" -> 900
    )

    /*
    Create a recursive function to
        avoid use of vars
        avoid use of loops
    The function loops through a list of strings of single roman letter.
    First it searches if the 2 characters together are found in the r2i map (this
    is for the case where subtraction is applicable). If the combination is found
    it gets the corresponding val from the map and add it to the final value, and
    recursively continue the calculation.
    If not found then it searches for the first charter in the map and gets the
    corresponding val from the map and add it to the final value, and recursively
    continue the calculation.
    Next if there is only 1 letter left in the list then it gets the corresponding
    value from the map and add it to the final value
    Last if there are no letters in the list return the final value
    */
    @tailrec
    def romanToIntRecursive(s: List[String], value: Int): Int = {
      s match {
        case a :: b :: tail => { //first case if there are more than 2 letters in the list
          if (r2i.contains(a + b))
            romanToIntRecursive(tail, value + r2i(a + b))
          else
            romanToIntRecursive(b :: tail, value + r2i(a))
        }
        case a :: Nil => value + r2i(a) //second case if there is only 1 letter left
        case Nil => value // last case when there is no letter left
      }
    }

    val sList = s.toList.map(_.toString)
    romanToIntRecursive(sList, 0)
  }


}
