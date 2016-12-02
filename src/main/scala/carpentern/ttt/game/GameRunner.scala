package carpentern.ttt.game

import carpentern.ttt.boards.Board
import carpentern.ttt.players.Player

class GameRunner(rules: GameRules) {
  private var boardPositions: List[String] = _

  def playGame(board: Board, gameBoard: List[String], players: List[Player], view: View) = {
    var currentBoard: List[String] = gameBoard
    boardPositions = board.printableBoardPositions(board.boardPositions(gameBoard))
    while (!rules.isGameOver(board, currentBoard)) {
      currentBoard = alternatePlayerTurns(board, currentBoard, players, view)
    }
    displayResults(board, currentBoard, players, view)
  }

  private def alternatePlayerTurns(board: Board, gameBoard: List[String], players: List[Player], view: View): List[String] = {
    var currentBoard: List[String] = gameBoard
    for (player <- players) {
      currentBoard = playerTurn(board, currentBoard, player, view)
      if (rules.isGameOver(board, currentBoard)) {
        return currentBoard
      }
    }
    currentBoard
  }

  private def playerTurn(board: Board, gameBoard: List[String], player:Player, view: View): List[String] = {
    displayCurrentBoard(board, gameBoard, view)
    view.promptPlayerMove(player.name)

    val move: Int = player.moveGenerator.selectSpace(gameBoard).toInt
    board.placePiece(gameBoard, move, player.marker)
  }

  private def displayCurrentBoard(board: Board, gameBoard: List[String], view: View) {
    view.clearScreen
    view.printBoard(board, boardPositions)
    view.printBoard(board, gameBoard)
  }

  private def displayResults(board: Board, gameBoard: List[String], players: List[Player], view: View) = {
    if (rules.isWinningConditionMet(board, gameBoard)) {
      val winningMarker: String = rules.findWinningMarker(board, gameBoard)
      val winner: String = getWinningPlayer(players, winningMarker)
      displayCurrentBoard(board, gameBoard, view)
      view.displayWinningMessage(winner)
    } else {
      displayCurrentBoard(board, gameBoard, view)
      view.displayTieMessage
    }
  }

  private def getWinningPlayer(players: List[Player], winningMarker: String): String =
    players.filter(x => x.marker == winningMarker)(0).name
}