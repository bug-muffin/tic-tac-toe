import carpentern.ttt.Player
import carpentern.ttt.PlayerBuilder
import carpentern.ttt.MoveGenerator

class MockTTTPlayerBuilder extends PlayerBuilder {
  var mockGenerator = new MockMoveGenerator()
  var buildPlayerCalled = false

  def buildPlayer(name: String, marker: String) : Player = {
    buildPlayerCalled = true
    new Player(name, marker, mockGenerator)
  }
}