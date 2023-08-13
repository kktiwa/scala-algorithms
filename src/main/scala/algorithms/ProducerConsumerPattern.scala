package algorithms

import java.util.concurrent.{BlockingQueue, Executors, LinkedBlockingQueue}

/**
 * 1. Producer and Consumer work independently and concurrently, they just need to know shared object
 * 2. Producer doesn't need to know about who is consumer or how many consumers are there. Same is true with Consumer.
 * 3. Producer and Consumer can work with different speed. There is no risk of Consumer consuming half-baked item.
 * 4. Separating producer and Consumer functionality result in more clean, readable and manageable code.
 * Design with `backpressure` and `flow control`
 *
 * @param queue
 */
class Producer(queue: BlockingQueue[String]) extends Runnable {
  val itemPrefix = "Item"

  //Backpressure: Rate of production > Rate of consumption
  def run() = {
    for (i <- 1 to ProducerConsumerPattern.QUEUE_CAPACITY) {
      try {
        //will block if Queue is full in case of Bounded Queue
        val item = s"$itemPrefix# $i"
        println(s"Produced $item")
        //offer as an alternative with timeout and returns Boolean
        queue.put(s"$item")
      } catch {
        case e: InterruptedException => print(e.printStackTrace())
      }
    }
  }
}

class Consumer(queue: BlockingQueue[String]) extends Runnable {
  def run = {
    while (true) {
      try {
        //will block if Queue is empty
        //poll as an alternative with timeout
        val item = queue.take()
        consume(item)
      }
    }
  }

  def consume(item: String) = {
    println(s"Consumed $item by: ${Thread.currentThread().getName}")
  }
}

object ProducerConsumerPattern extends App {

  /**
   * The most important thing when designing a producer-consumer program using unbounded BlockingQueue is
   * that consumers should be able to consume messages as quickly as producers are adding messages to the queue.
   * Otherwise, the memory could fill up and we would get an OutOfMemory exception.
   */

  /**
   * Using bounded queue is a good way to design concurrent programs because when we insert an element to an
   * already full queue, that operations need to wait until consumers catch up and make some space available in the queue.
   * It gives us throttling without any effort on our part.
   */

  val QUEUE_CAPACITY = 20
  //ArrayLinkedQueue is bounded in nature LinkedBlockingQueue is optionally bounded.
  //LinkedBlockingDeque
  val queue = new LinkedBlockingQueue[String](QUEUE_CAPACITY)
  //One thread for the producer
  val producer = new Producer(queue)
  new Thread(producer).start()

  //We want to consume with a faster rate than consumption
  val threads = 3
  val pool = Executors.newFixedThreadPool(threads)

  for (i <- 1 to threads) {
    pool.submit(new Consumer(queue))
  }
}
