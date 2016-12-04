import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import carpentern.ttt.boards.Board
import carpentern.ttt.game.GameRules

class GameRulesSpec extends FunSpec with BeforeAndAfter {
  val board_3x3 = Board(9)
  val board_4x4 = Board(16)
  var board: Board = _
  var rules: GameRules = _

  before {
    rules = new GameRules()
  }

  describe("GameRules") {
    describe("#isTieConditionMet") {
      describe("3 x 3 board") {

        it("should return true if there is a tie") {
          val tempBoard = List("X", "X", "O", "O", "O", "X", "X", "O", "X")
          val newBoard = board_3x3.copy(squares = tempBoard)

          assert(rules.isTieConditionMet(newBoard))
        }

        it("should return false for an empty board") {
          val tempBoard = List("", "", "", "", "", "", "", "", "")
          val newBoard = board_3x3.copy(squares = tempBoard)

          assert(!rules.isTieConditionMet(newBoard))
        }

        it("should return false if there are any empty spaces") {
          val tempBoard = List("X", "X", "O", "O", "O", "X", "X", "O", "")
          val newBoard = board_3x3.copy(squares = tempBoard)

          assert(!rules.isTieConditionMet(newBoard))
        }
      }

      describe("4 x 4 board") {
        it("should return true if there is a tie") {
          val tempBoard = List("X", "X", "O", "X", "O", "O", "X", "X", "X", "O", "X", "O", "O", "O", "O", "X")
          val newBoard = board_4x4.copy(squares = tempBoard)

          assert(rules.isTieConditionMet(newBoard))
        }

        it("should return false for an empty board") {
          val tempBoard = List("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
          val newBoard = board_4x4.copy(squares = tempBoard)

          assert(!rules.isTieConditionMet(newBoard))
        }

        it("should return false if there are any empty spaces") {
          val tempBoard = List("X", "X", "O", "X", "O", "O", "X", "X", "X", "O", "X", "O", "O", "O", "O", "")
          val newBoard = board_4x4.copy(squares = tempBoard)

          assert(!rules.isTieConditionMet(newBoard))
        }
      }
    }

    describe("#isWinningConditionMet") {
      describe("3 x 3 board") {
        it("should return true if there is a winning top row") {
          val tempBoard = List("X", "X", "X", "", "", "", "", "", "")
          val newBoard = board_3x3.copy(squares = tempBoard)

          assert(rules.isWinningConditionMet(newBoard))
        }

        it("should return true if there is a winning middle row") {
          val tempBoard = List("", "", "", "X", "X", "X", "", "", "")
          val newBoard = board_3x3.copy(squares = tempBoard)

          assert(rules.isWinningConditionMet(newBoard))
        }

        it("should return true if there is a winning bottom row") {
          val tempBoard = List("", "", "", "", "", "", "X", "X", "X")
          val newBoard = board_3x3.copy(squares = tempBoard)

          assert(rules.isWinningConditionMet(newBoard))
        }

        it("should return true if there is a winning left column") {
          val tempBoard = List("X", "", "", "X", "", "", "X", "", "")
          val newBoard = board_3x3.copy(squares = tempBoard)

          assert(rules.isWinningConditionMet(newBoard))
        }

        it("should return true if there is a winning middle column") {
          val tempBoard = List("", "X", "", "", "X", "", "", "X", "")
          val newBoard = board_3x3.copy(squares = tempBoard)

          assert(rules.isWinningConditionMet(newBoard))
        }

        it("should return true if there is a winning right column") {
          val tempBoard = List("", "", "X", "", "", "X", "", "", "X")
          val newBoard = board_3x3.copy(squares = tempBoard)

          assert(rules.isWinningConditionMet(newBoard))
        }

        it("should return true if there is a winning forwards diagonal") {
          val tempBoard = List("X", "", "", "", "X", "", "", "", "X")
          val newBoard = board_3x3.copy(squares = tempBoard)

          assert(rules.isWinningConditionMet(newBoard))
        }

        it("should return true if there is a winning backwards diagonal") {
          val tempBoard = List("", "", "X", "", "X", "", "X", "", "")
          val newBoard = board_3x3.copy(squares = tempBoard)

          assert(rules.isWinningConditionMet(newBoard))
        }

        it("should return false if no winner on empty board") {
          val tempBoard = List("", "", "", "", "", "", "", "", "")
          val newBoard = board_3x3.copy(squares = tempBoard)

          assert(!rules.isWinningConditionMet(newBoard))
        }

        it("should return false if there is a draw") {
          val tempBoard = List("X", "X", "O", "O", "O", "X", "X", "O", "X")
          val newBoard = board_3x3.copy(squares = tempBoard)

          assert(!rules.isWinningConditionMet(newBoard))
        }

        it("should return false if there is a mismatched combo") {
          val tempBoard = List("X", "X", "O", "", "", "", "", "", "")
          val newBoard = board_3x3.copy(squares = tempBoard)

          assert(!rules.isWinningConditionMet(newBoard))
        }
      }

      describe("4 x 4 board") {
        it("should return true if there is a winning top row") {
          val tempBoard = List("X", "X", "X", "X", "", "", "", "", "", "", "", "", "", "", "", "")
          val newBoard = board_4x4.copy(squares = tempBoard)

          assert(rules.isWinningConditionMet(newBoard))
        }

        it("should return true if there is a winning second row") {
          val tempBoard = List("", "", "", "", "X", "X", "X", "X", "", "", "", "", "", "", "", "")
          val newBoard = board_4x4.copy(squares = tempBoard)

          assert(rules.isWinningConditionMet(newBoard))
        }

        it("should return true if there is a winning third row") {
          val tempBoard = List("", "", "", "", "", "", "", "", "X", "X", "X", "X", "", "", "", "")
          val newBoard = board_4x4.copy(squares = tempBoard)

          assert(rules.isWinningConditionMet(newBoard))
        }

        it("should return true if there is a winning bottom row") {
          val tempBoard = List("", "", "", "", "", "", "", "", "", "", "", "", "X", "X", "X", "X")
          val newBoard = board_4x4.copy(squares = tempBoard)

          assert(rules.isWinningConditionMet(newBoard))
        }

        it("should return true if there is a winning left column") {
          val tempBoard = List("X", "", "", "", "X", "", "", "", "X", "", "", "", "X", "", "", "")
          val newBoard = board_4x4.copy(squares = tempBoard)

          assert(rules.isWinningConditionMet(newBoard))
        }

        it("should return true if there is a winning second column") {
          val tempBoard = List("", "X", "", "", "", "X", "", "", "", "X", "", "", "", "X", "", "")
          val newBoard = board_4x4.copy(squares = tempBoard)

          assert(rules.isWinningConditionMet(newBoard))
        }

        it("should return true if there is a winning third column") {
          val tempBoard = List("", "", "X", "", "", "", "X", "", "", "", "X", "", "", "", "X", "")
          val newBoard = board_4x4.copy(squares = tempBoard)

          assert(rules.isWinningConditionMet(newBoard))
        }

        it("should return true if there is a winning right column") {
          val tempBoard = List("", "", "", "X", "", "", "", "X", "", "", "", "X", "", "", "", "X")
          val newBoard = board_4x4.copy(squares = tempBoard)

          assert(rules.isWinningConditionMet(newBoard))
        }

        it("should return true if there is a winning forwards diagonal") {
          val tempBoard = List("X", "", "", "", "", "X", "", "", "", "", "X", "", "", "", "", "X")
          val newBoard = board_4x4.copy(squares = tempBoard)

          assert(rules.isWinningConditionMet(newBoard))
        }

        it("should return true if there is a winning backwards diagonal") {
          val tempBoard = List("", "", "", "X", "", "", "X", "", "", "X", "", "", "X", "", "", "")
          val newBoard = board_4x4.copy(squares = tempBoard)

          assert(rules.isWinningConditionMet(newBoard))
        }

        it("should return false if no winner on empty board") {
          val tempBoard = List("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
          val newBoard = board_4x4.copy(squares = tempBoard)

          assert(!rules.isWinningConditionMet(newBoard))
        }

        it("should return false if there is a draw") {
          val tempBoard = List("X", "X", "O", "X", "O", "O", "X", "X", "X", "O", "X", "O", "O", "O", "O", "X")
          val newBoard = board_4x4.copy(squares = tempBoard)

          assert(!rules.isWinningConditionMet(newBoard))
        }

        it("should return false if there is a mismatched combo") {
          val tempBoard = List("X", "X", "X", "O", "", "", "", "", "", "", "", "", "", "", "", "")
          val newBoard = board_4x4.copy(squares = tempBoard)

          assert(!rules.isWinningConditionMet(newBoard))
        }
      }

    }

    describe("#findWinningMarker") {
      it("should return the marker of the winner") {
        val tempBoard = List("X", "X", "X", "O", "O", "", "", "", "")
        val newBoard = board_3x3.copy(squares = tempBoard)

        assert(rules.findWinningMarker(newBoard) == "X")
      }
    }

    describe("#isGameOver") {
      it("should return true if there is a winner") {
        val tempBoard = List("X", "X", "X", "", "", "", "", "", "")
        val newBoard = board_3x3.copy(squares = tempBoard)

        assert(rules.isGameOver(newBoard))
      }

      it("should return true if there is a tie") {
        val tempBoard = List("X", "X", "O", "O", "O", "X", "X", "O", "X")
        val newBoard = board_3x3.copy(squares = tempBoard)

        assert(rules.isGameOver(newBoard))
      }

      it("should return false for a blank board") {
        val tempBoard = List("", "", "", "", "", "", "", "", "")
        val newBoard = board_3x3.copy(squares = tempBoard)

        assert(!rules.isGameOver(newBoard))
      }

      it("should return false for any blanks on the board") {
        val tempBoard = List("X", "X", "O", "O", "O", "X", "X", "O", "")
        val newBoard = board_3x3.copy(squares = tempBoard)

        assert(!rules.isGameOver(newBoard))
      }
    }
  }
}
