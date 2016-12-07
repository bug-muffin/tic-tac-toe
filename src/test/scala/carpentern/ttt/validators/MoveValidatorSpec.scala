import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import carpentern.ttt.config.{X,EMPTY}
import carpentern.ttt.validators.MoveValidator

class MoveValidatorSpec extends FunSpec with BeforeAndAfter {
  var validator: MoveValidator = _

  before {
    validator = new MoveValidator()
  }

  describe("MoveValidator") {
    describe("#isValid") {
      it("should return false if move is already taken") {
        val tempBoard = List(X, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY)

        assert(!validator.isValid(tempBoard, "1"))
      }
    }
  }
}