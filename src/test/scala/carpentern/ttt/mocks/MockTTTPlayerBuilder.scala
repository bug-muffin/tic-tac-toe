import carpentern.ttt.game.MoveGenerator
import carpentern.ttt.game.PlayerBuilder
import carpentern.ttt.players.Player

class MockTTTPlayerBuilder extends PlayerBuilder {
  var mockGenerator = new MockMoveGenerator()
  var buildPlayerCalled = false

  def buildPlayer(name: String, marker: String) : Player = {
    buildPlayerCalled = true
    new Player(name, marker, mockGenerator)
  }
}