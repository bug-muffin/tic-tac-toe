package carpentern.ttt

class GameRules() {
  def isTieConditionMet(gameBoard:List[String]) : Boolean = {
    !gameBoard.contains("")
  }

  def isWinningConditionMet(board:Board, gameBoard:List[String]) : Boolean = {
    findWinningMarker(board, gameBoard) != ""
  }

  def findWinningMarker(board:Board, gameBoard:List[String]) : String = {
    val winningCombinations = findWinningCombinations(board, gameBoard)
    for (winningCombo <- winningCombinations) {
      val winner = identifyWinner(gameBoard, winningCombo)
      if (winner != "") {
        return winner
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

  private def identifyWinner(gameBoard:List[String], winningCombo:List[Int]) : String = {
    val comboValues = findValuesAtComboPositions(gameBoard, winningCombo)
    if (isMatchedCombination(comboValues)) {
      return comboValues(0)
    } else {
      return ""
    }
  }

  private def findValuesAtComboPositions(gameBoard:List[String], winningCombo:List[Int]) : List[String] = {
    winningCombo map gameBoard
  }

  private def isMatchedCombination(comboValues:List[String]) : Boolean = {
    comboValues.distinct.length == 1
  }
}