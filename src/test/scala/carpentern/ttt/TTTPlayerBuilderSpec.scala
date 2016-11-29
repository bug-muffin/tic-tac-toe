import org.scalatest.FunSpec
import org.scalatest.Matchers._
import scala.collection.immutable.HashMap
import carpentern.ttt.HumanMoveGenerator
import carpentern.ttt.Player
import carpentern.ttt.TTTPlayerBuilder

class TTTPlayerBuilderSpec extends FunSpec {
  val playerBuilder = new TTTPlayerBuilder()

  describe("#buildPlayer") {
    val name = "Player 1"
    val marker = "X"
    val view = new MockConsoleView()
    val generator = new HumanMoveGenerator(view)
    val player = playerBuilder.buildPlayer(name, marker, generator)

    it("should create a player") {
      player shouldBe a [Player]
    }

    it("should have a name") {
      player.name shouldBe a [String]
      assert(player.name == "Player 1")
    }

    it("should have a marker") {
      player.marker shouldBe a [String]
      assert(player.marker == "X")
    }

    it("should have a move generator") {
      player.moveGenerator shouldBe a [HumanMoveGenerator]
      assert(player.moveGenerator == generator)
    }
  }
}