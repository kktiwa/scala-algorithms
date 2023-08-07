package algorithms

import scala.collection.mutable


case class Counter[T]() {
  lazy val state: mutable.Map[T, Int] = mutable.HashMap[T, Int]()

  def apply(key: T): Int = state.getOrElse(key, 0)

  def count(key: T): Unit = {
    val newCount = 1 + this (key)
    state += (key -> newCount)
  }

  def mostOccurring(topN: Int) = state
    .groupMapReduce(identity)(_ => 1)(_ + _)
    .maxByOption(_._2)
    .map(_._1)
    .take(topN)
}

case class FileMetaData(
                         name: String = "",
                         size: Int = 0,
                         collection: List[String] = List.empty
                       )

case class MetaDataStats(
                          counter: Counter[FileMetaData] = Counter[FileMetaData](),
                          currentSizeProcessed: Int = 0
                        )

class FileCounter {

  private val metaDataStats = MetaDataStats()

  def addFile(files: List[FileMetaData]) = {
    metaDataStats.copy(currentSizeProcessed = this.metaDataStats.currentSizeProcessed + 1)

  }

}
