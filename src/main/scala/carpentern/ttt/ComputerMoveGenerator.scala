package carpentern.ttt

class ComputerMoveGenerator(validator: MoveValidator) extends MoveGenerator {
  def selectSpace(board:List[String]) : String = {
    var move = getRandomMove(board)
    while (!validator.isValid(board, move)) {
      move = getRandomMove(board)
    }
    move
  }

  private def getRandomMove(board:List[String]) : String = {
    val rand = scala.util.Random
    (rand.nextInt(board.length) + 1).toString
  }
}