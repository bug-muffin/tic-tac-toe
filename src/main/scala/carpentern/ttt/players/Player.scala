package carpentern.ttt.players

import carpentern.ttt.game.MoveGenerator
import carpentern.ttt.config.Marker

class Player(playerName: String, playerMarker: Marker, playerMoveGenerator: MoveGenerator) {
  def name = playerName
  def marker = playerMarker
  def moveGenerator = playerMoveGenerator
}