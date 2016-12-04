package carpentern.ttt.players

import carpentern.ttt.boards.Board
import carpentern.ttt.game.MoveGenerator
import carpentern.ttt.game.View

class HumanMoveGenerator(view: View) extends MoveGenerator {
  def selectSpace(board: Board): String = view.getPlayerMove(board)
}