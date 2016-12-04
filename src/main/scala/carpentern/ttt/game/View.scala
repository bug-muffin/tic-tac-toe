package carpentern.ttt.game

import carpentern.ttt.boards.Board

trait View {
  def promptOrderedOptions(prompt: String, options: List[String])
  def getOrderedOptionsSelection(options: List[String]): String
  def getPlayerName(order: String): String
  def promptPlayerMove(playerName: String)
  def getPlayerMove(board: Board): String
  def displayWinningMessage(winner: String)
  def displayTieMessage
  def printBoard(board: Board, gameBoard: List[String])
  def clearScreen
}