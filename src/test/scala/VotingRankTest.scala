import algorithms.VotingRank
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._

class VotingRankTest extends AnyFlatSpec {

  "VotingRank" should "rank correctly for no-tie breaking cases" in {
    val input = Array("ABC", "ACB", "ABC", "ACB", "ACB")
    val actual = VotingRank.rankTeams(input)
    actual shouldBe "ACB"
  }

  it should "work correctly for tie-breaking cases" in {
    val input = Array("WXYZ", "XYZW")
    val actual = VotingRank.rankTeams(input)
    actual shouldBe "XWYZ"
  }

  it should "work correctly for cases when 1 voter" in {
    val input = Array("ZMNAGUEDSJYLBOPHRQICWFXTVK")
    val actual = VotingRank.rankTeams(input)
    actual shouldBe "ZMNAGUEDSJYLBOPHRQICWFXTVK"
  }

}
