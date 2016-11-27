package carpentern.ttt

class GameRules(board: Board) {
  def isTieConditionMet(gameBoard:List[String]) : Boolean = {
    !gameBoard.contains("")
  }

  def isWinningConditionMet(gameBoard:List[String]) : Boolean = {
    findWinningMarker(gameBoard) != ""
  }

  def isGameOver(gameBoard:List[String]) : Boolean = {
    isTieConditionMet(gameBoard) || isWinningConditionMet(gameBoard)
  }

  private def findWinningMarker(gameBoard:List[String]) : String = {
    val winningCombinations = findWinningCombinations(gameBoard)
    for (winningCombo <- winningCombinations) {
      val winner = identifyWinner(gameBoard, winningCombo)
      if (winner != "") {
        return winner
      }
    }
    return ""
  }

  private def findWinningCombinations(gameBoard:List[String]) : List[List[Int]] = {
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