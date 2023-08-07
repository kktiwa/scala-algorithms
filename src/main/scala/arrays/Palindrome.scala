package arrays

object Palindrome {

  def isArrayPalindrome[T](array: Array[T]): Boolean = {
    //The .view syntax creates a structure that mirrors another structure,
    //until "forced" by an eager operation like .toList, .foreach, .forall, .count.
    //Using .view before the map/filter/slice transformation operations defers the actual traversal
    //and creation of a new collection until later, when we call .to to convert it back into a
    //concrete collection type
    //This allows us to perform this chain of map/filter/slice transformations with only a single traversal, and only creating a single output collection.
    //This reduces the amount of unnecessary processing and memory allocations.
    array
      .view
      .zip(array.reverse.view)
      .forall({ case (a, b) =>
        a == b
      })
  }

}
