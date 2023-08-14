package arrays

object DeleteArrayInRange extends App {

  val input = Array(-8, 3, -5, 1, 51, 56, 0, -5, 29, 43, 78, 75, 32, 76, 73, 76)
  val ranges = Array(Array(5, 8), Array(10, 13), Array(3, 6), Array(20, 25))

  val exclusions = ranges.flatMap { x =>
    input.slice(x(0), x(1))
  }.toArray

  print(input.diff(exclusions).toList)
}
