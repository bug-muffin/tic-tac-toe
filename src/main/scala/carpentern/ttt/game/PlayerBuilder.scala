package carpentern.ttt.game

import carpentern.ttt.players.Player
import carpentern.ttt.config.Marker

trait PlayerBuilder {
  def buildPlayer(name: String, marker: Marker): Player
}