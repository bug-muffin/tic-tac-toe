import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import carpentern.ttt.boards.Board
import carpentern.ttt.players.ComputerMoveGenerator
import carpentern.ttt.players.HumanMoveGenerator
import carpentern.ttt.players.Player
import carpentern.ttt.game.GameRules
import carpentern.ttt.game.GameRunner

class GameRunnerSpec extends FunSpec with BeforeAndAfter {
  val boardSize: Int = 9
  val markers: List[String] = List("X", "O")
  var gameRules: GameRules = _
  var game: GameRunner = _
  var board: Board = _
  var view: MockConsoleView = _
  var mockGenerator: MockMoveGenerator = _
  var computerGenerator: ComputerMoveGenerator = _

  before {
    gameRules = new GameRules()
    game = new GameRunner(gameRules)
    board = Board(boardSize)
    view = new MockConsoleView()
    mockGenerator = new MockMoveGenerator()
    computerGenerator = new ComputerMoveGenerator(markers, gameRules)
  }

  private def mockVComputer() = {
    List(new Player("p1", "X", mockGenerator),
         new Player("p2", "O", computerGenerator))
  }

  private def mockVMock() = {
    List(new Player("p1", "X", mockGenerator),
         new Player("p2", "O", computerGenerator))
  }

  private def lastMoveBoard = List("", "X", "X", "O", "O", "X", "O", "X", "O")

  describe("Game") {
    describe("#playGame") {
      it("should clear the screen") {
        mockGenerator.stubSelectSpace("1")
        val newBoard = board.copy(squares = lastMoveBoard)

        game.playGame(newBoard, mockVMock(), view)

        assert(view.clearScreenCalled)
      }

      it("should display the board positions") {
        mockGenerator.stubSelectSpace("1")
        val newBoard = board.copy(squares = lastMoveBoard)

        game.playGame(newBoard, mockVMock(), view)

        assert(view.printBoardPositionsCalled)
      }

      it("should display the board") {
        mockGenerator.stubSelectSpace("1")
        val newBoard = board.copy(squares = lastMoveBoard)

        game.playGame(newBoard, mockVMock(), view)

        assert(view.printBoardValuesCalled)
      }

      it("should prompt the player for a move") {
        mockGenerator.stubSelectSpace("1")
        val newBoard = board.copy(squares = lastMoveBoard)

        game.playGame(newBoard, mockVMock(), view)

        assert(view.promptPlayerMoveCalled)
        assert(view.promptPlayerMoveCalledWith == "p1")
      }

      it("should return a tie message if there is a tie") {
        val tempBoard = List("X", "X", "O", "O", "O", "X", "X", "", "")
        val newBoard = board.copy(squares = tempBoard)
        mockGenerator.stubSelectSpace("8")

        game.playGame(newBoard, mockVComputer(), view)

        assert(view.displayTieMessageCalled)
      }

      it("should display a winning message with the player's name when the player wins") {
        val tempBoard = List("", "X", "X", "O", "O", "X", "O", "X", "O")
        val newBoard = board.copy(squares = tempBoard)
        mockGenerator.stubSelectSpace("1")

        game.playGame(newBoard, mockVComputer, view)

        assert(view.displayWinningMessageCalled)
        assert(view.displayWinningMessageCalledWith == "p1")
      }
    }
  }
}
