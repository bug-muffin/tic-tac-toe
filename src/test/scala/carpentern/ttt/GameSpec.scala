import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import carpentern.ttt.Board
import carpentern.ttt.ComputerMoveGenerator
import carpentern.ttt.HumanMoveGenerator
import carpentern.ttt.MoveValidator
import carpentern.ttt.Player
import carpentern.ttt.View
import carpentern.ttt.GameRules
import carpentern.ttt.Game

class GameSpec extends FunSpec with BeforeAndAfter {
  val boardSize: Int = 9
  var gameRules: GameRules = _
  var game: Game = _
  var board: Board = _
  var view: MockConsoleView = _
  var validator: MoveValidator = _
  var mockGenerator: MockMoveGenerator = _
  var computerGenerator: ComputerMoveGenerator = _

  before {
    gameRules = new GameRules()
    game = new Game(gameRules)
    board = new Board()
    view = new MockConsoleView()
    validator = new MoveValidator()
    mockGenerator = new MockMoveGenerator()
    computerGenerator = new ComputerMoveGenerator(validator)
  }

  describe("#playGame") {

    it("should return a tie message if there is a tie") {
      val gameBoard = List("X", "X", "O", "O", "O", "X", "X", "", "")
      mockGenerator.stubSelectSpace("8")
      val players = List(new Player("p1", "X", mockGenerator),
                         new Player("p2", "O", computerGenerator))
      game.playGame(board, gameBoard, players, view)
      assert(view.printBoardCalled == true)
      assert(view.promptPlayerMoveCalled == true)
      assert(view.displayTieMessageCalled == true)
    }

    it("should display a winning message with the player's name when the player wins") {
      val gameBoard = List("", "X", "X", "O", "O", "X", "O", "X", "O")
      val mockGenerator = new MockMoveGenerator()
      val computerGenerator = new ComputerMoveGenerator(validator)
      mockGenerator.stubSelectSpace("1")
      val players = List(new Player("p1", "X", mockGenerator),
                         new Player("p2", "O", computerGenerator))
      game.playGame(board, gameBoard, players, view)
      assert(view.printBoardCalled == true)
      assert(view.promptPlayerMoveCalled == true)
      assert(view.promptPlayerMoveCalledWith == "p1")
      assert(view.displayWinningMessageCalled == true)
      assert(view.displayWinningMessageCalledWith == "p1")
    }
  }
}