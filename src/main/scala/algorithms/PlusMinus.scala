package algorithms

import scala.collection.IndexedSeqView

object PlusMinus extends App {

  plusMinus(Array(-4, 3, -9, 0, 4, 1))

  /*
   * Complete the 'plusMinus' function below.
   *
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  def plusMinus(arr: Array[Int]) {
    // Write your code here
    val inputLength = arr.length.toDouble
    val positives: Int => Boolean = _ > 0
    val negatives: Int => Boolean = _ < 0
    val zeros: Int => Boolean = _ == 0
    val predicates = List(positives, negatives, zeros)

    val elementSizes = filterByPredicates(arr.view, predicates).map(_.size)
    val proportions = elementSizes.map(_.toDouble / inputLength)
    proportions.foreach(res => println(f"$res%1.5f"))
  }

  private def filterByPredicates[A](xs: IndexedSeqView[A], predicates: List[A => Boolean]): List[List[A]] = {
    xs.foldLeft(List.fill(predicates.size)(List.empty[A]))((acc, element) => {
      acc.zip(predicates).map({
        case (list, predicate) => if (predicate(element)) element :: list else list
      })
    })
  }
}