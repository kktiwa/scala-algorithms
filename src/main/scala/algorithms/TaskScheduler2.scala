package algorithms

import scala.annotation.tailrec

object TaskScheduler2 {

  def taskSchedulerII(tasks: Array[Int], space: Int): Long =
    go(tasks.toList, Map.empty, 1, space)

  @tailrec
  def go(tasks: List[Int], breakMap: Map[Int, Long], day: Long, space: Int): Long =
    tasks match {
      case Nil => day - 1
      case h :: tail =>
        val breakUntil = breakMap.getOrElse(h, 0L)
        if (day > breakUntil) go(tail, breakMap.updated(h, day + space), day + 1, space)
        else go(tasks, breakMap, breakUntil + 1, space)
    }

}
