package carpentern.ttt.ui

import carpentern.ttt.boards.Board
import carpentern.ttt.boards.BoardPresenter
import carpentern.ttt.game.IO
import carpentern.ttt.game.View
import carpentern.ttt.validators.MoveValidator

class ConsoleView(io: IO, moveValidator: MoveValidator, presenter: BoardPresenter) extends View {
  def promptOrderedOptions(prompt:String, options:List[String]) = {
    io.display(prompt)
    for (option <- options) {
      io.display(option)
    }
  }

  def getOrderedOptionsSelection(options:List[String]): String = {
    var input = io.getUserInput()
    while (!moveValidator.isValidNumber(input, options)) {
      io.display("Invalid selection")
      io.display(s"Select a numbered option from 1 to ${options.length}: ")
      input = io.getUserInput()
    }
    input
  }

  def getPlayerName(order:String) : String = {
    io.display(s"\n$order player, what is your name?: ")
    io.getUserInput()
  }

  def promptPlayerMove(playerName:String) = {
    io.display(s"$playerName, please select a space.\n")
  }

  def getPlayerMove(board:List[String]) : String = {
    var move = io.getUserInput()
    while (!moveValidator.isValid(board, move)) {
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