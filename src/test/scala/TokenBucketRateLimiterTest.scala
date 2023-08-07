import algorithms.TokenBucket.{sample, sampleRefillRate, sampleStartTime}
import org.scalatest.funsuite.AnyFunSuite

class TokenBucketRateLimiterTest extends AnyFunSuite {

  assert(
    sampleRefillRate.checkPossibleFills(java.time.Duration.ofSeconds(4)) ==
      None
  )
  assert(
    sampleRefillRate.checkPossibleFills(java.time.Duration.ofSeconds(5)) ==
      Some(5)
  )
  assert(
    sampleRefillRate.checkPossibleFills(java.time.Duration.ofSeconds(10)) ==
      Some(10)
  )
  assert(
    sampleRefillRate.checkPossibleFills(java.time.Duration.ofSeconds(11)) ==
      Some(10)
  )
  assert(
    sample.requestTokens(1).isEmpty,
    "Initially there is no capacity, so we cannot request anything"
  )
  assert(
    sample
      .maybeRefill(sampleStartTime.plusSeconds(4))
      .flatMap(_.requestTokens(1))
      .isEmpty,
    "After 4 seconds, we have not refilled, so we cannot request tokens"
  )
  assert(
    sample
      .maybeRefill(sampleStartTime.plusSeconds(5))
      .flatMap(_.requestTokens(1))
      .nonEmpty,
    "After 5 seconds, we have refilled, so we can request tokens"
  )
  assert(
    sample
      .maybeRefill(sampleStartTime.plusSeconds(5))
      .flatMap(_.requestTokens(6))
      .isEmpty,
    "After 5 seconds, we have only 5 tokens, so cannot request 6"
  )
  assert(
    sample
      .maybeRefill(sampleStartTime.plusSeconds(10))
      .flatMap(_.requestTokens(6))
      .nonEmpty,
    "After 10 seconds, we have 10 tokens, so can request 6"
  )
  assert(
    sample
      .maybeRefill(sampleStartTime.plusSeconds(10))
      .flatMap(_.requestTokens(6))
      .flatMap(_.requestTokens(4))
      .nonEmpty,
    "After 10 seconds, we have 10 tokens, so can request 6, and then 4"
  )
  assert(
    sample
      .maybeRefill(sampleStartTime.plusSeconds(10))
      .flatMap(_.requestTokens(6))
      .flatMap(_.requestTokens(4))
      .flatMap(_.requestTokens(1))
      .isEmpty,
    "After 10 seconds, we have 10 tokens, so can request 6, and then 4, but not 1 more"
  )

}
