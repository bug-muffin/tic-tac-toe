import org.scalatest.FunSpec
import org.scalatest.Matchers._
import scala.collection.immutable.HashMap
import carpentern.ttt.config.{Marker,X,O}
import carpentern.ttt.game.GameRules
import carpentern.ttt.players.ComputerMoveGenerator
import carpentern.ttt.players.HumanMoveGenerator
import carpentern.ttt.players.Player
import carpentern.ttt.players.TTTPlayerBuilder

class TTTPlayerBuilderSpec extends FunSpec {
  val view = new MockConsoleView()
  val markers = List(X, O)
  val rules = new GameRules()
  val humanMoveGenerator = new HumanMoveGenerator(view)
  val computerMoveGenerator = new ComputerMoveGenerator(markers, rules)
  val playerBuilder = new TTTPlayerBuilder(humanMoveGenerator, computerMoveGenerator)

  describe("TTTPlayerBuilder") {
    describe("#buildPlayer") {
      val name = "Player 1"
      val marker = X
      val player = playerBuilder.buildPlayer(name, marker)

      it("should create a player") {
        player shouldBe a [Player]
      }

      it("should have a name") {
        player.name shouldBe a [String]
        assert(player.name == "Player 1")
      }

      it("should have a marker") {
        player.marker shouldBe a [Marker]
        assert(player.marker == X)
      }

      it("should have a move generator") {
        player.moveGenerator shouldBe a [HumanMoveGenerator]
        assert(player.moveGenerator == humanMoveGenerator)
      }
    }
  }
}