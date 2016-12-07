import carpentern.ttt.game.MoveGenerator
import carpentern.ttt.game.PlayerBuilder
import carpentern.ttt.players.Player
import carpentern.ttt.config.Marker

class MockTTTPlayerBuilder extends PlayerBuilder {
  var mockGenerator = new MockMoveGenerator()
  var buildPlayerCalled = false

  def buildPlayer(name: String, marker: Marker) : Player = {
    buildPlayerCalled = true
    new Player(name, marker, mockGenerator)
  }
}