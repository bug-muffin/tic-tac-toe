package carpentern.ttt.players

import carpentern.ttt.game.MoveGenerator
import carpentern.ttt.game.PlayerBuilder

class TTTPlayerBuilder(humanMoveGenerator:MoveGenerator, computerMoveGenerator:MoveGenerator) extends PlayerBuilder {
  def buildPlayer(name: String, marker: String) : Player = {
    if (name != "Computer") {
      return new Player(name, marker, humanMoveGenerator)
    } else {
      return new Player(name, marker, computerMoveGenerator)
    }
  }
}