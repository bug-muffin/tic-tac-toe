package carpentern.ttt.game

import carpentern.ttt.boards.Board
import carpentern.ttt.config.{Marker,EMPTY}

class GameRules {
  def isTieConditionMet(board: Board): Boolean = !board.squares.contains(EMPTY)

  def isWinningConditionMet(board: Board): Boolean = {
    val winningCombinations: List[List[Int]] = findWinningCombinations(board)
    for (winningCombo <- winningCombinations) {
      if (isWinner(board, winningCombo)) {
        return true
      }
    }
    false
  }

  def findWinningMarker(board: Board): Marker = {
    val winningCombinations: List[List[Int]] = findWinningCombinations(board)
    for (winningCombo <- winningCombinations) {
      if (isWinner(board, winningCombo)) {
        return identifyWinner(board, winningCombo)
      }
    }
    EMPTY
  }

  def isGameOver(board: Board): Boolean =
    isTieConditionMet(board) || isWinningConditionMet(board)

  private def findWinningCombinations(board: Board): List[List[Int]] =
    List(board.findRows, board.findColumns, board.findDiagonals).flatten

  private def isWinner(board: Board, winningCombo: List[Int]): Boolean = {
    val comboValues: List[Marker] = findValuesAtComboPositions(board, winningCombo)
    isMatchedCombination(comboValues)
  }

  private def identifyWinner(board: Board, winningCombo: List[Int]): Marker =
    findValuesAtComboPositions(board, winningCombo)(0)

  private def findValuesAtComboPositions(board: Board, winningCombo: List[Int]): List[Marker] =
    winningCombo.map(board.squares)

  private def isMatchedCombination(comboValues: List[Marker]): Boolean =
    comboValues.distinct.length == 1 && comboValues(0) != EMPTY
}