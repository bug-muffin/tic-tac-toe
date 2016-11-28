import org.scalatest.FunSpec
import carpentern.ttt.HumanMoveGenerator

class HumanMoveGeneratorSpec extends UnitSpec {
  describe("#selectSpace") {
    it("should return a valid space") {
      val mockView = new MockConsoleView
      val moveGenerator = new HumanMoveGenerator(mockView)
      val tempBoard = List("", "", "", "", "", "", "", "", "")
      mockView.stubPlayerMove("1")
      assert(moveGenerator.selectSpace(tempBoard) == "1")
      assert(mockView.getPlayerMoveCalled == true)
    }
  }
}