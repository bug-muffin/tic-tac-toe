package carpentern.ttt

class Board {
  def findOpenSpaces(board:List[String]) : List[Int] = {
    board.zipWithIndex.collect{ case(a, b) if a == "" => b }
  }

  def placePiece(board:List[String], space:Int, marker:String) : List[String] = {
    board.updated(space, marker)
  }
}