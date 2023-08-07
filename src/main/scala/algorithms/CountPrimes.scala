package algorithms

object CountPrimes extends App {

  print("Count of primes less than 10 is ", countPrimes(10))

  def countPrimes(n: Int): Int = {
    val primes = for (num <- 2 to n; if num % 2 == 0)
      yield num

    primes.length
  }


}
