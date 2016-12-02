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
    board = new Board()
    view = new MockConsoleView()
    mockGenerator = new MockMoveGenerator()
    computerGenerator = new ComputerMoveGenerator(markers, board, gameRules)
  }

  private def mockVComputer() = {
    List(new Player("p1", "X", mockGenerator),
         new Player("p2", "O", computerGenerator))
  }

  private def mockVMock() = {
    List(new Player("p1", "X", mockGenerator),
         new Player("p2", "O", computerGenerator))
  }

  private def lastMoveBoard() = {
    List("", "X", "X", "O", "O", "X", "O", "X", "O")
  }

  describe("Game") {
    describe("#playGame") {
      it("should clear the screen") {
        mockGenerator.stubSelectSpace("1")

        game.playGame(board, lastMoveBoard(), mockVMock(), view)

        assert(view.clearScreenCalled == true)
      }

      it("should display the board") {
        mockGenerator.stubSelectSpace("1")

        game.playGame(board, lastMoveBoard(), mockVMock(), view)

        assert(view.printBoardCalled == true)      
      }

      it("should prompt the player for a move") {
        mockGenerator.stubSelectSpace("1")

        game.playGame(board, lastMoveBoard(), mockVMock(), view)

        assert(view.promptPlayerMoveCalled == true)  
        assert(view.promptPlayerMoveCalledWith == "p1")
      }

      it("should return a tie message if there is a tie") {
        val gameBoard = List("X", "X", "O", "O", "O", "X", "X", "", "")
        mockGenerator.stubSelectSpace("8")

        game.playGame(board, gameBoard, mockVComputer(), view)

        assert(view.displayTieMessageCalled == true)
      }

      it("should display a winning message with the player's name when the player wins") {
        val gameBoard = List("", "X", "X", "O", "O", "X", "O", "X", "O")
        val computerGenerator = new ComputerMoveGenerator(List("X", "O"), board, gameRules)
        mockGenerator.stubSelectSpace("1")

        game.playGame(board, gameBoard, mockVComputer, view)

        assert(view.displayWinningMessageCalled == true)
        assert(view.displayWinningMessageCalledWith == "p1")
      }
    }
  }
}