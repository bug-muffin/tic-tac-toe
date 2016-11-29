import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import carpentern.ttt.MoveValidator

class MoveValidatorSpec extends FunSpec with BeforeAndAfter {
  var validator: MoveValidator = _

  before {
    validator = new MoveValidator()
  }

  describe("#isValid") {
    it("should return true if move is valid") {
      val tempBoard = List("", "", "", "", "", "", "", "", "")
      assert(validator.isValid(tempBoard, "1") == true)
    }

    it("should return false if move is a fraction") {
      val tempBoard = List("", "", "", "", "", "", "", "", "")
      assert(validator.isValid(tempBoard, "1/2") == false)
    }

    it("should return false if move is a decimal") {
      val tempBoard = List("", "", "", "", "", "", "", "", "")
      assert(validator.isValid(tempBoard, "1.5") == false)
    }

    it("should return false if move is a negative number") {
      val tempBoard = List("", "", "", "", "", "", "", "", "")
      assert(validator.isValid(tempBoard, "-1") == false)
    }

    it("should return false if move is greater than the board size") {
      val tempBoard = List("", "", "", "", "", "", "", "", "")
      assert(validator.isValid(tempBoard, "12") == false)
    }

    it("should return false if move is a character") {
      val tempBoard = List("", "", "", "", "", "", "", "", "")
      assert(validator.isValid(tempBoard, "a") == false)
    }

    it("should return false if move is a string") {
      val tempBoard = List("", "", "", "", "", "", "", "", "")
      assert(validator.isValid(tempBoard, "abc") == false)
    }

    it("should return false if move is a special character") {
      val tempBoard = List("", "", "", "", "", "", "", "", "")
      assert(validator.isValid(tempBoard, "!") == false)
    }

    it("should return false if move is a carraige return") {
      val tempBoard = List("", "", "", "", "", "", "", "", "")
      assert(validator.isValid(tempBoard, "") == false)
    }

    it("should return false if move is an empty space") {
      val tempBoard = List("", "", "", "", "", "", "", "", "")
      assert(validator.isValid(tempBoard, " ") == false)
    }

    it("should return false if move is a series of empty spaces") {
      val tempBoard = List("", "", "", "", "", "", "", "", "")
      assert(validator.isValid(tempBoard, "   ") == false)
    }

    it("should return false if move is already taken") {
      val tempBoard = List("X", "", "", "", "", "", "", "", "")
      assert(validator.isValid(tempBoard, "0") == false)
    }
  }
}