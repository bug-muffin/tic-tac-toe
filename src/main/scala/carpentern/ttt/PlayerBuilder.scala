package carpentern.ttt

trait PlayerBuilder {
  def buildPlayer(name: String, marker: String, generator: MoveGenerator) : Player
}