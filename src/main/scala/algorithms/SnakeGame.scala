package algorithms



sealed trait Direction

case object Left extends Direction

case object Right extends Direction

case object Up extends Direction

case object Down extends Direction

case class Size(width: Int, height: Int)

case class Fruit(block: Block)

case class Snake(direction: Direction, body: List[Block])

case class World(snake: Snake, fruit: Fruit, size: Size)

case class Block(x: Int, y: Int)

object SnakeGame {

  def score(world: World): Int = world.snake.body.length - 1

  def eatsFruit(snake: Snake, fruit: Fruit): Boolean =
    fruit.block == snake.body.head


  def nextTail(snake: Snake, isEating: Boolean): List[Block] =
    if (isEating) snake.body
    else snake.body.dropRight(1)

  def opposite(direction: Direction): Direction =
    direction match {
      case Up => Down
      case Down => Up
      case Left => Right
      case Right => Left
    }

  def nextDirection(currentDirection: Direction, inputDirection: Option[Direction]): Direction =
    inputDirection match {
      case Some(newDirection) =>
        if (newDirection == opposite(currentDirection)) currentDirection
        else newDirection
      case None =>
        currentDirection
    }

  def wrapX(worldSize: Size, x: Int): Int =
    if (x >= worldSize.width) 0
    else if (x < 0) worldSize.width - 1
    else x

  def wrapY(worldSize: Size, y: Int): Int =
    if (y >= worldSize.height) 0
    else if (y < 0) worldSize.height - 1
    else y


  def nextHead(snake: Snake, nextDirection: Direction, worldSize: Size): Block = {
    val head = snake.body.head
    nextDirection match {
      case Up =>
        Block(x = head.x, y = wrapY(worldSize, head.y - 1))
      case Down =>
        Block(x = head.x, y = wrapY(worldSize, head.y + 1))
      case Left =>
        Block(x = wrapX(worldSize, head.x - 1), y = head.y)
      case Right =>
        Block(x = wrapX(worldSize, head.x + 1), y = head.y)
    }
  }

  def bitItself(snake: Snake): Boolean =
    snake.body.tail.contains(snake.body.head)

}
