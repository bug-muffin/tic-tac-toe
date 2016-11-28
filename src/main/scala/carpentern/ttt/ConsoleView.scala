package carpentern.ttt

class ConsoleView(io: IO, validator: MoveValidator) extends View {
  def getPlayerMove(board:List[String]) : String = {
    var move = io.getUserInput()
    while (!validator.isValid(board, move)) {
      io.display(s"Invalid move. Select an open space from 1 to ${board.length}")
      move = io.getUserInput()
    }
    move
  }
}