import org.scalatest.FunSpec
import org.scalatest.Matchers._
import carpentern.ttt.MoveValidator
import carpentern.ttt.ComputerMoveGenerator

class ComputerMoveGeneratorSpec extends UnitSpec {
  val validator = new MoveValidator()
  val moveGenerator = new ComputerMoveGenerator(validator)

  describe("#selectSpace") {
    it("should return a valid space") {
      val tempBoard = List("", "", "", "", "", "", "", "", "")
      moveGenerator.selectSpace(tempBoard).toInt should (be >= 1 and be <= tempBoard.length)
    }

    it("should not choose a space that is already taken") {
      val tempBoard = List("X", "", "X", "X", "X", "X", "X", "X", "X")
      assert(moveGenerator.selectSpace(tempBoard) == "1")
    }
  }
}