package carpentern.ttt

class ConsoleView(io: IO) extends View {
  def getPlayerMove(board:List[String]) : String = {
    io.getUserInput()
  }
}