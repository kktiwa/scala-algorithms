package algorithms

/**
 * In some systems, you may want to limit the number of requests per a certain time unit.
 * While some rate limiting algorithms would focus on not exceeding a certain number of requests in flight, there may be cases where eg your application may be reaching out to another application which has a certain limiting of number of requests in any one hour, for example.
 * We wish to limit that by possibly pushing back our clients.
 *
 * @param itemTimes
 * @param maximumRate
 */

final case class SlidingWindowRateLimiter(
                                           itemTimes: scala.collection.immutable.Queue[java.time.Instant],
                                           maximumRate: SlidingWindowRateLimiter.MaximumRate
                                         ) {

  final implicit class RichQueue[T](queue: scala.collection.immutable.Queue[T]) {
    @scala.annotation.tailrec
    def dequeueWhile(f: T => Boolean): scala.collection.immutable.Queue[T] = {
      //Optionally retrieves the first element and a queue of the remaining elements.
      queue.dequeueOption match {
        case Some((item, q)) if f(item) =>
          q.dequeueWhile(f)
        case _ =>
          queue
      }
    }
  }

  def processItem(
                   atTime: java.time.Instant
                 ): Option[SlidingWindowRateLimiter] = {
    val newQueue = itemTimes.dequeueWhile(instant =>
      atTime.minus(maximumRate.duration).isAfter(instant)
    )
    if (
      newQueue.length == itemTimes.length && maximumRate.count == newQueue.length
    ) None
    else Some(copy(itemTimes = newQueue.enqueue(atTime)))
  }
}

object SlidingWindowRateLimiter {
  final case class MaximumRate(count: Int, duration: java.time.Duration)

  def sampleMaximumRate: SlidingWindowRateLimiter.MaximumRate =
    SlidingWindowRateLimiter.MaximumRate(
      count = 2,
      duration = java.time.Duration.ofSeconds(1)
    )

  def sampleRateLimiter: SlidingWindowRateLimiter = SlidingWindowRateLimiter(
    maximumRate = sampleMaximumRate,
    itemTimes = scala.collection.immutable.Queue.empty
  )

  def sampleInstant: java.time.Instant = java.time.Instant.ofEpochSecond(100)
}

