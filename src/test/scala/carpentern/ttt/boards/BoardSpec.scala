import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import org.scalatest.Matchers._

import carpentern.ttt.boards.Board

class BoardSpec extends FunSpec with BeforeAndAfter {
  var board_3x3: Board = _
  var board_4x4: Board = _

  before {
    board_3x3 = Board(9)
    board_4x4 = Board(16)
  }

  describe("Board") {
    describe("creating a board") {
      it("should create a list with the board size number of elements") {
        assert(board_3x3.boardSize == 9)
      }

      it("should only contain blanks") {
        assert(board_3x3.squares.distinct.length == 1)
        assert(board_3x3.squares(0) == "")
      }
    }

    describe("#countRows") {
      it("should return the 3 for a 3 x 3 board") {
        assert(board_3x3.countRows == 3)
      }

      it("should return the 4 for a 4 x 4 board") {
        assert(board_4x4.countRows == 4)
      }
    }

    describe("#findRows") {
      it("should return 3 rows of 3 elements for a 3 x 3 board") {
        assert(board_3x3.findRows.length == 3)
        assert(board_3x3.findRows == List(List(0,1,2), List(3,4,5), List(6,7,8)))
      }

      it("should return 4 rows of 4 elements for a  4 x 4 board") {
        assert(board_4x4.findRows.length == 4)
        assert(board_4x4.findRows == List(List(0,1,2,3), List(4,5,6,7), List(8,9,10,11), List(12,13,14,15)))
      }
    }

    describe("#findColumns") {
      it("should return 3 columns of 3 elements for a 3 x 3 board") {
        assert(board_3x3.findColumns.length == 3)
        assert(board_3x3.findColumns == List(List(0,3,6), List(1,4,7), List(2,5,8)))
      }

      it("should return 4 columns of 4 elements for a  4 x 4 board") {
        assert(board_4x4.findColumns.length == 4)
        assert(board_4x4.findColumns == List(List(0,4,8,12), List(1,5,9,13), List(2,6,10,14), List(3,7,11,15)))
      }
    }

    describe("#findDiagonals") {
      it("should return 2 diagonals of 3 elements for a 3 x 3 board") {
        assert(board_3x3.findDiagonals.length == 2)
        assert(board_3x3.findDiagonals == List(List(0,4,8), List(2,4,6)))
      }

      it("should return 4 diagonals of 4 elements for a  4 x 4 board") {
        assert(board_4x4.findDiagonals.length == 2)
        assert(board_4x4.findDiagonals == List(List(0,5,10,15), List(3,6,9,12)))
      }
    }

    describe("#findOpenSpaces") {
      it("should return all spaces if none are occupied") {
        assert(board_3x3.findOpenSpaces == List(0, 1, 2, 3, 4, 5, 6, 7, 8))
      }

      it("should return no spaces if all are occupied") {
        val newSquares = List("X", "O", "O", "O", "X", "X", "X", "O", "O")
        val newBoard = board_3x3.copy(squares = newSquares)

        assert(newBoard.findOpenSpaces == List())
      }

      it("should return only spaces that are occupied") {
        val newSquares = List("X", "O", "X", "", "", "", "", "", "")
        val newBoard = board_3x3.copy(squares = newSquares)

        assert(newBoard.findOpenSpaces == List(3, 4, 5, 6, 7, 8))
      }
    }

    describe("#placePiece") {
      it("should return a new board array with the piece in the selected place") {
        val newBoard = board_3x3.placePiece(2, "X")
        assert(newBoard.squares == List("", "X", "", "", "", "", "", "", ""))
        newBoard shouldBe a [Board]
      }
    }

    describe("boardPositions") {
      it("should return a list of indices from 0 to 8 for a 3 x 3 board") {
        assert(board_3x3.boardPositions == List(0, 1, 2, 3, 4, 5, 6, 7, 8))
      }

      it("should return a list of indices from 0 to 15 for a 4 x 4 board") {
        assert(board_4x4.boardPositions == List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15))
      }
    }
  }
}