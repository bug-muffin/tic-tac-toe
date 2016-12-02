import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import org.scalatest.Matchers._
import carpentern.ttt.HumanMoveGenerator
import carpentern.ttt.Board
import carpentern.ttt.Player
import carpentern.ttt.PlayerBuilder
import carpentern.ttt.Setup

class SetupSpec extends FunSpec with BeforeAndAfter {
  val markers = List("X", "O")
  val board = new Board()
  val playerBuilder = new MockTTTPlayerBuilder()
  val view = new MockConsoleView()
  var setup: Setup = _
  
  before {
    setup = new Setup(playerBuilder, board, view)
  }

  describe("#setupBoard") {
    it("should clear the screen") {
      setup.setupBoard()

      assert(view.clearScreenCalled == true)
    }

    it("should prompt the user for a board size") {
      val board = setup.setupBoard()

      assert(view.promptOrderedOptionsCalled == true)
      assert(view.getOrderedOptionsSelectionCalled == true)
    }

    it("should return a board list") {
      val board = setup.setupBoard()

      board shouldBe a [List[_]]
    }
  }

  describe("#setupPlayers") {
    it("should prompt the player for her method of play") {
      setup.setupPlayers(markers)

      assert(view.promptOrderedOptionsCalled == true)
      assert(view.getOrderedOptionsSelectionCalled == true)
    }

    it("should ask the player for her name") {
      setup.setupPlayers(markers)

      assert(view.getPlayerNameCalled == true)
    }

    it("should return a list of 2 player objects") {
      val players = setup.setupPlayers(markers)

      assert(players.length == 2)
      players(0) shouldBe a [Player]
      players(1) shouldBe a [Player]
    }
  }
}