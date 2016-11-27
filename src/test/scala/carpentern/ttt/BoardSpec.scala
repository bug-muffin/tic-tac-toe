import org.scalatest.FunSpec
import carpentern.ttt.Board

class BoardSpec extends UnitSpec {
  val board = new Board()

  describe("#countRows") {
    it("should return the 3 for a 3 x 3 board") {
      val tempBoard = List.fill(9)("")
      assert(board.countRows(tempBoard) == 3)
    }

    it("should return the 4 for a 4 x 4 board") {
      val tempBoard = List.fill(16)("")
      assert(board.countRows(tempBoard) == 4)
    }
  }

  describe("#findRows") {
    it("should return 3 rows of 3 elements for a 3 x 3 board") {
      val tempBoard = List.fill(9)("")
      assert(board.findRows(tempBoard).length == 3)
      assert(board.findRows(tempBoard) == List(List(0,1,2), List(3,4,5), List(6,7,8)))
    }

    it("should return 4 rows of 4 elements for a  4 x 4 board") {
      val tempBoard = List.fill(16)("")
      assert(board.findRows(tempBoard).length == 4)
      assert(board.findRows(tempBoard) == List(List(0,1,2,3), List(4,5,6,7), List(8,9,10,11), List(12,13,14,15)))
    }
  }

  describe("#findColumns") {
    it("should return 3 columns of 3 elements for a 3 x 3 board") {
      val tempBoard = List.fill(9)("")
      assert(board.findColumns(tempBoard).length == 3)
      assert(board.findColumns(tempBoard) == List(List(0,3,6), List(1,4,7), List(2,5,8)))
    }

    it("should return 4 columns of 4 elements for a  4 x 4 board") {
      val tempBoard = List.fill(16)("")
      assert(board.findColumns(tempBoard).length == 4)
      assert(board.findColumns(tempBoard) == List(List(0,4,8,12), List(1,5,9,13), List(2,6,10,14), List(3,7,11,15)))
    }
  }

  describe("#findDiagonals") {
    it("should return 2 diagonals of 3 elements for a 3 x 3 board") {
      val tempBoard = List.fill(9)("")
      assert(board.findDiagonals(tempBoard).length == 2)
      assert(board.findDiagonals(tempBoard) == List(List(0,4,8), List(2,4,6)))
    }

    it("should return 4 diagonals of 4 elements for a  4 x 4 board") {
      val tempBoard = List.fill(16)("")
      assert(board.findDiagonals(tempBoard).length == 2)
      assert(board.findDiagonals(tempBoard) == List(List(0,5,10,15), List(3,6,9,12)))
    }
  }

  describe("#findOpenSpaces") {
    it("should return all spaces if none are occupied") {
      val tempBoard = List("", "", "", "", "", "", "", "", "")
      assert(board.findOpenSpaces(tempBoard) == List(0, 1, 2, 3, 4, 5, 6, 7, 8))
    }

    it("should return no spaces if all are occupied") {
      val tempBoard = List("X", "O", "O", "O", "X", "X", "X", "O", "O")
      assert(board.findOpenSpaces(tempBoard) == List())
    }

    it("should return only spaces that are occupied") {
      val tempBoard = List("X", "O", "X", "", "", "", "", "", "")
      assert(board.findOpenSpaces(tempBoard) == List(3, 4, 5, 6, 7, 8))
    }
  }

  describe("#placePiece") {
    it("should return a new board array with the piece in the selected place") {
      val tempBoard = List("", "", "", "", "", "", "", "", "")
      val space = 1
      val marker = "X"
      assert(board.placePiece(tempBoard, space, marker) == List("", "X", "", "", "", "", "", "", ""))
    }
  }
}