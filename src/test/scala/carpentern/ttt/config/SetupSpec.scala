import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import org.scalatest.Matchers._
import carpentern.ttt.boards.Board
import carpentern.ttt.game.PlayerBuilder
import carpentern.ttt.players.HumanMoveGenerator
import carpentern.ttt.players.Player
import carpentern.ttt.config.Setup

class SetupSpec extends FunSpec with BeforeAndAfter {
  val markers = List("X", "O")
  val playerBuilder = new MockTTTPlayerBuilder()
  val view = new MockConsoleView()
  var setup: Setup = _

  before {
    setup = new Setup(playerBuilder, view)
  }

  describe("Setup") {
    describe("#setupBoard") {
      it("should clear the screen") {
        setup.setupBoard

        assert(view.clearScreenCalled)
      }

      it("should prompt the user for a board size") {
        val board = setup.setupBoard

        assert(view.promptOrderedOptionsCalled)
        assert(view.getOrderedOptionsSelectionCalled)
      }

      it("should return a board object") {
        val board = setup.setupBoard

        board shouldBe a [Board]
      }
    }

    describe("#setupPlayers") {
      it("should prompt the player for her method of play") {
        setup.setupPlayers(markers)

        assert(view.promptOrderedOptionsCalled)
        assert(view.getOrderedOptionsSelectionCalled)
      }

      it("should ask the player for her name") {
        setup.setupPlayers(markers)

        assert(view.getPlayerNameCalled)
      }

      it("should return a list of 2 player objects") {
        val players = setup.setupPlayers(markers)

        assert(players.length == 2)
        players(0) shouldBe a [Player]
        players(1) shouldBe a [Player]
      }
    }
  }
}
