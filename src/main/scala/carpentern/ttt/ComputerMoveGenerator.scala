package carpentern.ttt

class ComputerMoveGenerator extends MoveGenerator {
  def selectSpace(board:List[String]) : String = {
    val randomMove = scala.util.Random
    randomMove.nextInt(board.length).toString
  }
}