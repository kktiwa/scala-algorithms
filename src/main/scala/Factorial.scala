import scala.annotation.tailrec

object Factorial extends App {

  print(factorial(5))

  def factorial(n: Int): Int = {
    @tailrec
    def iter(x: Int, result: Int): Int =
      if (x == 1) result
      else iter(x - 1, result * x)

    iter(n, 1)
  }

}
