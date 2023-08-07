package datastructures

object Queue extends App {
  def empty[A]: Queue[A] = new Queue(Nil, Nil)

  val q: Queue[Int] = new Queue[Int](List(1, 2, 4), List(1, 2, 4))
}

class Queue[A] private(in: List[A], out: List[A]) {
  def isEmpty: Boolean = in.isEmpty && out.isEmpty

  def push(elem: A): Queue[A] = new Queue(elem :: in, out)

  def pop(): (A, Queue[A]) =
    out match {
      //pop the last element from the out list
      case head :: tail => (head, new Queue(in, tail))
      case Nil =>
        val head :: tail = in.reverse // throws exception if empty
        (head, new Queue(Nil, tail))
    }
}