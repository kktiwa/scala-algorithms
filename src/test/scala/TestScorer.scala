import com.cashapp.scorer.Scorer
import com.cashapp.models.{EventPlayerScore, PlayerScore}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._

class TestScorer extends AnyFlatSpec {

  "Scorer" should "return highest player name at the top" in {
    val scores = List(
      PlayerScore(name = "A", score = 10),
      PlayerScore(name = "C", score = 30),
      PlayerScore(name = "B", score = 20)
    )

    val expected = List(
      PlayerScore(name = "C", score = 30),
      PlayerScore(name = "B", score = 20),
      PlayerScore(name = "A", score = 10),
    )
    val actual = Scorer.score(scores)
    actual should contain theSameElementsInOrderAs expected
  }

  it should "return highest player by event at the top" in {
    val eventScores = List(
      EventPlayerScore(
        eventName = "Lead",
        List(
          PlayerScore(name = "A", score = 40),
          PlayerScore(name = "B", score = 10),
          PlayerScore(name = "C", score = 40),
        )
      ),
      EventPlayerScore(
        eventName = "Phantom",
        List(
          PlayerScore(name = "B", score = 70),
          PlayerScore(name = "A", score = 90),
          PlayerScore(name = "C", score = 100),
        )
      )
    )
    val expected = List(
      EventPlayerScore(
        eventName = "Lead",
        List(
          PlayerScore("A", 40),
          PlayerScore("C", 40),
          PlayerScore("B", 10)
        )
      ),
      EventPlayerScore(
        eventName = "Phantom",
        List(
          PlayerScore(name = "C", score = 100),
          PlayerScore(name = "A", score = 90),
          PlayerScore(name = "B", score = 70),
        )
      )
    )
    val actual = Scorer.scoreByEvent(eventScores)
    actual should contain theSameElementsInOrderAs expected
  }

}
