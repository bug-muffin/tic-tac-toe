package carpentern.ttt

class HumanMoveGenerator(view: View) extends MoveGenerator {
  def selectSpace(gameBoard:List[String]) : String = {
    view.getPlayerMove(gameBoard)
  }
}