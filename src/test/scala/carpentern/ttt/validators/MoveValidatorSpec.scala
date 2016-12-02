import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import carpentern.ttt.validators.MoveValidator

class MoveValidatorSpec extends FunSpec with BeforeAndAfter {
  var validator: MoveValidator = _

  before {
    validator = new MoveValidator()
  }

  describe("MoveValidator") {
    describe("#isValid") {
      it("should return false if move is already taken") {
        val tempBoard = List("X", "", "", "", "", "", "", "", "")

        assert(validator.isValid(tempBoard, "1") == false)
      }
    }
  }
}