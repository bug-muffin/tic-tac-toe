package carpentern.ttt.validators

import carpentern.ttt.config.Marker

class NumberValidator {
  def isValidNumber(number: String, collection: List[Any]): Boolean =
    isNumeric(number) && isWithinBounds(number, collection)

  private def isNumeric(number: String): Boolean =
    !isBlank(number) && number.forall(_.isDigit)

  private def isBlank(number: String): Boolean =
    number.isEmpty || number.forall(_.isWhitespace)

  private def isWithinBounds(number: String, collection: List[Any]): Boolean =
    number.toInt > 0 && number.toInt <= collection.length
}