import org.scalatest.FunSpec
import carpentern.ttt.Board

class BoardSpec extends UnitSpec {
  val board = new Board()

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