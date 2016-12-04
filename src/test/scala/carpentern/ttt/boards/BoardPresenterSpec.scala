import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import carpentern.ttt.boards.Board
import carpentern.ttt.boards.BoardPresenter

class BoardPresenterSpec extends FunSpec with BeforeAndAfter {
  var board_3x3: Board = _
  var board_4x4: Board = _
  var presenter: BoardPresenter = _

  before {
    board_3x3 = Board(9)
    board_4x4 = Board(16)
    presenter = new BoardPresenter()
  }

  describe("BoardPresenter") {
    describe("#formatBoardValuesToString") {
      it("should correctly format a 3 x 3 board with markers") {
        val tempBoard = List.fill(9)("X")
        val newBoard = board_3x3.copy(squares = tempBoard)
        val expectedResult = " X | X | X\n" +
                             "===+===+===\n" +
                             " X | X | X\n" +
                             "===+===+===\n" +
                             " X | X | X\n"

        assert(presenter.formatBoardValuesToString(newBoard) == expectedResult)
      }

      it("should correctly format an empty 3 x 3 board") {
        val expectedResult = "   |   |  \n" +
                             "===+===+===\n" +
                             "   |   |  \n" +
                             "===+===+===\n" +
                             "   |   |  \n"

        assert(presenter.formatBoardValuesToString(board_3x3) == expectedResult)
      }

      it("should correctly format a 4 x 4 board with markers") {
        val tempBoard = List.fill(16)("X")
        val newBoard = board_4x4.copy(squares = tempBoard)
        val expectedResult = " X | X | X | X\n" +
                             "===+===+===+===\n" +
                             " X | X | X | X\n" +
                             "===+===+===+===\n" +
                             " X | X | X | X\n" +
                             "===+===+===+===\n" +
                             " X | X | X | X\n"

        assert(presenter.formatBoardValuesToString(newBoard) == expectedResult)
      }

      it("should correctly format an empty 4 x 4 board") {
        val expectedResult = "   |   |   |  \n" +
                             "===+===+===+===\n" +
                             "   |   |   |  \n" +
                             "===+===+===+===\n" +
                             "   |   |   |  \n" +
                             "===+===+===+===\n" +
                             "   |   |   |  \n"

        assert(presenter.formatBoardValuesToString(board_4x4) == expectedResult)
      }
    }

    describe("#formatBoardPositionsToString") {
      it("should correctly format a 3 x 3 board with board positions") {
        val expectedResult = " 1 | 2 | 3\n" +
                             "===+===+===\n" +
                             " 4 | 5 | 6\n" +
                             "===+===+===\n" +
                             " 7 | 8 | 9\n"

        assert(presenter.formatBoardPositionsToString(board_3x3) == expectedResult)
      }

      it("should correctly format a 4 x 4 board with board positions") {
        val expectedResult = "  1 |  2 |  3 |  4\n" +
                             "====+====+====+====\n" +
                             "  5 |  6 |  7 |  8\n" +
                             "====+====+====+====\n" +
                             "  9 | 10 | 11 | 12\n" +
                             "====+====+====+====\n" +
                             " 13 | 14 | 15 | 16\n"

        assert(presenter.formatBoardPositionsToString(board_4x4) == expectedResult)
      }
    }
  }
}
