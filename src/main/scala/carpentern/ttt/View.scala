package carpentern.ttt

trait View {
  def promptPlayerMove(playerName:String)
  def getPlayerMove(board:List[String]) : String
  def displayWinningMessage(winner:String)
  def displayTieMessage()
  def printBoard(gameBoard:List[String])
}