package carpentern.ttt.game

import carpentern.ttt.boards.Board

trait MoveGenerator {
  def selectSpace(board: Board): String
}