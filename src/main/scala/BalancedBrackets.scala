import scala.annotation.tailrec

object BalancedBrackets extends App {

  //key = open bracket value=close bracket
  private val OpenToClose: Map[Char, Char] = Map('{' -> '}', '[' -> ']', '(' -> ')')

  //key = close bracket value=open bracket
  private val CloseToOpen: Map[Char, Char] = OpenToClose.map(_.swap)

  def parenthesesAreBalanced(s: String): Boolean = {
    if (s.isEmpty) true
    else {
      @tailrec
      def go(position: Int, stack: List[Char]): Boolean = {
        if (position == s.length) stack.isEmpty
        else {
          //latest bracket
          val char = s(position)
          val isOpening = OpenToClose.contains(char)
          val isClosing = CloseToOpen.contains(char)

          //if open bracket, add it to the front of the list/stack
          if (isOpening) go(position + 1, char :: stack)
          else if (isClosing) {
            val expectedCharForMatching = CloseToOpen(char)
            stack match {
              //is the last open bracket on the stack/list matching the corresponding closing bracket
              case `expectedCharForMatching` :: rest =>
                //we pop out the matching open bracket
                go(position + 1, rest)
              //if the next bracket we approach is a closing bracket that is not the latest bracket, we terminate with a failure
              case _ =>
                false
            }
          } else false
        }
      }

      go(position = 0, stack = List.empty)
    }
  }


}
