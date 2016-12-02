package carpentern.ttt.game

trait MoveGenerator {
  def selectSpace(board: List[String]): String
}