object Palindrome {

  def isArrayPalindrome[T](array: Array[T]): Boolean = {
    //The .view syntax creates a structure that mirrors another structure,
    //until "forced" by an eager operation like .toList, .foreach, .forall, .count.
    array
      .view
      .zip(array.reverse.view)
      .forall({ case (a, b) =>
        a == b
      })
  }

}
