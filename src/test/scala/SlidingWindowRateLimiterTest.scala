import algorithms.SlidingWindowRateLimiter.{sampleInstant, sampleRateLimiter}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class SlidingWindowRateLimiterTest extends AnyFunSuite {

  assert(
    sampleRateLimiter.processItem(sampleInstant.plusMillis(100)).nonEmpty,
    "1 is Ok"
  )
  assert(
    sampleRateLimiter
      .processItem(sampleInstant.plusMillis(100))
      .flatMap(_.processItem(sampleInstant.plusMillis(200)))
      .nonEmpty,
    "2 is Ok"
  )
  assert(
    sampleRateLimiter
      .processItem(sampleInstant.plusMillis(100))
      .flatMap(_.processItem(sampleInstant.plusMillis(200)))
      .flatMap(_.processItem(sampleInstant.plusMillis(300)))
      .isEmpty,
    "3 is too much"
  )
  assert(
    sampleRateLimiter
      .processItem(sampleInstant.plusMillis(100))
      .flatMap(_.processItem(sampleInstant.plusMillis(200)))
      .flatMap(_.processItem(sampleInstant.plusMillis(1101)))
      .nonEmpty,
    "2 is ok, 1 second later we are fine"
  )
  assert(
    sampleRateLimiter
      .processItem(sampleInstant.plusMillis(100))
      .flatMap(_.processItem(sampleInstant.plusMillis(200)))
      .flatMap(_.processItem(sampleInstant.plusMillis(1100)))
      .flatMap(_.processItem(sampleInstant.plusMillis(1199)))
      .isEmpty,
    "2 is ok, 1 second we are fine, and another is not fine too close"
  )
  assert(
    sampleRateLimiter
      .processItem(sampleInstant.plusMillis(100))
      .flatMap(_.processItem(sampleInstant.plusMillis(200)))
      .flatMap(_.processItem(sampleInstant.plusMillis(1101)))
      .flatMap(_.processItem(sampleInstant.plusMillis(1201)))
      .nonEmpty,
    "2 is ok, 1 second we are fine, and another is fine after some time "
  )

}
