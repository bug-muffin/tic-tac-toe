package carpentern.ttt

import scala.collection.immutable.HashMap

class Setup(playerBuilder: PlayerBuilder) {
  def createGameBoard(boardSize:Int) = {
    List.fill(boardSize)("")
  }

  def createPlayer(name:String, marker:String, generator:MoveGenerator) : Player = {
    playerBuilder.buildPlayer(name, marker, generator)
  }
}
