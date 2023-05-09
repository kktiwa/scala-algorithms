import scala.annotation.tailrec

object Fibonacci extends App {

  print(fibonacci(6))

  def fibonacci(n: Int): Int = {
    @tailrec
    def go(i: Int, previous: Int, beforePrevious: Int): Int =
      if (i >= n) previous else go(i + 1, previous + beforePrevious, previous)

    go(i = 1, previous = 1, beforePrevious = 0)
  }

}
