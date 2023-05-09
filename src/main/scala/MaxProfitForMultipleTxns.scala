object MaxProfitForMultipleTxns extends App {

  print(maxProfit(Array(7, 1, 5, 3, 6, 4)))

  def maxProfit(prices: Array[Int]): Int = {
    var profit = 0
    //we start the loop at index 1 since we compare with (i - 1)
    for (i <- 1 until prices.length) {
      val currentDay = prices(i)
      val previousDay = prices(i - 1)
      if (currentDay > previousDay) {
        //only consider cases where prev day (buy) is lower than next day (sell)
        profit += currentDay - previousDay
      }
    }
    profit
  }


}
