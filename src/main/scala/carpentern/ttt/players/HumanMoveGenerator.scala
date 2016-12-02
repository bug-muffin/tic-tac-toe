package carpentern.ttt.players

import carpentern.ttt.game.MoveGenerator
import carpentern.ttt.game.View

class HumanMoveGenerator(view: View) extends MoveGenerator {
  def selectSpace(gameBoard:List[String]) : String = {
    view.getPlayerMove(gameBoard)
  }
}