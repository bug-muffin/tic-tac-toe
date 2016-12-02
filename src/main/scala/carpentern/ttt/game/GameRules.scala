package carpentern.ttt.game

import carpentern.ttt.boards.Board

class GameRules() {
  def isTieConditionMet(gameBoard:List[String]) : Boolean = {
    !gameBoard.contains("")
  }

  def isWinningConditionMet(board:Board, gameBoard:List[String]) : Boolean = {
    val winningCombinations = findWinningCombinations(board, gameBoard)
    for (winningCombo <- winningCombinations) {
      if (isWinner(gameBoard, winningCombo)) {
        return true
      }
    }
    return false
  }

  def findWinningMarker(board:Board, gameBoard:List[String]) : String = {
    val winningCombinations = findWinningCombinations(board, gameBoard)
    for (winningCombo <- winningCombinations) {
      if (isWinner(gameBoard, winningCombo)) {
        return identifyWinner(gameBoard, winningCombo)
      }
    }
    return ""
  }

  def isGameOver(board:Board, gameBoard:List[String]) : Boolean = {
    isTieConditionMet(gameBoard) || isWinningConditionMet(board, gameBoard)
  }

  private def findWinningCombinations(board:Board, gameBoard:List[String]) : List[List[Int]] = {
    List(board.findRows(gameBoard), board.findColumns(gameBoard), board.findDiagonals(gameBoard)).flatten
  }

  private def isWinner(gameBoard:List[String], winningCombo:List[Int]) : Boolean = {
    val comboValues = findValuesAtComboPositions(gameBoard, winningCombo)
    isMatchedCombination(comboValues)
  }

  private def identifyWinner(gameBoard:List[String], winningCombo:List[Int]) : String = {
    findValuesAtComboPositions(gameBoard, winningCombo)(0)
  }

  private def findValuesAtComboPositions(gameBoard:List[String], winningCombo:List[Int]) : List[String] = {
    winningCombo map gameBoard
  }

  private def isMatchedCombination(comboValues:List[String]) : Boolean = {
    comboValues.distinct.length == 1 && comboValues(0) != ""
  }
}