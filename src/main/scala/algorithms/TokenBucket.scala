package algorithms

final case class TokenBucket(
                              refillRate: TokenBucket.RefillRate,
                              capacity: TokenBucket.Capacity,
                              lastRefill: java.time.Instant
                            ) {
  def requestTokens(n: Int): Option[TokenBucket] =
    capacity.take(n).map(newCapacity => copy(capacity = newCapacity))

  def maybeRefill(currentTime: java.time.Instant): Option[TokenBucket] =
    refillRate
      .checkPossibleFills(java.time.Duration.between(lastRefill, currentTime))
      .map { newRefill =>
        copy(capacity = capacity.add(newRefill), lastRefill = currentTime)
      }
}

object TokenBucket {
  final case class RefillRate(howMany: Int, every: java.time.Duration) {
    def checkPossibleFills(inTime: java.time.Duration): Option[Int] = Option(
      howMany * inTime.toMillis / every.toMillis
    ).filter(_ > 0).filter(_ < Int.MaxValue).map(_.toInt)
  }

  final case class Capacity(currentCapacity: Int, maxCapacity: Int) {
    require(currentCapacity <= maxCapacity)

    def add(n: Int): Capacity =
      copy(currentCapacity = Math.min(maxCapacity, currentCapacity + n))

    def take(n: Int): Option[Capacity] = Option.when(n <= currentCapacity)(
      copy(currentCapacity = currentCapacity - n)
    )
  }


  def sampleStartTime: java.time.Instant = java.time.Instant.ofEpochSecond(100000)

  def sampleRefillRate: TokenBucket.RefillRate =
    TokenBucket.RefillRate(howMany = 5, every = java.time.Duration.ofSeconds(5))

  def sample: TokenBucket = TokenBucket(
    sampleRefillRate,
    TokenBucket.Capacity(currentCapacity = 0, maxCapacity = 10),
    lastRefill = sampleStartTime
  )

}