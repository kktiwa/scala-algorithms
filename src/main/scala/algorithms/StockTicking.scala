package algorithms

import scala.collection.immutable.{HashMap, TreeSet}
import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
 * Implement the following two functions such that they are optimal.
 * `addStocksVolume`` receives a symbol (INTC, APPL, etc) plus a volume that you cumulate over time.
 * `topKstocks` would return the k stocks with the highest volume.
 */

case class StockTickTrade(ticker: String, volume: Int)

object StockTicking extends App {

  def stockTickVolume(stockTickTrade: StockTickTrade) = stockTickTrade.volume

  val stockTickTradeItems = mutable.PriorityQueue[StockTickTrade]()(Ordering.by(stockTickVolume))

  def executeTrade(stockSymbol: String, volume: Int) = {
    stockTickTradeItems.enqueue(StockTickTrade(stockSymbol, volume))
  }

  def topKStocks(k: Int): mutable.Seq[String] = {
    val topKTickers = ListBuffer[String]()
    val topTickersRange = 1 to k
    for (_ <- topTickersRange) {
      topKTickers.addOne(stockTickTradeItems.dequeue().ticker)
    }
    topKTickers
  }


  StockTicking.executeTrade("apl", 600);
  StockTicking.executeTrade("amz", 500);
  StockTicking.executeTrade("ntfl", 1000);
  StockTicking.executeTrade("apl", 500);
  StockTicking.executeTrade("meta", 200);
  //topKStocks.executeTrade("meta", 1000);
  StockTicking.executeTrade("blm", 800);
  //stockTickTradeItems.foreach(println)
  //ListBuffer(ntfl, blm, apl)
  println(StockTicking.topKStocks(3))
}

//public class TopKStocks {
//  Map<String, Integer> map = new HashMap<>();
//  TreeSet<String> sorted = new TreeSet<>((a,b) -> map.get(b)-map.get(a));
//
//  void executeTrade(String ticker, Integer volume) {
//    if (map.containsKey(ticker)) {
//      int preVolume = map.get(ticker);
//      sorted.remove(ticker);
//      map.replace(ticker, preVolume+volume);
//      sorted.add(ticker);
//    } else {
//      map.put(ticker, volume);
//      sorted.add(ticker);
//    }
//  }
//
//  List<String> topKStocks(int k) {
//    List<String> res = new ArrayList<>();
//    Iterator<String> it = sorted.iterator();
//    int count = Math.min(sorted.size(), k);
//    while (count-->0) {
//      String val = it.next();
//      res.add(val);
//    }
//    return res;
//  }
//
//  public static void main(String[] args) {
//    TopKStocks topKStocks = new TopKStocks();
//    topKStocks.executeTrade("apl", 600);
//    topKStocks.executeTrade("amz", 500);
//    topKStocks.executeTrade("ntfl", 1000);
//    topKStocks.executeTrade("apl", 500);
//    topKStocks.executeTrade("meta", 200);
//    //topKStocks.executeTrade("meta", 1000);
//    topKStocks.executeTrade("blm", 800);
//
//    List<String> res = topKStocks.topKStocks(3);
//    System.out.println(res.toString());
//  }
//
//}
