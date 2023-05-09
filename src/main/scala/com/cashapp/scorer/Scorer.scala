package com.cashapp.scorer

import com.cashapp.models._

object Scorer {

  def score(scoresList: Seq[PlayerScore]): Seq[PlayerScore] = {
    scoresList
      .sortWith(_.score > _.score)
  }

  def scoreByEvent(scoresByEvent: List[EventPlayerScore]): Seq[EventPlayerScore] = {
    scoresByEvent
      .map { eps =>
        eps.copy(scores = score(eps.scores))
      }
  }
}
