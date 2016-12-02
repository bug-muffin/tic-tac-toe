package carpentern.ttt.game

import carpentern.ttt.players.Player

trait PlayerBuilder {
  def buildPlayer(name: String, marker: String) : Player
}