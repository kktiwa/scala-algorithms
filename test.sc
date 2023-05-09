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

//Priority Queue example in Scala

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

val foo = Array(1,2,3,4,5,6,7)
foo(2)

//myfnc: ()Unit
foo.foreach(x => println(x))
foo.foreach(println _)

val c = Map(1 -> "A")

c get 3