import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import carpentern.ttt.boards.Board
import carpentern.ttt.boards.BoardPresenter

class BoardPresenterSpec extends FunSpec with BeforeAndAfter {
  var board: Board = _
  var presenter: BoardPresenter = _

  before {
    board = new Board()
    presenter = new BoardPresenter()
  }

  describe("BoardPresenter") {
    describe("#formatBoardToString") {
      describe("3x3 board") {
        it("should correctly format a board with markers") {
          val tempBoard = List.fill(9)("X")
          val expectedResult = " X | X | X\n" +
                               "===+===+===\n" +
                               " X | X | X\n" + 
                               "===+===+===\n" +
                               " X | X | X\n"

          assert(presenter.formatBoardToString(board, tempBoard) == expectedResult)
        }

        it("should correctly format an empty board") {
          val tempBoard = List.fill(9)("")
          val expectedResult = "   |   |  \n" +
                               "===+===+===\n" +
                               "   |   |  \n" + 
                               "===+===+===\n" +
                               "   |   |  \n"

          assert(presenter.formatBoardToString(board, tempBoard) == expectedResult)
        }

        it("should correctly format a board with board positions") {
          val tempBoard = List("1", "2", "3", "4", "5", "6", "7", "8", "9")
          val expectedResult = " 1 | 2 | 3\n" +
                               "===+===+===\n" +
                               " 4 | 5 | 6\n" + 
                               "===+===+===\n" +
                               " 7 | 8 | 9\n"

          assert(presenter.formatBoardToString(board, tempBoard) == expectedResult)
        }
      }

      describe("4x4 board") {
        it("should correctly format a board with markers") {
          val tempBoard = List.fill(16)("X")
          val expectedResult = " X | X | X | X\n" +
                               "===+===+===+===\n" +
                               " X | X | X | X\n" + 
                               "===+===+===+===\n" +
                               " X | X | X | X\n" + 
                               "===+===+===+===\n" +
                               " X | X | X | X\n"

          assert(presenter.formatBoardToString(board, tempBoard) == expectedResult)
        }

        it("should correctly format an empty board") {
          val tempBoard = List.fill(16)("")
          val expectedResult = "   |   |   |  \n" +
                               "===+===+===+===\n" +
                               "   |   |   |  \n" +
                               "===+===+===+===\n" +
                               "   |   |   |  \n" +
                               "===+===+===+===\n" +
                               "   |   |   |  \n"

          assert(presenter.formatBoardToString(board, tempBoard) == expectedResult)
        }

        it("should correctly format a board with board positions") {
          val tempBoard = List("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16")
          val expectedResult = "  1 |  2 |  3 |  4\n" +
                               "====+====+====+====\n" +
                               "  5 |  6 |  7 |  8\n" +
                               "====+====+====+====\n" +
                               "  9 | 10 | 11 | 12\n" +
                               "====+====+====+====\n" +
                               " 13 | 14 | 15 | 16\n"

          assert(presenter.formatBoardToString(board, tempBoard) == expectedResult)
        }
      }
    }
  }
}
