package carpentern.ttt

class ConsoleView(io: IO, validator: MoveValidator, presenter: BoardPresenter) extends View {
  def promptPlayerMove(playerName:String) = {
    io.display(s"$playerName, please select a space.\n")
  }

  def getPlayerMove(board:List[String]) : String = {
    var move = io.getUserInput()
    while (!validator.isValid(board, move)) {
      io.display(s"Invalid move. Select an open space from 1 to ${board.length}\n")
      move = io.getUserInput()
    }
    move
  }

  def displayWinningMessage(winner:String) {
    io.display(s"Game over. ${winner} won!\n")
  }

  def displayTieMessage() {
    io.display("Game over. It's a tie.\n")
  }

  def printBoard(board:Board, currentBoard:List[String]) = {
    io.display(presenter.formatBoardToString(board, currentBoard) + "\n")
  }

  def clearScreen() = {
    io.clear()
  }
}