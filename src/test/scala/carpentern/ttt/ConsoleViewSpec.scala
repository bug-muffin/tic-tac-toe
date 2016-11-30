import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import carpentern.ttt.MoveValidator
import carpentern.ttt.Board
import carpentern.ttt.BoardPresenter
import carpentern.ttt.ConsoleView

class ConsoleViewSpec extends FunSpec with BeforeAndAfter {
  var mockIO: MockConsoleIO = _
  var validator: MoveValidator = _
  var presenter: BoardPresenter = _
  var view: ConsoleView = _

  before {
    mockIO = new MockConsoleIO()
    validator = new MoveValidator()
    presenter = new BoardPresenter()
    view = new ConsoleView(mockIO, validator, presenter)
  }

  describe("#promptPlayerMove") {
    it("should display a message prompting the player for a move") {
      view.promptPlayerMove("Player 1")
      assert(mockIO.displayCalled == true)
      assert(mockIO.displayCalledWith == "Player 1, please select a space.\n")
    }
  }
  
  describe("#getPlayerMove") {
    it("returns a valid move") {
      val tempBoard = List("", "", "", "", "", "", "", "", "")
      mockIO.stubUserInput("3")
      assert(view.getPlayerMove(tempBoard) == "3")
      assert(mockIO.getUserInputCalled == true)
    }
  }

  describe("#displayWinningMessage") {
    it("should output a winning message with the winner's name") {
      val winner = "Player 1"
      view.displayWinningMessage(winner)
      assert(mockIO.displayCalled == true)
      assert(mockIO.displayCalledWith == "Game over. Player 1 won!\n")
    }
  }

  describe("#displayTieMessage") {
    it("should output a tie message when the game ends in a draw") {
      view.displayTieMessage()
      assert(mockIO.displayCalled == true)
      assert(mockIO.displayCalledWith == "Game over. It's a tie.\n")
    }
  }

  describe("#printBoard") {
    it("should print the board as a string") {
      val board = new Board()
      val tempBoard = List("X", "O", "O", "O", "X", "X", "X", "O", "X")
      view.printBoard(board, tempBoard)
      assert(mockIO.displayCalled == true)
      assert(mockIO.displayCalledWith == " X | O | O\n===+===+===\n O | X | X\n===+===+===\n X | O | X\n\n")
    }
  }
}