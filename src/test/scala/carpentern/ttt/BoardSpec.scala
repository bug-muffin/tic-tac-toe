import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import carpentern.ttt.Board

class BoardSpec extends FunSpec with BeforeAndAfter {
  val boardSize = 9
  var empty3x3: List[String] = _
  var empty4x4: List[String] = _
  var board: Board = _

  before {
    board = new Board()
    empty3x3 = List.fill(9)("")
    empty4x4 = List.fill(16)("")
  }

  describe("Board") {
    describe("#createGameBoard") {
      it("should create a list with the board size number of elements as") {
        assert(board.createGameBoard(boardSize).length == boardSize)
      }

      it("should only contain blanks") {
        val gameBoard = board.createGameBoard(boardSize)

        assert(gameBoard.distinct.length == 1)
        assert(gameBoard(0) == "")
      }
    }

    describe("#countRows") {
      it("should return the 3 for a 3 x 3 board") {
        assert(board.countRows(empty3x3) == 3)
      }

      it("should return the 4 for a 4 x 4 board") {
        assert(board.countRows(empty4x4) == 4)
      }
    }

    describe("#findRows") {
      it("should return 3 rows of 3 elements for a 3 x 3 board") {
        assert(board.findRows(empty3x3).length == 3)
        assert(board.findRows(empty3x3) == List(List(0,1,2), List(3,4,5), List(6,7,8)))
      }

      it("should return 4 rows of 4 elements for a  4 x 4 board") {
        assert(board.findRows(empty4x4).length == 4)
        assert(board.findRows(empty4x4) == List(List(0,1,2,3), List(4,5,6,7), List(8,9,10,11), List(12,13,14,15)))
      }
    }

    describe("#findColumns") {
      it("should return 3 columns of 3 elements for a 3 x 3 board") {
        assert(board.findColumns(empty3x3).length == 3)
        assert(board.findColumns(empty3x3) == List(List(0,3,6), List(1,4,7), List(2,5,8)))
      }

      it("should return 4 columns of 4 elements for a  4 x 4 board") {
        assert(board.findColumns(empty4x4).length == 4)
        assert(board.findColumns(empty4x4) == List(List(0,4,8,12), List(1,5,9,13), List(2,6,10,14), List(3,7,11,15)))
      }
    }

    describe("#findDiagonals") {
      it("should return 2 diagonals of 3 elements for a 3 x 3 board") {
        assert(board.findDiagonals(empty3x3).length == 2)
        assert(board.findDiagonals(empty3x3) == List(List(0,4,8), List(2,4,6)))
      }

      it("should return 4 diagonals of 4 elements for a  4 x 4 board") {
        assert(board.findDiagonals(empty4x4).length == 2)
        assert(board.findDiagonals(empty4x4) == List(List(0,5,10,15), List(3,6,9,12)))
      }
    }

    describe("#separateRows") {
      it("should return 3 elements for a 3 x 3 board") {
        val tempBoard = List("X", "X", "X", "O", "O", "O", "X", "X", "X")

        assert(board.separateRows(tempBoard) == List(List("X","X","X"), List("O","O","O"), List("X","X","X")))
      }

      it("should return 4 elements for a 4 x 4 board") {
        val tempBoard = List("X", "X", "X", "X", "O", "O", "O", "O", "X", "X", "X", "X", "O", "O", "O", "O")

        assert(board.separateRows(tempBoard) == List(List("X","X","X","X"), List("O","O","O","O"), List("X","X","X","X"), List("O","O","O","O")))
      }
    }

    describe("#findOpenSpaces") {
      it("should return all spaces if none are occupied") {
        assert(board.findOpenSpaces(empty3x3) == List(0, 1, 2, 3, 4, 5, 6, 7, 8))
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
        val space = 2
        val marker = "X"

        assert(board.placePiece(empty3x3, space, marker) == List("", "X", "", "", "", "", "", "", ""))
      }
    }

    describe("#printableBoardPositions") {
      it("should return a list of strings from 1 to 9 for a 3 x 3 board") {
        val tempBoard = List(0, 1, 2, 3, 4, 5, 6, 7, 8)

        assert(board.printableBoardPositions(tempBoard) == List("1", "2", "3", "4", "5", "6", "7", "8", "9"))
      }

      it("should return a list of strings from 1 to 16 for a 4 x 4 board") {
        val tempBoard = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)

        assert(board.printableBoardPositions(tempBoard) == List("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"))
      }
    }

    describe("boardPositions") {
      it("should return a list of indices from 0 to 8 for a 3 x 3 board") {
        assert(board.boardPositions(empty3x3) == List(0, 1, 2, 3, 4, 5, 6, 7, 8))
      }

      it("should return a list of indices from 0 to 15 for a 4 x 4 board") {
        assert(board.boardPositions(empty4x4) == List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15))
      }
    }
  }
}