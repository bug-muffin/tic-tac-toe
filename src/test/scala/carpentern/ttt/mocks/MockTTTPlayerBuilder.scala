import carpentern.ttt.Player
import carpentern.ttt.PlayerBuilder
import carpentern.ttt.MoveGenerator

class MockTTTPlayerBuilder extends PlayerBuilder {
  var buildPlayerCalled = false

  def buildPlayer(name: String, marker: String, generator: MoveGenerator) : Player = {
    buildPlayerCalled = true
    new Player(name, marker, generator)
  }
}