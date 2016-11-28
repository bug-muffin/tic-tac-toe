package carpentern.ttt

class MoveValidator {
  def isValid(board:List[String], move:String) : Boolean = {
    isValidNumber(move) && isValidSpace(board, move) && isOpenSpace(board, move)
  }

  private def isValidNumber(move:String) : Boolean = {
    !isBlank(move) && move.forall(_.isDigit)
  }

  private def isBlank(move:String) : Boolean = {
    move.isEmpty || move.forall(_.isWhitespace)
  }

  private def isValidSpace(board:List[String], move:String) : Boolean = {
    move.toInt > -1 && move.toInt < board.length
  }

  private def isOpenSpace(board:List[String], move:String) : Boolean = {
    board(move.toInt) == ""
  }
}