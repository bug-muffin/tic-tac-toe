package carpentern.ttt.players

import carpentern.ttt.game.MoveGenerator

class Player(playerName: String, playerMarker: String, playerMoveGenerator: MoveGenerator) {
  def name = playerName
  def marker = playerMarker
  def moveGenerator = playerMoveGenerator
}