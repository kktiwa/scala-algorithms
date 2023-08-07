package strings

object ReverseString extends App {

  val input = Array('h', 'e', 'l', 'l', 'o')
  print(reverseString(input))

  def reverseString(s: Array[Char]): String = {
    (for (i <- s.length - 1 to 0 by -1)
      yield s(i)
      ).mkString
  }

}
