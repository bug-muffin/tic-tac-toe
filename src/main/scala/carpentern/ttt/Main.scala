package carpentern.ttt

object Main {

  def main(args: Array[String]) {
    val io: ConsoleIO = new ConsoleIO()
    val validator: MoveValidator = new MoveValidator()
    val presenter: BoardPresenter = new BoardPresenter()
    val view: ConsoleView = new ConsoleView(io, validator, presenter)

    val board: Board = new Board()
    val boardSize: Int = 9
    val gameBoard: List[String] = board.createGameBoard(boardSize)

    val gameRules: GameRules = new GameRules()
    val playerBuilder: TTTPlayerBuilder = new TTTPlayerBuilder()
    val markers: List[String] = List("X", "O")
    val humanMoveGenerator: HumanMoveGenerator = new HumanMoveGenerator(view)
    val computerMoveGenerator: ComputerMoveGenerator = new ComputerMoveGenerator(markers, board, gameRules)
    val setup: Setup = new Setup(playerBuilder)
    val players: List[Player] = List(setup.createPlayer("Player 1", markers(0), humanMoveGenerator),
                                    setup.createPlayer("Computer", markers(1), computerMoveGenerator))

    val game: Game = new Game(gameRules)

    game.playGame(board, gameBoard, players, view)
  }
}