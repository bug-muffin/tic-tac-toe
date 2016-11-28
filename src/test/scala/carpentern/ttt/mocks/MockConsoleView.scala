import carpentern.ttt.View

class MockConsoleView extends View {
  var getPlayerMoveCalled: Boolean = false
  var stubbedPlayerMove: String = ""

  def getPlayerMove(board:List[String]) : String = {
    getPlayerMoveCalled = true
    stubbedPlayerMove
  }

  def stubPlayerMove(moveToStub:String) = {
    stubbedPlayerMove = moveToStub
  }
}