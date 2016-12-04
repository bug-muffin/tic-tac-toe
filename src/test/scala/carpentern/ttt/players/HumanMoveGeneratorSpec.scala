import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import carpentern.ttt.boards.Board
import carpentern.ttt.players.HumanMoveGenerator

class HumanMoveGeneratorSpec extends FunSpec with BeforeAndAfter {
  val mockView = new MockConsoleView()
  var moveGenerator: HumanMoveGenerator = _

  before {
    moveGenerator = new HumanMoveGenerator(mockView)
  }

  describe("HumanMoveGenerator") {
    describe("#selectSpace") {
      it("should return a valid space") {
        val board = Board(9)
        mockView.stubPlayerMove("1")

        assert(moveGenerator.selectSpace(board) == "1")
        assert(mockView.getPlayerMoveCalled == true)
      }
    }
  }
}