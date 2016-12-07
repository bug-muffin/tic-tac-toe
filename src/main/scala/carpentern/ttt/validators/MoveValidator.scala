package carpentern.ttt.validators

import carpentern.ttt.config.{Marker,EMPTY}

class MoveValidator extends NumberValidator {
  def isValid(board: List[Marker], move: String): Boolean =
    isValidNumber(move, board) && isOpenSpace(move, board)

  override def isValidNumber(number: String, collection: List[Any]): Boolean =
    super.isValidNumber(number, collection)

  private def isOpenSpace(move: String, board: List[Marker]): Boolean = board(move.toInt - 1) == EMPTY
}