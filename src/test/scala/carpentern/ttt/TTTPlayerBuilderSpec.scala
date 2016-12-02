import org.scalatest.FunSpec
import org.scalatest.Matchers._
import scala.collection.immutable.HashMap
import carpentern.ttt.Board
import carpentern.ttt.ComputerMoveGenerator
import carpentern.ttt.HumanMoveGenerator
import carpentern.ttt.GameRules
import carpentern.ttt.Player
import carpentern.ttt.TTTPlayerBuilder

class TTTPlayerBuilderSpec extends FunSpec {
  val view = new MockConsoleView()
  val markers = List("X", "O")
  val board = new Board()
  val rules = new GameRules()
  val humanMoveGenerator = new HumanMoveGenerator(view)
  val computerMoveGenerator = new ComputerMoveGenerator(markers, board, rules)
  val playerBuilder = new TTTPlayerBuilder(humanMoveGenerator, computerMoveGenerator)

  describe("TTTPlayerBuilder") {
    describe("#buildPlayer") {
      val name = "Player 1"
      val marker = "X"
      val player = playerBuilder.buildPlayer(name, marker)

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
        assert(player.moveGenerator == humanMoveGenerator)
      }
    }
  }
}