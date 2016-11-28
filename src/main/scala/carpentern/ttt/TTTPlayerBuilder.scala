package carpentern.ttt

class TTTPlayerBuilder extends PlayerBuilder {
  def buildPlayer(name: String, marker: String, generator: MoveGenerator) : Player = {
    new Player(name, marker, generator)
  }
}