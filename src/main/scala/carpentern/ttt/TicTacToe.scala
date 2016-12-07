package carpentern.ttt

import carpentern.ttt.boards.Board
import carpentern.ttt.boards.BoardPresenter
import carpentern.ttt.config.{Marker,X,O}
import carpentern.ttt.config.Setup
import carpentern.ttt.game.GameRules
import carpentern.ttt.game.GameRunner
import carpentern.ttt.players.HumanMoveGenerator
import carpentern.ttt.players.ComputerMoveGenerator
import carpentern.ttt.players.Player
import carpentern.ttt.players.TTTPlayerBuilder
import carpentern.ttt.ui.ConsoleIO
import carpentern.ttt.ui.ConsoleView
import carpentern.ttt.validators.MoveValidator

object TicTacToe {

  def main(args: Array[String]) {
    val io: ConsoleIO = new ConsoleIO()
    val moveValidator: MoveValidator = new MoveValidator()
    val presenter: BoardPresenter = new BoardPresenter()
    val view: ConsoleView = new ConsoleView(io, moveValidator, presenter)

    val gameRules: GameRules = new GameRules()
    val game: GameRunner = new GameRunner(gameRules)

    val markers: List[Marker] = List(X, O)
    val humanMoveGenerator: HumanMoveGenerator = new HumanMoveGenerator(view)
    val computerMoveGenerator: ComputerMoveGenerator = new ComputerMoveGenerator(markers, gameRules)
    val playerBuilder: TTTPlayerBuilder = new TTTPlayerBuilder(humanMoveGenerator, computerMoveGenerator)
    val setup: Setup = new Setup(playerBuilder, view)

    val board: Board = setup.setupBoard
    val players: List[Player] = setup.setupPlayers(markers)

    game.playGame(board, players, view)
  }
}
