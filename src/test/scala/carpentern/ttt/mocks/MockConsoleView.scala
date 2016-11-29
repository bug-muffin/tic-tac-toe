import carpentern.ttt.View

class MockConsoleView extends View {
  var promptPlayerMoveCalled: Boolean = false
  var promptPlayerMoveCalledWith: String = ""
  var getPlayerMoveCalled: Boolean = false
  var displayWinningMessageCalled: Boolean = false
  var displayWinningMessageCalledWith: String = ""
  var displayTieMessageCalled: Boolean = false
  var printBoardCalled: Boolean = false
  var printBoardCalledWith: String = ""
  var stubbedPlayerMove: String = ""

  def promptPlayerMove(playerName:String) = {
    promptPlayerMoveCalledWith = playerName
    promptPlayerMoveCalled = true
  }

  def getPlayerMove(board:List[String]) : String = {
    getPlayerMoveCalled = true
    stubbedPlayerMove
  }

  def displayWinningMessage(winner:String) = {
    displayWinningMessageCalledWith = winner
    displayWinningMessageCalled = true
  }

  def displayTieMessage() = {
    displayTieMessageCalled = true
  }

  def printBoard(currentBoard:List[String]) = {
    printBoardCalledWith = currentBoard.toString
    printBoardCalled = true
  }

  def stubPlayerMove(moveToStub:String) = {
    stubbedPlayerMove = moveToStub
  }
}