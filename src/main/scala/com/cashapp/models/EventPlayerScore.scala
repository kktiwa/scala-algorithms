package com.cashapp.models

case class EventPlayerScore(
                             eventName: String,
                             scores: Seq[PlayerScore]
                           )
