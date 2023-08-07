package algorithms

import scala.annotation.tailrec

/**
 * Explained at: https://mipsmonsta.medium.com/task-scheduler-programming-interview-question-explained-e445e5447a7d
 */
object TaskScheduler {

  import scala.collection.mutable

  def leastInterval(tasks: Array[Char], n: Int): Int = {
    val priorityQueue: mutable.PriorityQueue[(Char, Int)] = mutable.PriorityQueue[(Char, Int)](
      tasks
        .groupBy(identity)
        .view
        .mapValues(_.length)
        .toSeq: _*
    )(Ordering.by(task => task._2))

    @tailrec
    def loop(now: Int, coolDown: Map[Int, (Char, Int)]): Int = {
      if (coolDown.contains(now)) {
        priorityQueue.enqueue(coolDown(now))
        loop(now, coolDown - now)
      }
      else if (priorityQueue.nonEmpty) {
        val task: (Char, Int) = priorityQueue.dequeue()

        if (task._2 > 1) loop(now + 1, coolDown + (now + n + 1 -> (task._1, task._2 - 1)))
        else loop(now + 1, coolDown)
      }
      else if (priorityQueue.isEmpty && coolDown.isEmpty) now
      else loop(now + 1, coolDown)
    }

    loop(0, Map.empty)
  }
}
