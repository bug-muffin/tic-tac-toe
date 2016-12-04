import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import org.scalatest.Matchers._
import carpentern.ttt.boards.Board
import carpentern.ttt.game.GameRules
import carpentern.ttt.players.ComputerMoveGenerator

class ComputerMoveGeneratorSpec extends FunSpec with BeforeAndAfter {
  val markers = List("X", "O")

  val board = Board(9)
  val gameRules = new GameRules()
  var moveGenerator: ComputerMoveGenerator = _

  before {
    moveGenerator = new ComputerMoveGenerator(markers, gameRules)
  }

  describe("ComputerMoveGenerator") {
    describe("#selectSpace") {
      it("should return a valid space") {
        moveGenerator.selectSpace(board).toInt should (be >= 1 and be <= board.boardSize)
      }

      it("should force a tie") {
        val newSquares = List("X", "X", "O", "O", "O", "X", "X", "O", "")
        val newBoard = board.copy(squares = newSquares)

        assert(moveGenerator.selectSpace(newBoard) == "9")
      }

      it("should block an opponent's win") {
        val newSquares = List("", "", "", "", "O", "", "", "X", "X")
        val newBoard = board.copy(squares = newSquares)

        assert(moveGenerator.selectSpace(newBoard) == "7")
      }

      it("should win if possible") {
        val newSquares = List("X", "X", "", "", "", "", "", "O", "O")
        val newBoard = board.copy(squares = newSquares)

        assert(moveGenerator.selectSpace(newBoard) == "3")
      }

      it("should win late in the game") {
        val newSquares = List("X", "O", "X", "O", "O", "X", "", "X", "")
        val newBoard = board.copy(squares = newSquares)

        assert(moveGenerator.selectSpace(newBoard) == "9")
      }

      it("should block on a second move") {
        val newSquares = List("X", "", "", "", "O", "", "", "", "X")
        val newBoard = board.copy(squares = newSquares)

        assert(moveGenerator.selectSpace(newBoard) != "2")
        assert(moveGenerator.selectSpace(newBoard) != "4")
        assert(moveGenerator.selectSpace(newBoard) != "6")
        assert(moveGenerator.selectSpace(newBoard) != "8")
      }

      it("should set up double win scenario if available") {
        val newSquares = List("O", "O", "X", "X", "", "", "", "", "")
        val newBoard = board.copy(squares = newSquares)

        assert(moveGenerator.selectSpace(newBoard) == "5")
      }

      it("should set up center fork") {
        val newSquares = List("X", "X", "O", "", "", "", "", "", "")
        val newBoard = board.copy(squares = newSquares)

        assert(moveGenerator.selectSpace(newBoard) != "4")
        assert(moveGenerator.selectSpace(newBoard) != "7")
        assert(moveGenerator.selectSpace(newBoard) != "8")
        assert(moveGenerator.selectSpace(newBoard) != "9")
      }
    }
  }
}