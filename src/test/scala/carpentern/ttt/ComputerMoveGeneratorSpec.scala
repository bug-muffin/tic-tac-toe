import org.scalatest.FunSpec
import org.scalatest.Matchers._
import carpentern.ttt.ComputerMoveGenerator

class ComputerMoveGeneratorSpec extends UnitSpec {
  describe("#selectSpace") {
    it("should return a valid space") {
      val moveGenerator = new ComputerMoveGenerator()
      val tempBoard = List("", "", "", "", "", "", "", "", "")
      moveGenerator.selectSpace(tempBoard).toInt should (be >= 1 and be <= tempBoard.length)
    }
  }
}