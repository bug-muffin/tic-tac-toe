import org.scalatest.FunSpec
import carpentern.ttt.GameRules
import carpentern.ttt.Board

class GameRulesSpec extends UnitSpec {
  val board = new Board()
  val rules = new GameRules(board)

  describe("#isTieConditionMet") {
    describe("3 x 3 board") {
      it("should return true if there is a tie") {
        val tempBoard = List("X", "X", "O", "O", "O", "X", "X", "O", "X")
        assert(rules.isTieConditionMet(tempBoard) == true)
      }

      it("should return false for an empty board") {
        val tempBoard = List("", "", "", "", "", "", "", "", "")
        assert(rules.isTieConditionMet(tempBoard) == false)
      }

      it("should return false if there are any empty spaces") {
        val tempBoard = List("X", "X", "O", "O", "O", "X", "X", "O", "")
        assert(rules.isTieConditionMet(tempBoard) == false)
      }
    }

    describe("4 x 4 board") {
      it("should return true if there is a tie") {
        val tempBoard = List("X", "X", "O", "X", "O", "O", "X", "X", "X", "O", "X", "O", "O", "O", "O", "X")
        assert(rules.isTieConditionMet(tempBoard) == true)
      }

      it("should return false for an empty board") {
        val tempBoard = List("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
        assert(rules.isTieConditionMet(tempBoard) == false)
      }

      it("should return false if there are any empty spaces") {
        val tempBoard = List("X", "X", "O", "X", "O", "O", "X", "X", "X", "O", "X", "O", "O", "O", "O", "")
        assert(rules.isTieConditionMet(tempBoard) == false)
      }
    }
  }

  describe("#isWinningConditionMet") {
    describe("3 x 3 board") {
      it("should return true if there is a winning top row") {
        val tempBoard = List("X", "X", "X", "", "", "", "", "", "")
        assert(rules.isWinningConditionMet(tempBoard) == true)
      }

      it("should return true if there is a winning middle row") {
        val tempBoard = List("", "", "", "X", "X", "X", "", "", "")
        assert(rules.isWinningConditionMet(tempBoard) == true)
      }

      it("should return true if there is a winning bottom row") {
        val tempBoard = List("", "", "", "", "", "", "X", "X", "X")
        assert(rules.isWinningConditionMet(tempBoard) == true)
      }

      it("should return true if there is a winning left column") {
        val tempBoard = List("X", "", "", "X", "", "", "X", "", "")
        assert(rules.isWinningConditionMet(tempBoard) == true)
      }

      it("should return true if there is a winning middle column") {
        val tempBoard = List("", "X", "", "", "X", "", "", "X", "")
        assert(rules.isWinningConditionMet(tempBoard) == true)
      }

      it("should return true if there is a winning right column") {
        val tempBoard = List("", "", "X", "", "", "X", "", "", "X")
        assert(rules.isWinningConditionMet(tempBoard) == true)
      }

      it("should return true if there is a winning forwards diagonal") {
        val tempBoard = List("X", "", "", "", "X", "", "", "", "X")
        assert(rules.isWinningConditionMet(tempBoard) == true)
      }

      it("should return true if there is a winning backwards diagonal") {
        val tempBoard = List("", "", "X", "", "X", "", "X", "", "")
        assert(rules.isWinningConditionMet(tempBoard) == true)
      }

      it("should return false if no winner on empty board") {
        val tempBoard = List("", "", "", "", "", "", "", "", "")
        assert(rules.isWinningConditionMet(tempBoard) == false)
      }

      it("should return false if there is a draw") {
        val tempBoard = List("X", "X", "O", "O", "O", "X", "X", "O", "X")
        assert(rules.isWinningConditionMet(tempBoard) == false)
      }

      it("should return false if there is a mismatched combo") {
        val tempBoard = List("X", "X", "O", "", "", "", "", "", "")
        assert(rules.isWinningConditionMet(tempBoard) == false)
      }      
    }

    describe("4 x 4 board") {
      it("should return true if there is a winning top row") {
        val tempBoard = List("X", "X", "X", "X", "", "", "", "", "", "", "", "", "", "", "", "")
        assert(rules.isWinningConditionMet(tempBoard) == true)
      }

      it("should return true if there is a winning second row") {
        val tempBoard = List("", "", "", "", "X", "X", "X", "X", "", "", "", "", "", "", "", "")
        assert(rules.isWinningConditionMet(tempBoard) == true)
      }

      it("should return true if there is a winning third row") {
        val tempBoard = List("", "", "", "", "", "", "", "", "X", "X", "X", "X", "", "", "", "")
        assert(rules.isWinningConditionMet(tempBoard) == true)
      }

      it("should return true if there is a winning bottom row") {
        val tempBoard = List("", "", "", "", "", "", "", "", "", "", "", "", "X", "X", "X", "X")
        assert(rules.isWinningConditionMet(tempBoard) == true)
      }

      it("should return true if there is a winning left column") {
        val tempBoard = List("X", "", "", "", "X", "", "", "", "X", "", "", "", "X", "", "", "")
        assert(rules.isWinningConditionMet(tempBoard) == true)
      }

      it("should return true if there is a winning second column") {
        val tempBoard = List("", "X", "", "", "", "X", "", "", "", "X", "", "", "", "X", "", "")
        assert(rules.isWinningConditionMet(tempBoard) == true)
      }

      it("should return true if there is a winning third column") {
        val tempBoard = List("", "", "X", "", "", "", "X", "", "", "", "X", "", "", "", "X", "")
        assert(rules.isWinningConditionMet(tempBoard) == true)
      }

      it("should return true if there is a winning right column") {
        val tempBoard = List("", "", "", "X", "", "", "", "X", "", "", "", "X", "", "", "", "X")
        assert(rules.isWinningConditionMet(tempBoard) == true)
      }

      it("should return true if there is a winning forwards diagonal") {
        val tempBoard = List("X", "", "", "", "", "X", "", "", "", "", "X", "", "", "", "", "X")
        assert(rules.isWinningConditionMet(tempBoard) == true)
      }

      it("should return true if there is a winning backwards diagonal") {
        val tempBoard = List("", "", "", "X", "", "", "X", "", "", "X", "", "", "X", "", "", "")
        assert(rules.isWinningConditionMet(tempBoard) == true)
      }

      it("should return false if no winner on empty board") {
        val tempBoard = List("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
        assert(rules.isWinningConditionMet(tempBoard) == false)
      }

      it("should return false if there is a draw") {
        val tempBoard = List("X", "X", "O", "X", "O", "O", "X", "X", "X", "O", "X", "O", "O", "O", "O", "X")
        assert(rules.isWinningConditionMet(tempBoard) == false)
      }

      it("should return false if there is a mismatched combo") {
        val tempBoard = List("X", "X", "X", "O", "", "", "", "", "", "", "", "", "", "", "", "")
        assert(rules.isWinningConditionMet(tempBoard) == false)
      }      
    }

  }

  describe("#isGameOver") {
    it("should return true if there is a winner") {
      val tempBoard = List("X", "X", "X", "", "", "", "", "", "")
      assert(rules.isGameOver(tempBoard) == true)
    }

    it("should return true if there is a tie") {
      val tempBoard = List("X", "X", "O", "O", "O", "X", "X", "O", "X")
      assert(rules.isGameOver(tempBoard) == true)
    }

    it("should return false for a blank board") {
      val tempBoard = List("", "", "", "", "", "", "", "", "")
      assert(rules.isGameOver(tempBoard) == false)
    }

    it("should return false for any blanks on the board") {
      val tempBoard = List("X", "X", "O", "O", "O", "X", "X", "O", "")
      assert(rules.isGameOver(tempBoard) == false)
    }
  }
}