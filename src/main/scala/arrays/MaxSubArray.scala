package arrays

object MaxSubArray extends App {

  //`M_e`- the maximum sum of subarray ending at position `e`
  //M_e+1 = max(Me,Me + V_e + 1)
  final case class MaximumSum(M_e: Int) {
    def include(`V_{e+1}`: Int): MaximumSum = MaximumSum(
      Math.max(`V_{e+1}`, M_e + `V_{e+1}`)
    )
  }

  object MaximumSum {
    def start: MaximumSum = MaximumSum(M_e = 0)
  }

  def maxSubArray(array: Array[Int]) =
    if (array.length > 1)
      array
        .view
        .scanLeft(MaximumSum.start)(_.include(_)).maxBy(_.M_e).M_e
    else array.head
}
