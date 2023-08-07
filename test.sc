val x = Array("flower", "flow", "flight")

(x.min, x.max)
  .zipped
  .takeWhile(v => v._1 == v._2)
  .unzip._2
  .mkString


var solutionSet: Set[List[Int]] = Set.empty
solutionSet.toList

val builder = new StringBuilder()
builder.append("")

//Priority datastructures.Queue example in Scala

import scala.collection.mutable.PriorityQueue
import scala.math.Ordering.Implicits._

case class Donut(name: String, price: Double)

//By highest price first
def donutOrder(d: Donut) = d.price

//By lowest price first
def donutOrder(d: Donut) = -d.price

val pq1 = PriorityQueue.empty[Donut](Ordering.by(donutOrder))
val pq = PriorityQueue(
  Donut("Plain Donut", 1.50),
  Donut("Strawberry Donut", 2.0),
  Donut("Chocolate Donut", 2.50))(Ordering.by(donutOrder))

pq.enqueue(Donut("Cinnamon Donut", 3.0))
pq.dequeue()

val result = 2 % 2

import scala.annotation.tailrec

def factorial(n: Int): Int = {
  @tailrec
  def iter(x: Int, result: Int): Int =
    if (x == 1) result
    else iter(x - 1, result * x)

  iter(n, 1)
}

factorial(6)

var res = 1
res ^= 4


val list = List(1, 2, 3)
list.appended(4)
list

val num = 1234

//val arr = Array(String)(5)

val a = "baz"

s"Foo $a?"

"Foo" + a + "?"
//println("Foo" _ a _ "?")

val foo = Array(1, 2, 3, 4, 5, 6, 7)
foo(2)

//myfnc: ()Unit
foo.foreach(x => println(x))
foo.foreach(println _)

val c = Map(1 -> "A")

c get 3

assert(List(1, 2, 3, 4, 5).scanLeft(0)(_ + _) == List(0, 1, 3, 6, 10, 15))

assert(List(1, 2, 3, 4, 5).scanRight(0)(_ + _) == List(15, 14, 12, 9, 5, 0))

"ACB".sorted

val factor = Math.pow(10, 4)
val fin = (Math.round(factor * result) / factor)
fin

import scala.collection.IndexedSeqView

def filterByPredicates[A](xs: IndexedSeqView[A], predicates: List[A => Boolean]): List[List[A]] = {
  xs.foldLeft(List.fill(predicates.size)(List.empty[A]))((acc, element) => {
    acc.zip(predicates).map({
      case (list, predicate) => if (predicate(element)) element :: list else list
    })
  })
}

val xs0 = Array(1, 0, -1, 2, 3, 4, 5, -6, 5, 0)

val xs = xs0.view.map(x => {
  println(s"accessing $x")
  x
})

val xs1 = xs0.map(x => {
  println(s"accessing $x")
  x
})
//val x = Array(1,2,3)
val positives: Int => Boolean = _ > 0
val negatives: Int => Boolean = _ < 0
val zeros: Int => Boolean = _ == 0
val preds = List(positives, negatives, zeros)
//val res = preds.map(xs.filter)
//println(res)
println("---------------")
val elementSizes = filterByPredicates(xs0.view, preds).map(_.size)
val proportions = elementSizes.map(_.toDouble / xs0.size.toDouble)
proportions.foreach(res => println(f"$res%1.5f"))


val arr = Array(1, 2, 3)
arr(2) = 100
arr

val a = List(1, 2, 3, 4)
a.updated(2, 10)
a.head
a.tail