import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import carpentern.ttt.HumanMoveGenerator

class HumanMoveGeneratorSpec extends FunSpec with BeforeAndAfter {
  val mockView = new MockConsoleView()
  var moveGenerator: HumanMoveGenerator = _

  before {
    moveGenerator = new HumanMoveGenerator(mockView)
  }

  describe("HumanMoveGenerator") {
    describe("#selectSpace") {
      it("should return a valid space") {
        val tempBoard = List("", "", "", "", "", "", "", "", "")
        mockView.stubPlayerMove("1")

        assert(moveGenerator.selectSpace(tempBoard) == "1")
        assert(mockView.getPlayerMoveCalled == true)
      }
    }
  }
}