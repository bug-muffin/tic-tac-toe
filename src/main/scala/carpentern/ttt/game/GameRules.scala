package carpentern.ttt.game

import carpentern.ttt.boards.Board

class GameRules {
  def isTieConditionMet(board: Board): Boolean = !board.squares.contains("")

  def isWinningConditionMet(board: Board): Boolean = {
    val winningCombinations: List[List[Int]] = findWinningCombinations(board)
    for (winningCombo <- winningCombinations) {
      if (isWinner(board, winningCombo)) {
        return true
      }
    }
    false
  }

  def findWinningMarker(board: Board): String = {
    val winningCombinations: List[List[Int]] = findWinningCombinations(board)
    for (winningCombo <- winningCombinations) {
      if (isWinner(board, winningCombo)) {
        return identifyWinner(board, winningCombo)
      }
    }
    ""
  }

  def isGameOver(board: Board): Boolean =
    isTieConditionMet(board) || isWinningConditionMet(board)

  private def findWinningCombinations(board: Board): List[List[Int]] =
    List(board.findRows, board.findColumns, board.findDiagonals).flatten

  private def isWinner(board: Board, winningCombo: List[Int]): Boolean = {
    val comboValues: List[String] = findValuesAtComboPositions(board, winningCombo)
    isMatchedCombination(comboValues)
  }

  private def identifyWinner(board: Board, winningCombo: List[Int]): String =
    findValuesAtComboPositions(board, winningCombo)(0)

  private def findValuesAtComboPositions(board: Board, winningCombo: List[Int]): List[String] =
    winningCombo.map(board.squares)

  private def isMatchedCombination(comboValues: List[String]): Boolean =
    comboValues.distinct.length == 1 && comboValues(0) != ""
}