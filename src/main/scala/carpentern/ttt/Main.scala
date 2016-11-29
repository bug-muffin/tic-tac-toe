package carpentern.ttt

object Main {

  def main(args: Array[String]) {
    val io = new ConsoleIO()
    val validator = new MoveValidator()
    val view = new ConsoleView(io, validator)

    val board = new Board()
    val boardSize = 9
    val gameBoard = board.createGameBoard(boardSize)

    val playerBuilder = new TTTPlayerBuilder()
    val humanMoveGenerator = new HumanMoveGenerator(view)
    val computerMoveGenerator = new ComputerMoveGenerator(validator)
    val setup = new Setup(playerBuilder)
    val players = List(setup.createPlayer("Player 1", "X", humanMoveGenerator),
                       setup.createPlayer("Computer", "O", computerMoveGenerator))

    val gameRules = new GameRules()
    val game = new Game(gameRules)

    game.playGame(board, gameBoard, players, view)
  }
}