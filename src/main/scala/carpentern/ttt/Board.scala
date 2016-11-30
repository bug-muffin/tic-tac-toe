package carpentern.ttt

import scala.collection.mutable.ListBuffer

class Board() {
  def createGameBoard(boardSize: Int) = {
    List.fill(boardSize)("")
  }

  def countRows(board:List[String]) : Int = {
    math.sqrt(board.length).toInt
  }

  def findRows(board:List[String]) : List[List[Int]] = {
    val rowCount = countRows(board)
    boardPositions(board).grouped(rowCount).toList
  }

  def findColumns(board:List[String]) : List[List[Int]] = {
    val rows = findRows(board)
    rows.transpose
  }

  def findDiagonals(board:List[String]) : List[List[Int]] = {
    val rows = findRows(board)
    List(findForwardsDiagonal(board, rows), findBackwardsDiagonal(board, rows))
  }

  def separateRows(board:List[String]) : List[List[String]] = {
    val rowCount = countRows(board)
    board.grouped(rowCount).toList
  }

  def findOpenSpaces(board:List[String]) : List[Int] = {
    board.zipWithIndex.collect{ case(x, i) if x == "" => i }
  }

  def placePiece(board:List[String], space:Int, marker:String) : List[String] = {
    board.updated(space - 1, marker)
  }

  def printableBoardPositions(boardPositions:List[Int]) : List[String] = {
    boardPositions.map((_ + 1)).map(_.toString)
  }

  def boardPositions(board:List[String]) : List[Int] = {
    List.range(0, board.length)
  }

  private def findForwardsDiagonal(board:List[String], rows:List[List[Int]]) : List[Int] = {
    var diagonals = new ListBuffer[Int]()
    for (x <- 0 to rows.length - 1) {
      diagonals += rows(x)(x)
    }
    diagonals.toList
  }

  private def findBackwardsDiagonal(board:List[String], rows:List[List[Int]]) : List[Int] = {
    var diagonals = new ListBuffer[Int]()
    for (x <- 0 to rows.length - 1) {
      diagonals += rows(x)((rows.length - 1) - x)
    }
    diagonals.toList
  }
}