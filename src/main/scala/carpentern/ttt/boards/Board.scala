package carpentern.ttt.boards

import scala.collection.mutable.ListBuffer

class Board {
  def createGameBoard(boardSize: Int) = List.fill(boardSize)("")

  def countRows(gameBoard: List[String]): Int =
    math.sqrt(gameBoard.length).toInt

  def findRows(gameBoard: List[String]): List[List[Int]] = {
    val rowCount: Int = countRows(gameBoard)
    boardPositions(gameBoard).grouped(rowCount).toList
  }

  def findColumns(gameBoard: List[String]): List[List[Int]] = {
    val rows: List[List[Int]] = findRows(gameBoard)
    rows.transpose
  }

  def findDiagonals(gameBoard: List[String]): List[List[Int]] = {
    val rows: List[List[Int]] = findRows(gameBoard)
    List(findForwardsDiagonal(gameBoard, rows), findBackwardsDiagonal(gameBoard, rows))
  }

  def separateRows(gameBoard: List[String]): List[List[String]] = {
    val rowCount: Int = countRows(gameBoard)
    gameBoard.grouped(rowCount).toList
  }

  def findOpenSpaces(gameBoard: List[String]): List[Int] =
    gameBoard.zipWithIndex.collect{ case(x, i) if x == "" => i }

  def placePiece(gameBoard: List[String], space: Int, marker: String): List[String] =
    gameBoard.updated(space - 1, marker)

  def printableBoardPositions(boardPositions: List[Int]): List[String] =
    boardPositions.map((_ + 1)).map(_.toString)

  def boardPositions(gameBoard: List[String]): List[Int] =
    List.range(0, gameBoard.length)

  private def findForwardsDiagonal(gameBoard: List[String], rows: List[List[Int]]): List[Int] = {
    var diagonals = new ListBuffer[Int]()
    for (x <- 0 to rows.length - 1) {
      diagonals += rows(x)(x)
    }
    diagonals.toList
  }

  private def findBackwardsDiagonal(gameBoard: List[String], rows: List[List[Int]]): List[Int] = {
    var diagonals = new ListBuffer[Int]()
    for (x <- 0 to rows.length - 1) {
      diagonals += rows(x)((rows.length - 1) - x)
    }
    diagonals.toList
  }
}