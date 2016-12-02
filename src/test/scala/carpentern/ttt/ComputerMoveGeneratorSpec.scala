import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import org.scalatest.Matchers._
import carpentern.ttt.Board
import carpentern.ttt.GameRules
import carpentern.ttt.ComputerMoveGenerator

class ComputerMoveGeneratorSpec extends FunSpec with BeforeAndAfter {
  val markers = List("X", "O")

  val board = new Board()
  val gameRules = new GameRules()
  var moveGenerator: ComputerMoveGenerator = _

  before {
    moveGenerator = new ComputerMoveGenerator(markers, board, gameRules)
  }

  describe("ComputerMoveGenerator") {
    describe("#selectSpace") {
      it("should return a valid space") {
        val tempBoard = List("", "", "", "", "", "", "", "", "")

        moveGenerator.selectSpace(tempBoard).toInt should (be >= 1 and be <= tempBoard.length)
      }

      it("should force a tie") {
        val tempBoard = List("X", "X", "O", "O", "O", "X", "X", "O", "")

        assert(moveGenerator.selectSpace(tempBoard) == "9")
      }

      it("should block an opponent's win") {
        val tempBoard = List("", "", "", "", "O", "", "", "X", "X")

        assert(moveGenerator.selectSpace(tempBoard) == "7")
      }

      it("should win if possible") {
        val tempBoard = List("X", "X", "", "", "", "", "", "O", "O")

        assert(moveGenerator.selectSpace(tempBoard) == "3")
      }

      it("should win late in the game") {
        val tempBoard = List("X", "O", "X", "O", "O", "X", "", "X", "")

        assert(moveGenerator.selectSpace(tempBoard) == "9")
      }

      it("should block on a second move") {
        val tempBoard = List("X", "", "", "", "O", "", "", "", "X")

        assert(moveGenerator.selectSpace(tempBoard) != "2")
        assert(moveGenerator.selectSpace(tempBoard) != "4")
        assert(moveGenerator.selectSpace(tempBoard) != "6")
        assert(moveGenerator.selectSpace(tempBoard) != "8")
      }

      it("should set up double win scenario if available") {
        val tempBoard = List("O", "O", "X", "X", "", "", "", "", "")

        assert(moveGenerator.selectSpace(tempBoard) == "5")
      }

      it("should set up center fork") {
        val tempBoard = List("X", "X", "O", "", "", "", "", "", "")

        assert(moveGenerator.selectSpace(tempBoard) != "4")
        assert(moveGenerator.selectSpace(tempBoard) != "7")
        assert(moveGenerator.selectSpace(tempBoard) != "8")
        assert(moveGenerator.selectSpace(tempBoard) != "9")
      }
    }
  }
}