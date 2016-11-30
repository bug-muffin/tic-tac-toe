package carpentern.ttt

class Game(rules: GameRules) {
  def playGame(board:Board, gameBoard:List[String], players:List[Player], view:View) = {
    var currentBoard = gameBoard
    while (!rules.isGameOver(board, currentBoard)) {
      currentBoard = alternatePlayerTurns(board, currentBoard, players, view)
    }
    displayResults(board, currentBoard, players, view)
  }

  private def alternatePlayerTurns(board:Board, gameBoard:List[String], players:List[Player], view:View) : List[String] = {
    var currentBoard = gameBoard
    for (player <- players) {
      currentBoard = playerTurn(board, currentBoard, player, view)
      if (rules.isGameOver(board, currentBoard)) return currentBoard
    }
    currentBoard
  }

  private def playerTurn(board:Board, gameBoard:List[String], player:Player, view:View) : List[String] = {
    val boardPositions = board.printableBoardPositions(board.boardPositions(gameBoard))
    view.printBoard(board, boardPositions)
    view.printBoard(board, gameBoard)
    view.promptPlayerMove(player.name)

    val move = player.moveGenerator.selectSpace(gameBoard).toInt
    board.placePiece(gameBoard, move, player.marker)
  }

  private def displayResults(board:Board, gameBoard:List[String], players:List[Player], view:View) = {
    view.printBoard(board, gameBoard)
    if (rules.isWinningConditionMet(board, gameBoard)) {
      val winningMarker = rules.findWinningMarker(board, gameBoard)
      val winner = getWinningPlayer(players, winningMarker)
      view.displayWinningMessage(winner)
    } else {
      view.displayTieMessage()
    }
  }

  private def getWinningPlayer(players:List[Player], winningMarker:String) : String = {
    players.filter(x => x.marker == winningMarker)(0).name
  }
}