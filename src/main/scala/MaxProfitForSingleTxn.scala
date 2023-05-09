object MaxProfitForSingleTxn extends App {

  def maxProfit(prices: Array[Int]): Int = {
    var minPrice = Int.MaxValue
    var maxProfit = Int.MinValue
    if (prices == null) 0
    for (i <- prices.indices) {
      minPrice = Math.min(minPrice, prices(i))
      maxProfit = Math.max(maxProfit, prices(i) - minPrice)
    }
    maxProfit
  }
}
