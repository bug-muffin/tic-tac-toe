import carpentern.ttt.boards.Board
import carpentern.ttt.game.View

class MockConsoleView extends View {
  var promptOrderedOptionsCalled: Boolean = false
  var getOrderedOptionsSelectionCalled: Boolean = false
  var getPlayerNameCalled: Boolean = false
  var getPlayerNameCalledWith: String = _
  var promptPlayerMoveCalled: Boolean = false
  var promptPlayerMoveCalledWith: String = _
  var getPlayerMoveCalled: Boolean = false
  var displayWinningMessageCalled: Boolean = false
  var displayWinningMessageCalledWith: String = _
  var displayTieMessageCalled: Boolean = false
  var printBoardPositionsCalled: Boolean = false
  var printBoardValuesCalled: Boolean = false
  var clearScreenCalled: Boolean = false
  var stubbedSelection: String = _
  var stubbedPlayerName: String = _
  var stubbedPlayerMove: String = _

  def promptOrderedOptions(prompt: String, options: List[String]) = {
    promptOrderedOptionsCalled = true
  }

  def getOrderedOptionsSelection(options: List[String]): String = {
    getOrderedOptionsSelectionCalled = true
    stubbedSelection
  }

  def getPlayerName(order: String): String = {
    getPlayerNameCalledWith = order
    getPlayerNameCalled = true
    stubbedPlayerName
  }

  def promptPlayerMove(playerName: String) = {
    promptPlayerMoveCalledWith = playerName
    promptPlayerMoveCalled = true
  }

  def getPlayerMove(board: Board): String = {
    getPlayerMoveCalled = true
    stubbedPlayerMove
  }

  def displayWinningMessage(winner: String) = {
    displayWinningMessageCalledWith = winner
    displayWinningMessageCalled = true
  }

  def displayTieMessage() = {
    displayTieMessageCalled = true
  }

  def printBoardPositions(board:Board) = {
    printBoardPositionsCalled = true
  }

  def printBoardValues(board:Board) = {
    printBoardValuesCalled = true
  }

  def clearScreen() = {
    clearScreenCalled = true
  }

  def stubSelection(selectionToStub: String) = {
    stubbedSelection = selectionToStub
  }

  def stubPlayerName(nameToStub: String) = {
    stubbedPlayerName = nameToStub
  }

  def stubPlayerMove(moveToStub: String) = {
    stubbedPlayerMove = moveToStub
  }
}