import carpentern.ttt.boards.Board
import carpentern.ttt.game.MoveGenerator

class MockMoveGenerator extends MoveGenerator {
  var selectSpaceCalled: Boolean = false
  var stubbedSelectSpace: String = ""

  def selectSpace(gameBoard: Board) : String = {
    selectSpaceCalled = true
    stubbedSelectSpace
  }

  def stubSelectSpace(value: String) = {
    stubbedSelectSpace = value
  }
}