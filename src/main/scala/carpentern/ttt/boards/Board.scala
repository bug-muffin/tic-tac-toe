package carpentern.ttt.boards

import scala.collection.mutable.ListBuffer

object Board {
  def apply(boardSize: Int): Board = new Board(boardSize, List.fill(boardSize)(""))
}

case class Board(boardSize: Int, squares: List[String]) {

  def placePiece(space: Int, marker: String): Board =
    new Board(boardSize, squares.updated(space - 1, marker))

  def countRows: Int = math.sqrt(boardSize).toInt

  def findRows: List[List[Int]] = boardPositions.grouped(countRows).toList

  def findColumns: List[List[Int]] = findRows.transpose

  def findDiagonals: List[List[Int]] = List(findForwardsDiagonal, findBackwardsDiagonal)

  def findOpenSpaces: List[Int] = squares.zipWithIndex.collect{ case(x, i) if x == "" => i }

  def printableBoardPositions: List[String] = boardPositions.map((_ + 1)).map(_.toString)

  def boardPositions: List[Int] = List.range(0, boardSize)

  private def findForwardsDiagonal: List[Int] = {
    var diagonals = new ListBuffer[Int]()
    var rows = findRows
    for (x <- 0 to rows.length - 1) {
      diagonals += rows(x)(x)
    }
    diagonals.toList
  }

  private def findBackwardsDiagonal: List[Int] = {
    var diagonals = new ListBuffer[Int]()
    var rows = findRows
    for (x <- 0 to rows.length - 1) {
      diagonals += rows(x)((rows.length - 1) - x)
    }
    diagonals.toList
  }
}