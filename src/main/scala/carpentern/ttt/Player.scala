package carpentern.ttt

class Player(playerName:String, playerMarker:String, playerMoveGenerator: MoveGenerator) {
  def name() = playerName
  def marker() = playerMarker
  def moveGenerator() = playerMoveGenerator
}