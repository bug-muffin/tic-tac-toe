package carpentern.ttt

class ConsoleView(io: IO, validator: MoveValidator) extends View {
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
    io.display(s"Game over. ${winner} won!")
  }

  def displayTieMessage() {
    io.display("Game over. It's a tie.")
  }


  def printBoard(currentBoard:List[String]) = {
    io.display(currentBoard.toString)
  }
}