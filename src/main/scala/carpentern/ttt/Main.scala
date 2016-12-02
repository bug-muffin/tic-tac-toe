package carpentern.ttt

object Main {

  def main(args: Array[String]) {
    val io: ConsoleIO = new ConsoleIO()
    val moveValidator: MoveValidator = new MoveValidator()
    val presenter: BoardPresenter = new BoardPresenter()
    val view: ConsoleView = new ConsoleView(io, moveValidator, presenter)

    val board: Board = new Board()

    val gameRules: GameRules = new GameRules()
    val game: Game = new Game(gameRules)

    val markers: List[String] = List("X", "O")
    val humanMoveGenerator: HumanMoveGenerator = new HumanMoveGenerator(view)
    val computerMoveGenerator: ComputerMoveGenerator = new ComputerMoveGenerator(markers, board, gameRules)
    val playerBuilder: TTTPlayerBuilder = new TTTPlayerBuilder(humanMoveGenerator, computerMoveGenerator)
    val setup: Setup = new Setup(playerBuilder, board, view)
    
    val gameBoard: List[String] = setup.setupBoard()
    val players: List[Player] = setup.setupPlayers(markers)

    game.playGame(board, gameBoard, players, view)
  }
}