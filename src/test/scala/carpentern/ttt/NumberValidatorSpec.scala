import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import carpentern.ttt.NumberValidator

class NumberValidatorSpec extends FunSpec with BeforeAndAfter {
  var validator: NumberValidator = _

  before {
    validator = new NumberValidator()
  }

  describe("NumberValidator") {
    describe("#isValidNumber") {
      it("should return true if number is valid") {
        val collection = List("1", "2", "3")

        assert(validator.isValidNumber("1", collection) == true)
      }

      it("should return false if number is a fraction") {
        val collection = List("1", "2", "3")

        assert(validator.isValidNumber("1/2", collection) == false)
      }

      it("should return false if number is a decimal") {
        val collection = List("1", "2", "3")

        assert(validator.isValidNumber("1.5", collection) == false)
      }

      it("should return false if number is a negative number") {
        val collection = List("1", "2", "3")

        assert(validator.isValidNumber("-1", collection) == false)
      }

      it("should return false if number is zero") {
        val collection = List("1", "2", "3")

        assert(validator.isValidNumber("0", collection) == false)
      }

      it("should return false if number is greater than the collection size") {
        val collection = List("1", "2", "3")

        assert(validator.isValidNumber("4", collection) == false)
      }

      it("should return false if number is a character") {
        val collection = List("1", "2", "3")

        assert(validator.isValidNumber("a", collection) == false)
      }

      it("should return false if number is a string") {
        val collection = List("1", "2", "3")

        assert(validator.isValidNumber("abc", collection) == false)
      }

      it("should return false if number is a special character") {
        val collection = List("1", "2", "3")

        assert(validator.isValidNumber("!", collection) == false)
      }

      it("should return false if number is a carraige return") {
        val collection = List("1", "2", "3")

        assert(validator.isValidNumber("", collection) == false)
      }

      it("should return false if number is an empty space") {
        val collection = List("1", "2", "3")

        assert(validator.isValidNumber(" ", collection) == false)
      }

      it("should return false if number is a series of empty spaces") {
        val collection = List("1", "2", "3")

        assert(validator.isValidNumber("   ", collection) == false)
      }
    }
  }
}