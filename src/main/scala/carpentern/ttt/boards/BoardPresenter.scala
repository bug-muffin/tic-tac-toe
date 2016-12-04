package carpentern.ttt.boards
import scala.collection.mutable.ListBuffer

class BoardPresenter {
  def formatBoardValuesToString(board: Board): String = formatToString(board, board.squares)

  def formatBoardPositionsToString(board: Board): String = {
    val boardPositions = board.boardPositions.map((_ + 1)).map(_.toString)
    formatToString(board, boardPositions)
  }

  private def formatToString(board: Board, squares: List[String]) : String = {
    val rowCount: Int = board.countRows
    val formattedBoard: List[String] = addLeadingSpaces(squares)
    var formattedRows = new ListBuffer[String]()
    val rows: List[List[String]] = separateRows(rowCount, formattedBoard)
    for ((x, i) <- rows.view.zipWithIndex) {
      formattedRows += (formatRow(x, rowCount) mkString)
      addHorizontalFillersBetweenRows(i, formattedRows, rowCount, formattedBoard)
    }
    formattedRows mkString
  }

  private def addLeadingSpaces(squares: List[String]): List[String] =
    squares.map( x => addSpace(x, squares))

  private def addSpace(placeholder: String, squares: List[String]): String =
    if (placeholder == "" || hasSomeTwoDigitSpaces(placeholder, squares))
      "  " + placeholder
    else
      " " + placeholder

  private def hasSomeTwoDigitSpaces(placeholder: String, squares: List[String]): Boolean =
    placeholder.length < 2 && hasMultipleDigits(squares, 1)

  private def hasMultipleDigits(board: List[String], limit: Int): Boolean =
    board.find(x => x.length > limit) != None

  private def separateRows(rowCount: Int, formattedBoard: List[String]) : List[List[String]] =
    formattedBoard.grouped(rowCount).toList

  private def formatRow(row: List[String], rowCount: Int): List[String] = {
    val verticalFillers: List[String] = constructVerticalFillers(rowCount)
    val filledRow: List[(String,String)] = constructFilledRow(row, verticalFillers)
    val flattenedRow: List[String] = flattenRow(filledRow)
    appendRowWithNewLine(flattenedRow)
  }

  private def constructVerticalFillers(rowCount: Int): List[String] = List.fill(rowCount)(" |")

  private def constructFilledRow(row: List[String], verticalFillers: List[String]): List[(String,String)] =
    row.zip(verticalFillers)

  private def flattenRow(filledRow: List[(String, String)]): List[String] =
    filledRow.flatMap(t => List(t._1, t._2)).dropRight(1)

  private def appendRowWithNewLine(flattenedRow: List[String]): List[String] = flattenedRow :+ "\n"

  private def addHorizontalFillersBetweenRows(index: Int,
                                              formattedRows: ListBuffer[String],
                                              rowCount: Int,
                                              formattedBoard: List[String]) = {
    if (index != rowCount - 1) {
      addHorizontalFillers(formattedRows, rowCount, formattedBoard)
    }
  }

  private def addHorizontalFillers(formattedRows: ListBuffer[String], rowCount: Int, formattedBoard: List[String]) = {
    val divider: String = createDivider(rowCount, formattedBoard)
    formattedRows += ((divider + ("+" + divider) * (rowCount - 1)))
    formattedRows += "\n"
  }

  private def createDivider(rowCount: Int, formattedBoard: List[String]): String = {
    if (formattedBoard.find(x => x.length > 2) == None && rowCount == 4)
      "=" * (rowCount - 1)
    else
      "=" * rowCount
  }
}
