package carpentern.ttt.boards

import scala.collection.mutable.ListBuffer

class BoardPresenter {
  def formatBoardToString(board:Board, gameBoard:List[String]) : String = {
    val rowCount: Int = board.countRows(gameBoard)
    val formattedBoard: List[String] = addLeadingSpaces(gameBoard)
    var formattedRows = new ListBuffer[String]()
    val rows: List[List[String]] = board.separateRows(formattedBoard)
    for ((x, i) <- rows.view.zipWithIndex) { 
      formattedRows += (formatRow(x, rowCount) mkString)
      addHorizontalFillersBetweenRows(i, formattedRows, rowCount, formattedBoard)
    }
    formattedRows mkString
  }

  private def addLeadingSpaces(gameBoard:List[String]) : List[String] = {
    gameBoard.map( x => addSpace(x, gameBoard))
  }

  private def addSpace(placeholder:String, gameBoard:List[String]) : String = {
    if (placeholder == "" || hasSomeTwoDigitSpaces(placeholder, gameBoard)) {
      return "  " + placeholder
    } else {
      return " " + placeholder
    }
  }

  private def hasSomeTwoDigitSpaces(placeholder:String, gameBoard:List[String]) : Boolean = {
    placeholder.length < 2 && hasMultipleDigits(gameBoard, 1)
  }

  private def hasMultipleDigits(board:List[String], limit:Int) : Boolean = {
    board.find(x => x.length > limit) != None
  }

  private def formatRow(row:List[String], rowCount:Int): List[String] = {
    val verticalFillers = constructVerticalFillers(rowCount)
    val filledRow = constructFilledRow(row, verticalFillers)
    val flattenedRow = flattenRow(filledRow)
    appendRowWithNewLine(flattenedRow)
  }

  private def constructVerticalFillers(rowCount:Int): List[String] = {
    List.fill(rowCount)(" |")
  }

  private def constructFilledRow(row:List[String], verticalFillers:List[String]) = {
    row zip verticalFillers
  }

  private def flattenRow(filledRow:List[(String, String)]) : List[String] = {
    filledRow.flatMap(t => List(t._1, t._2)).dropRight(1)
  }

  private def appendRowWithNewLine(flattenedRow:List[String]) : List[String] = {
    flattenedRow :+ "\n"
  }

  private def addHorizontalFillersBetweenRows(index:Int, formattedRows:ListBuffer[String], rowCount:Int, formattedBoard:List[String]) = {
    if (index != rowCount - 1) {
      addHorizontalFillers(formattedRows, rowCount, formattedBoard)
    }
  }

  private def addHorizontalFillers(formattedRows:ListBuffer[String], rowCount:Int, formattedBoard:List[String]) = {
    val divider = createDivider(rowCount, formattedBoard)
    formattedRows += ((divider + ("+" + divider) * (rowCount - 1)))
    formattedRows += "\n"
  }

  private def createDivider(rowCount:Int, formattedBoard:List[String]) : String = {
    if (formattedBoard.find(x => x.length > 2) == None && rowCount == 4) {
      return "=" * (rowCount - 1)
    } else {
      return "=" * rowCount
    }
  }
}
