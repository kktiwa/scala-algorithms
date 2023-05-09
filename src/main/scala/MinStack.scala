object MinStack extends App {

  class MinStack() {
    //To store the actual elements
    private val stack = scala.collection.mutable.Stack[Int]()
    //To store the minimum values encountered
    //The top of the minStack always stores the current minimum value.
    private val minStack = scala.collection.mutable.Stack[Int]()

    //Whenever a new element is pushed onto the stack,
    // if it is smaller than or equal to the current minimum, it is also pushed onto the minStack.
    def push(x: Int): Unit = {
      stack.push(x)
      if (minStack.isEmpty || x <= minStack.top) minStack.push(x)
    }

    //When an element is popped from the stack, if it is the current minimum, it is also popped from the minStack.
    //The top of the minStack always stores the current minimum value.
    def pop(): Unit = {
      if (stack.top == minStack.top) minStack.pop()
      stack.pop()
    }

    def top(): Int = stack.top

    def getMin(): Int = minStack.top
  }

}
