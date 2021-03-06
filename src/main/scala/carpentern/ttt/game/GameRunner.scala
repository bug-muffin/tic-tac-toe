package carpentern.ttt.game

import carpentern.ttt.boards.Board
import carpentern.ttt.config.Marker
import carpentern.ttt.players.Player

class GameRunner(rules: GameRules) {
  def playGame(board: Board, players: List[Player], view: View) = {
    var currentBoard = board
    while (!rules.isGameOver(currentBoard)) {
      currentBoard = alternatePlayerTurns(currentBoard, players, view)
    }
    displayResults(currentBoard, players, view)
  }

  private def alternatePlayerTurns(board: Board, players: List[Player], view: View): Board = {
    var currentBoard = board
    for (player <- players) {
      currentBoard = playerTurn(currentBoard, player, view)
      if (rules.isGameOver(currentBoard)) {
        return currentBoard
      }
    }
    currentBoard
  }

  private def playerTurn(board: Board, player:Player, view: View): Board = {
    displayCurrentBoard(board, view)
    view.promptPlayerMove(player.name)

    val move: Int = player.moveGenerator.selectSpace(board).toInt
    board.placePiece(move, player.marker)
  }

  private def displayCurrentBoard(board: Board, view: View) {
    view.clearScreen
    view.printBoardPositions(board)
    view.printBoardValues(board)
  }

  private def displayResults(board: Board, players: List[Player], view: View) = {
    if (rules.isWinningConditionMet(board)) {
      val winningMarker: Marker = rules.findWinningMarker(board)
      val winner: String = getWinningPlayer(players, winningMarker)
      displayCurrentBoard(board, view)
      view.displayWinningMessage(winner)
    } else {
      displayCurrentBoard(board, view)
      view.displayTieMessage
    }
  }

  private def getWinningPlayer(players: List[Player], winningMarker: Marker): String =
    players.filter(x => x.marker == winningMarker)(0).name
}