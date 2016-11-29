import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import org.scalatest.Matchers._
import carpentern.ttt.HumanMoveGenerator
import carpentern.ttt.PlayerBuilder
import carpentern.ttt.Setup

class SetupSpec extends FunSpec with BeforeAndAfter {
  val playerBuilder = new MockTTTPlayerBuilder()
  var setup: Setup = _
  
  before {
    setup = new Setup(playerBuilder)
  }

  describe("#createPlayers") {
    it("should call payerBuilder's buildPlayer method") {
      val name = "Player 1"
      val marker = "X"
      val view = new MockConsoleView()
      val generator = new HumanMoveGenerator(view)
      val player = setup.createPlayer(name, marker, generator)

      assert(playerBuilder.buildPlayerCalled == true)
    }
  }
}