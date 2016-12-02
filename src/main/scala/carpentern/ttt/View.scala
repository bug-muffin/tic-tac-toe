package carpentern.ttt

trait View {
  def promptOrderedOptions(prompt:String, options:List[String])
  def getOrderedOptionsSelection(options:List[String]) : String
  def getPlayerName(order:String) : String
  def promptPlayerMove(playerName:String)
  def getPlayerMove(board:List[String]) : String
  def displayWinningMessage(winner:String)
  def displayTieMessage()
  def printBoard(board:Board, gameBoard:List[String])
  def clearScreen()
}