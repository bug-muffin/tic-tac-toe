package carpentern.ttt.validators

class MoveValidator extends NumberValidator {
  def isValid(board: List[String], move: String): Boolean =
    isValidNumber(move, board) && isOpenSpace(move, board)

  override def isValidNumber(number: String, collection: List[String]): Boolean =
    super.isValidNumber(number, collection)

  private def isOpenSpace(move: String, board: List[String]): Boolean = board(move.toInt - 1) == ""
}